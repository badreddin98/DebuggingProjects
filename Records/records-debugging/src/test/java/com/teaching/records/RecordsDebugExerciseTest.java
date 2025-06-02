package com.teaching.records;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class RecordsDebugExerciseTest {
    private final RecordsDebugExercise exercise = new RecordsDebugExercise();

    @Test
    void testPerson() {
        RecordsDebugExercise.Person person = new RecordsDebugExercise.Person("John", 30);
        assertEquals("John", person.name());
        assertEquals(30, person.age());
        assertThrows(IllegalArgumentException.class, () -> 
            new RecordsDebugExercise.Person("John", -1));
    }

    @Test
    void testAddress() {
        RecordsDebugExercise.Address address = new RecordsDebugExercise.Address("123 Main St", "New York", "USA");
        assertEquals("123 Main St", address.street());
        assertEquals("New York", address.city());
        assertEquals("USA", address.country());
    }

    @Test
    void testStudent() {
        List<Integer> grades = Arrays.asList(85, 90, 95);
        RecordsDebugExercise.Student student = new RecordsDebugExercise.Student("Alice", grades);
        assertEquals("Alice", student.name());
        assertEquals(grades, student.grades());
        assertEquals(90.0, student.getAverageGrade());
    }

    @Test
    void testEmail() {
        RecordsDebugExercise.Email email = new RecordsDebugExercise.Email("test@example.com");
        assertEquals("test@example.com", email.address());
        assertThrows(IllegalArgumentException.class, () -> 
            new RecordsDebugExercise.Email("invalid-email"));
    }

    @Test
    void testEmployee() {
        RecordsDebugExercise.Employee employee = new RecordsDebugExercise.Employee("Bob", 50000.0);
        assertEquals("Bob", employee.name());
        assertEquals(50000.0, employee.salary());
    }

    @Test
    void testMutablePoint() {
        RecordsDebugExercise.MutablePoint point = new RecordsDebugExercise.MutablePoint(1, 2);
        assertEquals(1, point.x());
        assertEquals(2, point.y());
    }

    @Test
    void testConfiguration() {
        RecordsDebugExercise.Configuration config = new RecordsDebugExercise.Configuration("key", "value");
        assertEquals("key", config.key());
        assertEquals("value", config.value());
    }

    @Test
    void testPoint() {
        RecordsDebugExercise.Point point1 = new RecordsDebugExercise.Point(1, 2);
        RecordsDebugExercise.Point point2 = new RecordsDebugExercise.Point(1, 2);
        RecordsDebugExercise.Point point3 = new RecordsDebugExercise.Point(2, 3);
        assertEquals(point1, point2);
        assertNotEquals(point1, point3);
    }

    @Test
    void testSerializablePerson() {
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        RecordsDebugExercise.SerializablePerson person = 
            new RecordsDebugExercise.SerializablePerson("John", birthDate);
        assertEquals("John", person.name());
        assertEquals(birthDate, person.birthDate());
    }

    @Test
    void testPair() {
        RecordsDebugExercise.Pair<String, Integer> pair = 
            new RecordsDebugExercise.Pair<>("test", 42);
        assertEquals("test", pair.first());
        assertEquals(42, pair.second());
        
        Function<String, Integer> mapper = String::length;
        RecordsDebugExercise.Pair<Integer, Integer> mappedPair = pair.mapFirst(mapper);
        assertEquals(4, mappedPair.first());
        assertEquals(42, mappedPair.second());
    }
} 