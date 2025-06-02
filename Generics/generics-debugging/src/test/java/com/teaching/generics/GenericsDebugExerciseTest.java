package com.teaching.generics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class GenericsDebugExerciseTest {
    private GenericsDebugExercise exercise = new GenericsDebugExercise();

    @Test
    void testGetList() {
        List<String> list = exercise.getList();
        list.add("test");
        assertEquals("test", list.get(0));
    }

    @Test
    void testCreateArray() {
        String[] array = exercise.createArray("test");
        array[0] = "test";
        assertEquals("test", array[0]);
    }

    @Test
    void testProcessList() {
        List<String> list = new ArrayList<>();
        list.add("test");
        exercise.processList(list);
        assertEquals(2, list.size());
    }

    @Test
    void testAddNumbers() {
        List<Integer> numbers = new ArrayList<>();
        exercise.addNumbers(numbers);
        assertEquals(42, numbers.get(0));
    }

    @Test
    void testAddToList() {
        List<String> list = new ArrayList<>();
        exercise.addToList(list, "test");
        assertEquals(1, list.size());
    }

    @Test
    void testGetFirst() {
        List<String> list = Arrays.asList("test");
        String first = GenericsDebugExercise.getFirst(list);
        assertEquals("test", first);
    }

    @Test
    void testBox() {
        GenericsDebugExercise.Box<String> box = exercise.new Box<>();
        box.setValue("test");
        assertEquals("test", box.value);
    }

    @Test
    void testCopyList() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Number> dest = new ArrayList<>();
        exercise.copyList(source, dest);
        assertEquals(3, dest.size());
        assertEquals(1, dest.get(0));
    }

    @Test
    void testContainer() {
        GenericsDebugExercise.Container<String> container = exercise.new Container<>();
        container.add("test");
    }

    @Test
    void testCreateGenericArray() {
        String[] array = exercise.createGenericArray(5);
        array[0] = "test";
        assertEquals("test", array[0]);
    }
} 