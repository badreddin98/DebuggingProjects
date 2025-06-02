import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import axios from 'axios';
import App from './App';
import { Todo } from './types/todo';

jest.mock('axios');
const mockedAxios = axios as jest.Mocked<typeof axios>;

describe('App', () => {
  const mockTodos: Todo[] = [
    { id: 1, title: 'Test Todo 1', completed: false },
    { id: 2, title: 'Test Todo 2', completed: true }
  ];

  beforeEach(() => {
    mockedAxios.get.mockResolvedValue({ data: mockTodos });
  });

  test('renders todo list', async () => {
    render(<App />);
    
    await waitFor(() => {
      expect(screen.getByText('Test Todo 1')).toBeInTheDocument();
      expect(screen.getByText('Test Todo 2')).toBeInTheDocument();
    });
  });

  test('adds new todo', async () => {
    const newTodo: Todo = { id: 3, title: 'New Todo', completed: false };
    mockedAxios.post.mockResolvedValue({ data: newTodo });

    render(<App />);
    
    const input = screen.getByPlaceholderText('Add a new todo');
    const addButton = screen.getByText('Add');

    await userEvent.type(input, 'New Todo');
    fireEvent.click(addButton);

    await waitFor(() => {
      expect(mockedAxios.post).toHaveBeenCalledWith(
        'http://localhost:8080/api/todos',
        { title: 'New Todo', completed: false }
      );
      expect(screen.getByText('New Todo')).toBeInTheDocument();
    });
  });

  test('toggles todo completion', async () => {
    const updatedTodo: Todo = { id: 1, title: 'Test Todo 1', completed: true };
    mockedAxios.put.mockResolvedValue({ data: updatedTodo });

    render(<App />);
    
    await waitFor(() => {
      const checkbox = screen.getAllByRole('checkbox')[0];
      fireEvent.click(checkbox);
    });

    await waitFor(() => {
      expect(mockedAxios.put).toHaveBeenCalledWith(
        'http://localhost:8080/api/todos/1',
        expect.any(Object)
      );
    });
  });

  test('deletes todo', async () => {
    mockedAxios.delete.mockResolvedValue({});

    render(<App />);
    
    await waitFor(() => {
      const deleteButtons = screen.getAllByText('Delete');
      fireEvent.click(deleteButtons[0]);
    });

    await waitFor(() => {
      expect(mockedAxios.delete).toHaveBeenCalledWith('http://localhost:8080/api/todos/1');
      expect(screen.queryByText('Test Todo 1')).not.toBeInTheDocument();
    });
  });
}); 