package com.teaching.collections.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class ListDebugExerciseTest {
    private ListDebugExercise exercise;

    @BeforeEach
    void setUp() {
        exercise = new ListDebugExercise();
    }

    @Test
    void testRemoveEvenIndices() {
        exercise.removeEvenIndices();
        List<Integer> expected = Arrays.asList(2, 4);
        assertEquals(expected, exercise.arrayList);
    }

    @Test
    void testReverseLinkedList() {
        exercise.reverseLinkedList();
        List<String> expected = Arrays.asList("E", "D", "C", "B", "A");
        assertEquals(expected, exercise.linkedList);
    }

    @Test
    void testFindMaxInVector() {
        assertEquals(5.0, exercise.findMaxInVector());
        exercise.vector.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> exercise.findMaxInVector());
    }

    @Test
    void testPushToStack() {
        exercise.pushToStack(1);
        exercise.pushToStack(2);
        assertEquals(2, exercise.stack.size());
        assertEquals(2, exercise.stack.peek());
    }

    @Test
    void testRemoveAllOccurrences() {
        exercise.arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 2, 5));
        exercise.removeAllOccurrences(2);
        List<Integer> expected = Arrays.asList(1, 3, 4, 5);
        assertEquals(expected, exercise.arrayList);
    }

    @Test
    void testRotateLinkedList() {
        exercise.rotateLinkedList(2);
        List<String> expected = Arrays.asList("D", "E", "A", "B", "C");
        assertEquals(expected, exercise.linkedList);
        
        exercise.linkedList = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        exercise.rotateLinkedList(-2);
        expected = Arrays.asList("C", "D", "E", "A", "B");
        assertEquals(expected, exercise.linkedList);
    }

    @Test
    void testIsVectorSorted() {
        assertTrue(exercise.isVectorSorted());
        exercise.vector = new Vector<>(Arrays.asList(1.0, 3.0, 2.0, 4.0, 5.0));
        assertFalse(exercise.isVectorSorted());
    }

    @Test
    void testPopFromStack() {
        exercise.stack.push(1);
        exercise.stack.push(2);
        assertEquals(2, exercise.popFromStack());
        assertEquals(1, exercise.stack.size());
    }

    @Test
    void testFindMiddleElement() {
        assertEquals(3, exercise.findMiddleElement());
        exercise.arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(2, exercise.findMiddleElement());
    }

    @Test
    void testMergeSortedLists() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4, 6));
        List<Integer> result = exercise.mergeSortedLists(list1, list2);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }
} 