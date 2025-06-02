package com.teaching.springbootreact.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teaching.springbootreact.model.Todo;
import com.teaching.springbootreact.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TodoService todoService;

    @Test
    void getAllTodos_ShouldReturnTodos() throws Exception {
        Todo todo1 = new Todo();
        todo1.setId(1L);
        todo1.setTitle("Test Todo 1");

        Todo todo2 = new Todo();
        todo2.setId(2L);
        todo2.setTitle("Test Todo 2");

        when(todoService.findAll()).thenReturn(Arrays.asList(todo1, todo2));

        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Test Todo 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Test Todo 2"));
    }

    @Test
    void createTodo_ShouldReturnCreatedTodo() throws Exception {
        Todo todo = new Todo();
        todo.setTitle("New Todo");

        when(todoService.save(any(Todo.class))).thenAnswer(i -> {
            Todo savedTodo = i.getArgument(0);
            savedTodo.setId(1L);
            return savedTodo;
        });

        mockMvc.perform(post("/api/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("New Todo"));
    }

    @Test
    void updateTodo_WhenTodoExists_ShouldReturnUpdatedTodo() throws Exception {
        Todo existingTodo = new Todo();
        existingTodo.setId(1L);
        existingTodo.setTitle("Existing Todo");

        Todo updatedTodo = new Todo();
        updatedTodo.setTitle("Updated Todo");

        when(todoService.findById(1L)).thenReturn(Optional.of(existingTodo));
        when(todoService.save(any(Todo.class))).thenAnswer(i -> {
            Todo savedTodo = i.getArgument(0);
            savedTodo.setId(1L);
            return savedTodo;
        });

        mockMvc.perform(put("/api/todos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedTodo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Updated Todo"));
    }

    @Test
    void deleteTodo_WhenTodoExists_ShouldReturnNoContent() throws Exception {
        Todo existingTodo = new Todo();
        existingTodo.setId(1L);
        existingTodo.setTitle("Existing Todo");

        when(todoService.findById(1L)).thenReturn(Optional.of(existingTodo));

        mockMvc.perform(delete("/api/todos/1"))
                .andExpect(status().isOk());
    }
} 