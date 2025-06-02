import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import axios from 'axios';
import App from './App';

jest.mock('axios');

describe('App', () => {
  beforeEach(() => {
    axios.get.mockResolvedValue({
      data: [
        { id: 1, title: 'Test Todo 1', completed: false },
        { id: 2, title: 'Test Todo 2', completed: true }
      ]
    });
  });

  test('renders todo list', async () => {
    render(<App />);
    
    await waitFor(() => {
      expect(screen.getByText('Test Todo 1')).toBeInTheDocument();
      expect(screen.getByText('Test Todo 2')).toBeInTheDocument();
    });
  });

  test('adds new todo', async () => {
    const newTodo = { id: 3, title: 'New Todo', completed: false };
    axios.post.mockResolvedValue({ data: newTodo });

    render(<App />);
    
    const input = screen.getByPlaceholderText('Add a new todo');
    const addButton = screen.getByText('Add');

    await userEvent.type(input, 'New Todo');
    fireEvent.click(addButton);

    await waitFor(() => {
      expect(axios.post).toHaveBeenCalledWith(
        'http://localhost:8080/api/todos',
        { title: 'New Todo', completed: false }
      );
      expect(screen.getByText('New Todo')).toBeInTheDocument();
    });
  });

  test('toggles todo completion', async () => {
    const updatedTodo = { id: 1, title: 'Test Todo 1', completed: true };
    axios.put.mockResolvedValue({ data: updatedTodo });

    render(<App />);
    
    await waitFor(() => {
      const checkbox = screen.getAllByRole('checkbox')[0];
      fireEvent.click(checkbox);
    });

    await waitFor(() => {
      expect(axios.put).toHaveBeenCalledWith(
        'http://localhost:8080/api/todos/1',
        expect.any(Object)
      );
    });
  });

  test('deletes todo', async () => {
    axios.delete.mockResolvedValue({});

    render(<App />);
    
    await waitFor(() => {
      const deleteButtons = screen.getAllByText('Delete');
      fireEvent.click(deleteButtons[0]);
    });

    await waitFor(() => {
      expect(axios.delete).toHaveBeenCalledWith('http://localhost:8080/api/todos/1');
      expect(screen.queryByText('Test Todo 1')).not.toBeInTheDocument();
    });
  });
}); 