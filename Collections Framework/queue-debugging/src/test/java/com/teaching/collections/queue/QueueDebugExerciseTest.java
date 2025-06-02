package com.teaching.collections.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class QueueDebugExerciseTest {
    private QueueDebugExercise exercise;

    @BeforeEach
    void setUp() {
        exercise = new QueueDebugExercise();
    }

    @Test
    void testAddToPriorityQueue() {
        assertTrue(exercise.addToPriorityQueue(6));
        assertFalse(exercise.addToPriorityQueue(5));
    }

    @Test
    void testPeekNext() {
        assertEquals("first", exercise.peekNext());
        assertEquals("first", exercise.peekNext());
    }

    @Test
    void testRemoveSmallest() {
        assertEquals(1, exercise.removeSmallest());
        exercise.priorityQueue.clear();
        assertNull(exercise.removeSmallest());
    }

    @Test
    void testAddToBothEnds() {
        exercise.addToBothEnds("middle");
        assertEquals("middle", exercise.arrayDeque.getFirst());
        assertEquals("middle", exercise.arrayDeque.getLast());
    }

    @Test
    void testIsPalindrome() {
        assertFalse(exercise.isPalindrome());
        exercise.linkedList = new LinkedList<>(Arrays.asList(1, 2, 1));
        assertTrue(exercise.isPalindrome());
    }

    @Test
    void testGetAllElements() {
        List<Integer> result = exercise.getAllElements();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, result);
        assertFalse(exercise.priorityQueue.isEmpty());
    }

    @Test
    void testRotate() {
        exercise.rotate(2);
        assertEquals("third", exercise.arrayDeque.getFirst());
        exercise.rotate(-1);
        assertEquals("second", exercise.arrayDeque.getFirst());
    }

    @Test
    void testFindMax() {
        assertEquals(3, exercise.findMax());
        exercise.linkedList.clear();
        assertThrows(NoSuchElementException.class, () -> exercise.findMax());
    }

    @Test
    void testIsSorted() {
        assertTrue(exercise.isSorted());
        exercise.priorityQueue = new PriorityQueue<>(Arrays.asList(5, 1, 3, 2, 4));
        assertFalse(exercise.isSorted());
    }

    @Test
    void testRemoveAllOccurrences() {
        exercise.arrayDeque.add("first");
        exercise.removeAllOccurrences("first");
        assertFalse(exercise.arrayDeque.contains("first"));
    }
} 