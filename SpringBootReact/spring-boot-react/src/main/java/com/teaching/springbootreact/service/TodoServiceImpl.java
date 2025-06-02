package com.teaching.springbootreact.service;

import com.teaching.springbootreact.model.Todo;
import com.teaching.springbootreact.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        // Bug 1: No sorting or pagination, could cause performance issues
        return todoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Todo> findById(Long id) {
        // Bug 2: No null/negative id check
        return todoRepository.findById(id);
    }

    @Override
    public Todo save(Todo todo) {
        // Bug 3: No validation for duplicate titles
        // Bug 4: No business logic for trimming title or normalizing case
        return todoRepository.save(todo);
    }

    @Override
    public void deleteById(Long id) {
        // Bug 5: No check if todo exists before deleting
        todoRepository.deleteById(id);
    }

    // Bug 6: No logging for important operations
    // Bug 7: No exception handling for repository errors
    // Bug 8: No audit (createdAt/updatedAt) management
    // Bug 9: No transaction rollback on failure
    // Bug 10: No method for partial update (PATCH)
} 