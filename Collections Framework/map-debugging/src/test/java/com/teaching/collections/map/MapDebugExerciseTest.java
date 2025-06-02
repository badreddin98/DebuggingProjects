package com.teaching.collections.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class MapDebugExerciseTest {
    private MapDebugExercise exercise;

    @BeforeEach
    void setUp() {
        exercise = new MapDebugExercise();
    }

    @Test
    void testPutIfAbsent() {
        exercise.putIfAbsent("date", 4);
        assertEquals(4, exercise.hashMap.get("date"));
        exercise.putIfAbsent("apple", 5);
        assertEquals(1, exercise.hashMap.get("apple"));
    }

    @Test
    void testGetOrDefault() {
        assertEquals(1.1, exercise.getOrDefault("apple", 0.0));
        assertEquals(0.0, exercise.getOrDefault("date", 0.0));
    }

    @Test
    void testMergeMaps() {
        Map<String, Integer> otherMap = new HashMap<>();
        otherMap.put("date", 4);
        otherMap.put("apple", 5);
        exercise.mergeMaps(otherMap);
        assertEquals(5, exercise.hashMap.get("apple"));
        assertEquals(4, exercise.hashMap.get("date"));
    }

    @Test
    void testGetKeysInRange() {
        Set<String> result = exercise.getKeysInRange("apple", "cherry");
        Set<String> expected = new TreeSet<>(Arrays.asList("apple", "banana"));
        assertEquals(expected, result);
    }

    @Test
    void testIsOrdered() {
        assertTrue(exercise.isOrdered());
        exercise.linkedHashMap = new LinkedHashMap<>();
        exercise.linkedHashMap.put(3, "three");
        exercise.linkedHashMap.put(1, "one");
        exercise.linkedHashMap.put(2, "two");
        assertFalse(exercise.isOrdered());
    }

    @Test
    void testComputeIfAbsent() {
        assertEquals(4, exercise.computeIfAbsent("date", 4));
        assertEquals(1, exercise.computeIfAbsent("apple", 5));
    }

    @Test
    void testRemoveByValue() {
        exercise.removeByValue(2.2);
        assertFalse(exercise.treeMap.containsValue(2.2));
        assertTrue(exercise.treeMap.containsKey("apple"));
    }

    @Test
    void testGetValuesInReverseOrder() {
        List<String> result = exercise.getValuesInReverseOrder();
        List<String> expected = Arrays.asList("three", "two", "one");
        assertEquals(expected, result);
    }

    @Test
    void testAreAllValuesPositive() {
        assertTrue(exercise.areAllValuesPositive());
        exercise.hashMap.put("negative", -1);
        assertFalse(exercise.areAllValuesPositive());
    }

    @Test
    void testUpdateValue() {
        exercise.updateValue("apple", 5.5);
        assertEquals(5.5, exercise.treeMap.get("apple"));
        exercise.updateValue("date", 4.4);
        assertFalse(exercise.treeMap.containsKey("date"));
    }
} 