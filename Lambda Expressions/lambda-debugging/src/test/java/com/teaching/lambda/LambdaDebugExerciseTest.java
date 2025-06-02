package com.teaching.lambda;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LambdaDebugExerciseTest {
    private final LambdaDebugExercise exercise = new LambdaDebugExercise();

    @Test
    public void testFilterNumbers() {
        List<Integer> numbers = Arrays.asList(-2, -1, 0, 1, 2);
        List<Integer> result = exercise.filterNumbers(numbers);
        assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    public void testMapToStrings() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<String> result = exercise.mapToStrings(numbers);
        assertEquals(Arrays.asList("1", "2", "3"), result);
    }

    @Test
    public void testAllPositive() {
        List<Integer> positiveNumbers = Arrays.asList(1, 2, 3);
        List<Integer> mixedNumbers = Arrays.asList(-1, 0, 1);
        
        assertTrue(exercise.allPositive(positiveNumbers));
        assertFalse(exercise.allPositive(mixedNumbers));
    }

    @Test
    public void testPrintNumbers() {
        // This test just verifies the method doesn't throw an exception
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        exercise.printNumbers(numbers);
    }

    @Test
    public void testDoubleNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> result = exercise.doubleNumbers(numbers);
        assertEquals(Arrays.asList(2, 4, 6), result);
    }

    @Test
    public void testGenerateNumbers() {
        List<Integer> result = exercise.generateNumbers(3);
        assertEquals(3, result.size());
        result.forEach(n -> assertTrue(n >= 0 && n < 100));
    }

    @Test
    public void testSumNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int result = exercise.sumNumbers(numbers);
        assertEquals(15, result);
    }

    @Test
    public void testSortStrings() {
        List<String> strings = Arrays.asList("banana", "apple", "cherry");
        List<String> result = exercise.sortStrings(strings);
        assertEquals(Arrays.asList("apple", "banana", "cherry"), result);
    }

    @Test
    public void testIncrementNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> result = exercise.incrementNumbers(numbers);
        assertEquals(Arrays.asList(2, 3, 4), result);
    }

    @Test
    public void testProcessNumbers() {
        List<Integer> numbers = Arrays.asList(-2, -1, 0, 1, 1, 2, 3);
        List<Integer> result = exercise.processNumbers(numbers);
        assertEquals(Arrays.asList(2, 4, 6), result);
    }
} 