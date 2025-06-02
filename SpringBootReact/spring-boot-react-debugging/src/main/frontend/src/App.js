import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  // Bug 1: Missing loading state
  const [todos, setTodos] = useState([]);
  const [newTodo, setNewTodo] = useState('');

  // Bug 2: Missing error state
  // Bug 3: Missing cleanup in useEffect
  useEffect(() => {
    fetchTodos();
  }, []);

  // Bug 4: Missing error handling
  // Bug 5: Missing loading state management
  const fetchTodos = async () => {
    const response = await axios.get('http://localhost:8080/api/todos');
    setTodos(response.data);
  };

  // Bug 6: Missing form validation
  // Bug 7: Missing error handling
  // Bug 8: Missing loading state
  const addTodo = async (e) => {
    e.preventDefault();
    if (!newTodo.trim()) return;

    const response = await axios.post('http://localhost:8080/api/todos', {
      title: newTodo,
      completed: false
    });
    setTodos([...todos, response.data]);
    setNewTodo('');
  };

  // Bug 9: Missing error handling
  // Bug 10: Missing loading state
  // Bug 11: Missing optimistic updates
  const toggleTodo = async (id, completed) => {
    const todo = todos.find(t => t.id === id);
    const response = await axios.put(`http://localhost:8080/api/todos/${id}`, {
      ...todo,
      completed: !completed
    });
    setTodos(todos.map(t => t.id === id ? response.data : t));
  };

  // Bug 12: Missing error handling
  // Bug 13: Missing loading state
  // Bug 14: Missing confirmation dialog
  const deleteTodo = async (id) => {
    await axios.delete(`http://localhost:8080/api/todos/${id}`);
    setTodos(todos.filter(t => t.id !== id));
  };

  // Bug 15: Missing error messages
  // Bug 16: Missing loading indicators
  // Bug 17: Missing empty state
  // Bug 18: Missing accessibility attributes
  return (
    <div className="App">
      <h1>Todo App</h1>
      <form onSubmit={addTodo}>
        <input
          type="text"
          value={newTodo}
          onChange={(e) => setNewTodo(e.target.value)}
          placeholder="Add a new todo"
        />
        <button type="submit">Add</button>
      </form>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>
            <input
              type="checkbox"
              checked={todo.completed}
              onChange={() => toggleTodo(todo.id, todo.completed)}
            />
            <span style={{ textDecoration: todo.completed ? 'line-through' : 'none' }}>
              {todo.title}
            </span>
            <button onClick={() => deleteTodo(todo.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App; 