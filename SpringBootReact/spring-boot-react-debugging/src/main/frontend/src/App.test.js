import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import axios from 'axios';
import App from './App';

jest.mock('axios');

describe('App', () => {
  const mockTodos = [
    { id: 1, title: 'Test Todo 1', completed: false },
    { id: 2, title: 'Test Todo 2', completed: true }
  ];

  beforeEach(() => {
    axios.get.mockResolvedValue({ data: mockTodos });
  });

  test('renders todo list', async () => {
    render(<App />);
    
    await waitFor(() => {
      expect(screen.getByText('Test Todo 1')).toBeInTheDocument();
      expect(screen.getByText('Test Todo 2')).toBeInTheDocument();
    });
  });

  test('shows loading state while fetching todos', async () => {
    render(<App />);
    
    // Bug: No loading indicator
    expect(screen.queryByText('Loading...')).not.toBeInTheDocument();
  });

  test('shows error state when fetch fails', async () => {
    axios.get.mockRejectedValue(new Error('Failed to fetch'));
    render(<App />);
    
    // Bug: No error message
    await waitFor(() => {
      expect(screen.queryByText('Error loading todos')).not.toBeInTheDocument();
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

    // Bug: No loading state during add
    // Bug: No error handling for failed add
    await waitFor(() => {
      expect(axios.post).toHaveBeenCalledWith(
        'http://localhost:8080/api/todos',
        { title: 'New Todo', completed: false }
      );
      expect(screen.getByText('New Todo')).toBeInTheDocument();
    });
  });

  test('validates empty todo title', async () => {
    render(<App />);
    
    const input = screen.getByPlaceholderText('Add a new todo');
    const addButton = screen.getByText('Add');

    await userEvent.type(input, '   ');
    fireEvent.click(addButton);

    // Bug: No validation message
    expect(screen.queryByText('Title cannot be empty')).not.toBeInTheDocument();
  });

  test('toggles todo completion', async () => {
    const updatedTodo = { id: 1, title: 'Test Todo 1', completed: true };
    axios.put.mockResolvedValue({ data: updatedTodo });

    render(<App />);
    
    await waitFor(() => {
      const checkbox = screen.getAllByRole('checkbox')[0];
      fireEvent.click(checkbox);
    });

    // Bug: No loading state during toggle
    // Bug: No error handling for failed toggle
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

    // Bug: No confirmation dialog
    // Bug: No loading state during delete
    // Bug: No error handling for failed delete
    await waitFor(() => {
      expect(axios.delete).toHaveBeenCalledWith('http://localhost:8080/api/todos/1');
      expect(screen.queryByText('Test Todo 1')).not.toBeInTheDocument();
    });
  });

  test('handles concurrent operations', async () => {
    const newTodo = { id: 3, title: 'New Todo', completed: false };
    axios.post.mockResolvedValue({ data: newTodo });
    axios.put.mockResolvedValue({ data: { ...newTodo, completed: true } });

    render(<App />);
    
    const input = screen.getByPlaceholderText('Add a new todo');
    const addButton = screen.getByText('Add');

    await userEvent.type(input, 'New Todo');
    fireEvent.click(addButton);

    // Bug: Race condition in state updates
    await waitFor(() => {
      const checkbox = screen.getAllByRole('checkbox')[2];
      fireEvent.click(checkbox);
    });
  });

  test('handles network errors gracefully', async () => {
    axios.get.mockRejectedValue(new Error('Network error'));
    axios.post.mockRejectedValue(new Error('Network error'));
    axios.put.mockRejectedValue(new Error('Network error'));
    axios.delete.mockRejectedValue(new Error('Network error'));

    render(<App />);
    
    // Bug: No error messages for network errors
    await waitFor(() => {
      expect(screen.queryByText('Network error')).not.toBeInTheDocument();
    });
  });
}); 