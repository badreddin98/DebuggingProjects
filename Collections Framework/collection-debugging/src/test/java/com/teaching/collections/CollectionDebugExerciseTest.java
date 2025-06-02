package com.teaching.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CollectionDebugExerciseTest {
    private CollectionDebugExercise exercise;

    @BeforeEach
    void setUp() {
        exercise = new CollectionDebugExercise();
    }

    @Test
    void testRemoveEvenNumbers() {
        exercise.removeEvenNumbers();
        List<Integer> expected = Arrays.asList(1, 3, 5);
        assertEquals(expected, exercise.numbers);
    }

    @Test
    void testAddUniqueWord() {
        assertTrue(exercise.addUniqueWord("orange"));
        assertFalse(exercise.addUniqueWord("apple"));
        assertThrows(NullPointerException.class, () -> exercise.addUniqueWord(null));
    }

    @Test
    void testCountWords() {
        List<String> wordList = Arrays.asList("apple", "banana", "apple", "cherry", "apple");
        exercise.countWords(wordList);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("apple", 3);
        expected.put("banana", 1);
        expected.put("cherry", 1);
        assertEquals(expected, exercise.wordCount);
    }

    @Test
    void testProcessTasks() {
        List<String> completed = exercise.processTasks();
        List<String> expected = Arrays.asList("task1", "task2", "task3");
        assertEquals(expected, completed);
        assertTrue(exercise.tasks.isEmpty());
    }

    @Test
    void testReverseDeque() {
        exercise.reverseDeque();
        Deque<Integer> expected = new LinkedList<>(Arrays.asList(5, 4, 3, 2, 1));
        assertEquals(expected, exercise.numbersDeque);
    }

    @Test
    void testFindMax() {
        List<Integer> list = Arrays.asList(1, 5, 3, 8, 2);
        assertEquals(8, exercise.findMax(list));
        assertThrows(IndexOutOfBoundsException.class, () -> exercise.findMax(new ArrayList<>()));
    }

    @Test
    void testMergeMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("b", 3);
        map2.put("c", 4);
        Map<String, Integer> result = exercise.mergeMaps(map1, map2);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("b", 5);
        expected.put("c", 4);
        assertEquals(expected, result);
    }

    @Test
    void testIsSorted() {
        List<Integer> sorted = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> unsorted = Arrays.asList(1, 3, 2, 4, 5);
        assertTrue(exercise.isSorted(sorted));
        assertFalse(exercise.isSorted(unsorted));
    }

    @Test
    void testRemoveDuplicates() {
        List<String> list = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        List<String> result = exercise.removeDuplicates(list);
        List<String> expected = Arrays.asList("apple", "banana", "cherry");
        assertEquals(expected, result);
    }

    @Test
    void testFindCommonElements() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> result = exercise.findCommonElements(list1, list2);
        List<Integer> expected = Arrays.asList(4, 5);
        assertEquals(expected, result);
    }
} 