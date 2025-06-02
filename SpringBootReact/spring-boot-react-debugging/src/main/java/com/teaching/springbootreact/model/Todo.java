package com.teaching.springbootreact.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Bug 1: Should be IDENTITY
    private Long id;

    // Bug 2: Missing @NotBlank annotation
    private String title;

    // Bug 3: Missing default value
    private boolean completed;

    // Bug 4: Missing audit fields (createdAt, updatedAt)

    // Bug 5: Missing toString() override (Lombok @Data should handle this, but it's a common issue)

    // Bug 6: Missing equals() and hashCode() override (Lombok @Data should handle this, but it's a common issue)

    // Bug 7: Missing validation for title length
    // Bug 8: Missing validation for title pattern (e.g., no special characters)
    // Bug 9: Missing validation for title uniqueness
    // Bug 10: Missing validation for title case (e.g., first letter capitalized)
} 