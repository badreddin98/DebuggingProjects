package com.teaching.collections.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.function.Predicate;

public class SetDebugExerciseTest {
    private SetDebugExercise exercise;

    @BeforeEach
    void setUp() {
        exercise = new SetDebugExercise();
    }

    @Test
    void testAddToHashSet() {
        assertTrue(exercise.addToHashSet("orange"));
        assertFalse(exercise.addToHashSet("apple"));
        assertThrows(NullPointerException.class, () -> exercise.addToHashSet(null));
    }

    @Test
    void testFindSmallestInTreeSet() {
        assertEquals(1, exercise.findSmallestInTreeSet());
        exercise.treeSet.clear();
        assertThrows(NoSuchElementException.class, () -> exercise.findSmallestInTreeSet());
    }

    @Test
    void testRemoveGreaterThan() {
        exercise.removeGreaterThan(3);
        Set<Integer> expected = new TreeSet<>(Arrays.asList(1, 2, 3));
        assertEquals(expected, exercise.treeSet);
    }

    @Test
    void testIsOrdered() {
        assertTrue(exercise.isOrdered());
        exercise.linkedHashSet = new LinkedHashSet<>(Arrays.asList(5.5, 1.1, 3.3, 2.2, 4.4));
        assertFalse(exercise.isOrdered());
    }

    @Test
    void testFindCommonElements() {
        Set<String> otherSet = new HashSet<>(Arrays.asList("banana", "cherry", "date"));
        Set<String> result = exercise.findCommonElements(otherSet);
        Set<String> expected = new HashSet<>(Arrays.asList("banana", "cherry"));
        assertEquals(expected, result);
    }

    @Test
    void testGetElementsInRange() {
        Set<Integer> result = exercise.getElementsInRange(2, 4);
        Set<Integer> expected = new TreeSet<>(Arrays.asList(2, 3));
        assertEquals(expected, result);
    }

    @Test
    void testToOrderedArray() {
        Double[] result = exercise.toOrderedArray();
        Double[] expected = {1.1, 2.2, 3.3, 4.4, 5.5};
        assertArrayEquals(expected, result);
    }

    @Test
    void testContainsAll() {
        Set<String> otherSet = new HashSet<>(Arrays.asList("apple", "banana"));
        assertTrue(exercise.containsAll(otherSet));
        otherSet.add("date");
        assertFalse(exercise.containsAll(otherSet));
        assertThrows(NullPointerException.class, () -> exercise.containsAll(null));
    }

    @Test
    void testGetLastElement() {
        assertEquals(5, exercise.getLastElement());
        exercise.treeSet.clear();
        assertThrows(NoSuchElementException.class, () -> exercise.getLastElement());
    }

    @Test
    void testRemoveIf() {
        exercise.removeIf(d -> d > 3.0);
        Set<Double> expected = new LinkedHashSet<>(Arrays.asList(1.1, 2.2, 3.3));
        assertEquals(expected, exercise.linkedHashSet);
    }
} 