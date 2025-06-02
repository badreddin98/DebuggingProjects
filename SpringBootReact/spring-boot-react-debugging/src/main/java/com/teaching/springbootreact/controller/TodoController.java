package com.teaching.springbootreact.controller;

import com.teaching.springbootreact.model.Todo;
import com.teaching.springbootreact.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
// Bug 1: Missing CORS configuration
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    // Bug 2: Missing pagination support
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

    @PostMapping
    // Bug 3: Missing @Valid annotation
    // Bug 4: Missing proper response status code
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PutMapping("/{id}")
    // Bug 5: Missing validation for path variable
    // Bug 6: Missing proper error handling
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.findById(id)
                .map(existingTodo -> {
                    // Bug 7: Incorrect update logic (should merge changes)
                    todo.setId(id);
                    return ResponseEntity.ok(todoService.save(todo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    // Bug 8: Missing validation for path variable
    // Bug 9: Missing proper error handling
    // Bug 10: Missing proper response status code
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        return todoService.findById(id)
                .map(todo -> {
                    todoService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Bug 11: Missing exception handling
    // Bug 12: Missing input validation
    // Bug 13: Missing logging
    // Bug 14: Missing security checks
    // Bug 15: Missing API documentation
} 