package com.teaching.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class ExceptionDebugExerciseTest {
    private ExceptionDebugExercise exercise;
    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        exercise = new ExceptionDebugExercise();
    }

    @Test
    void testReadFile() throws IOException {
        // Create a test file
        File testFile = tempDir.resolve("test.txt").toFile();
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("test content");
        }

        String content = exercise.readFile(testFile.getPath());
        assertEquals("test content", content);

        assertThrows(FileNotFoundException.class, () -> 
            exercise.readFile("nonexistent.txt"));
    }

    @Test
    void testParseInteger() {
        assertEquals(123, exercise.parseInteger("123"));
        assertThrows(NumberFormatException.class, () -> 
            exercise.parseInteger("abc"));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, exercise.divide(6, 3));
        assertThrows(ArithmeticException.class, () -> 
            exercise.divide(6, 0));
    }

    @Test
    void testGetElement() {
        exercise.data = Arrays.asList("a", "b", "c");
        assertEquals("b", exercise.getElement(1));
        assertThrows(IndexOutOfBoundsException.class, () -> 
            exercise.getElement(5));
    }

    @Test
    void testUpdateCount() {
        exercise.counts.put("test", 1);
        exercise.updateCount("test");
        assertEquals(2, exercise.counts.get("test"));

        assertThrows(NullPointerException.class, () -> 
            exercise.updateCount("nonexistent"));
    }

    @Test
    void testCreateDirectory() {
        File dir = tempDir.resolve("testdir").toFile();
        exercise.createDirectory(dir.getPath());
        assertTrue(dir.exists());

        // Should not throw exception if directory already exists
        exercise.createDirectory(dir.getPath());
    }

    @Test
    void testParseDate() {
        assertThrows(IllegalArgumentException.class, () -> 
            exercise.parseDate("invalid-date"));
    }

    @Test
    void testCopyFile() throws IOException {
        // Create source file
        File source = tempDir.resolve("source.txt").toFile();
        try (FileWriter writer = new FileWriter(source)) {
            writer.write("test content");
        }

        // Create destination file
        File dest = tempDir.resolve("dest.txt").toFile();

        exercise.copyFile(source.getPath(), dest.getPath());
        assertTrue(dest.exists());

        assertThrows(FileNotFoundException.class, () -> 
            exercise.copyFile("nonexistent.txt", dest.getPath()));
    }

    @Test
    void testValidateEmail() {
        assertTrue(exercise.validateEmail("test@example.com"));
        assertFalse(exercise.validateEmail("invalid-email"));
        assertFalse(exercise.validateEmail("test@"));
        assertFalse(exercise.validateEmail("@example.com"));
    }

    @Test
    void testProcessNumbers() {
        List<String> validNumbers = Arrays.asList("1", "2", "3");
        List<Integer> result = exercise.processNumbers(validNumbers);
        assertEquals(Arrays.asList(1, 2, 3), result);

        List<String> invalidNumbers = Arrays.asList("1", "abc", "3");
        assertThrows(NumberFormatException.class, () -> 
            exercise.processNumbers(invalidNumbers));
    }
} 