package com.teaching.stream;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StreamDebugExerciseTest {
    private StreamDebugExercise exercise = new StreamDebugExercise();

    @Test
    public void testSumEvenNumbers() {
        // Should return sum of (2*2 + 4*2 + 6*2 + 8*2 + 10*2) = 60
        assertEquals(60, exercise.sumEvenNumbers());
    }

    @Test
    public void testGetLongWords() {
        List<String> expected = Arrays.asList("BANANA", "ELDERBERRY");
        List<String> result = exercise.getLongWords();
        assertEquals(expected, result);
    }

    @Test
    public void testAverageOfLargeNumbers() {
        // Average of numbers > 5: (6 + 7 + 8 + 9 + 10) / 5 = 8.0
        assertEquals(8.0, exercise.averageOfLargeNumbers());
    }

    @Test
    public void testJoinWords() {
        String expected = "apple,banana,cherry,date,elderberry";
        assertEquals(expected, exercise.joinWords());
    }

    @Test
    public void testAreAllPositive() {
        assertTrue(exercise.areAllPositive());
    }

    @Test
    public void testWordLengthMap() {
        Map<String, Integer> result = exercise.wordLengthMap();
        assertEquals(5, result.get("apple"));
        assertEquals(6, result.get("banana"));
        assertEquals(6, result.get("cherry"));
        assertEquals(4, result.get("date"));
        assertEquals(10, result.get("elderberry"));
    }

    @Test
    public void testGetAdultNames() {
        List<String> expected = Arrays.asList("John", "Bob", "Dave");
        List<String> result = exercise.getAdultNames();
        assertEquals(expected, result);
    }

    @Test
    public void testFindFirstDivisibleByThree() {
        Optional<Integer> result = exercise.findFirstDivisibleByThree();
        assertTrue(result.isPresent());
        assertEquals(3, result.get());
    }

    @Test
    public void testGetSortedSquares() {
        List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);
        List<Integer> result = exercise.getSortedSquares();
        assertEquals(expected, result);
    }

    @Test
    public void testCountWordsWithA() {
        // Should count "apple", "banana", "date" = 3
        assertEquals(3, exercise.countWordsWithA());
    }
} 