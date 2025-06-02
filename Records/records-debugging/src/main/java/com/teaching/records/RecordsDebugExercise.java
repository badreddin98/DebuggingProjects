package com.teaching.records;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class RecordsDebugExercise {
    // Bug 1: Incorrect record declaration
    public record Person(String name, int age) {
        public Person {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        }
    }

    // Bug 2: Incorrect record with nested record
    public record Address(String street, String city, String country) {
        public record Coordinates(double latitude, double longitude) {}
    }

    // Bug 3: Incorrect record with custom methods
    public record Student(String name, List<Integer> grades) {
        public double getAverageGrade() {
            return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        }
    }

    // Bug 4: Incorrect record with validation
    public record Email(String address) {
        public Email {
            if (!address.contains("@")) {
                throw new IllegalArgumentException("Invalid email address");
            }
        }
    }

    // Bug 5: Incorrect record with inheritance
    public record Employee(String name, double salary) extends Person {
        public Employee {
            super(name, 0);
        }
    }

    // Bug 6: Incorrect record with mutable fields
    public record MutablePoint(int x, int y) {
        public void setX(int newX) {
            this.x = newX;
        }
    }

    // Bug 7: Incorrect record with static fields
    public record Configuration(String key, String value) {
        private static final String DEFAULT_VALUE = "default";
    }

    // Bug 8: Incorrect record with equals/hashCode
    public record Point(int x, int y) {
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point p) {
                return x == p.x && y == p.y;
            }
            return false;
        }
    }

    // Bug 9: Incorrect record with serialization
    public record SerializablePerson(String name, LocalDate birthDate) implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
    }

    // Bug 10: Incorrect record with generics
    public record Pair<T, U>(T first, U second) {
        public <V> Pair<V, U> mapFirst(Function<T, V> mapper) {
            return new Pair<>(mapper.apply(first), second);
        }
    }
} 