package com.teaching.threading;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDebugExerciseTest {
    private ThreadDebugExercise exercise;
    private ExecutorService executor;

    @BeforeEach
    void setUp() {
        exercise = new ThreadDebugExercise();
        executor = Executors.newFixedThreadPool(10);
    }

    @Test
    void testAddToList() throws InterruptedException {
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            final int value = i;
            futures.add(executor.submit(() -> exercise.addToList(value)));
        }
        for (Future<?> future : futures) {
            future.get();
        }
        assertEquals(1000, exercise.sharedList.size());
    }

    @Test
    void testUpdateMap() throws InterruptedException {
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            final int value = i;
            futures.add(executor.submit(() -> 
                exercise.updateMap("key" + value, value)));
        }
        for (Future<?> future : futures) {
            future.get();
        }
        assertEquals(1000, exercise.sharedMap.size());
    }

    @Test
    void testIncrementCounter() throws InterruptedException {
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            futures.add(executor.submit(() -> exercise.incrementCounter()));
        }
        Set<Integer> results = new HashSet<>();
        for (Future<Integer> future : futures) {
            results.add(future.get());
        }
        assertEquals(1000, results.size());
    }

    @Test
    void testProcessQueue() throws InterruptedException {
        exercise.queue.offer("test");
        String result = exercise.processQueue();
        assertEquals("test", result);
        assertNull(exercise.processQueue());
    }

    @Test
    void testParallelProcess() throws InterruptedException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = exercise.parallelProcess(numbers);
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), result);
    }

    @Test
    void testStopProcessing() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (exercise.running) {
                // Do nothing
            }
        });
        thread.start();
        exercise.stopProcessing();
        thread.join(1000);
        assertFalse(thread.isAlive());
    }

    @Test
    void testWithLock() {
        AtomicInteger counter = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> 
                exercise.withLock(() -> counter.incrementAndGet()));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                fail("Thread interrupted");
            }
        }
        assertEquals(10, counter.get());
    }

    @Test
    void testWaitForCondition() throws InterruptedException {
        Thread thread = new Thread(() -> {
            exercise.running = false;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                fail("Thread interrupted");
            }
            exercise.running = true;
        });
        thread.start();
        exercise.waitForCondition();
        assertTrue(exercise.running);
    }

    @Test
    void testHandleInterruption() throws InterruptedException {
        Thread thread = new Thread(() -> exercise.handleInterruption());
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join(1000);
        assertFalse(thread.isAlive());
    }

    @Test
    void testExecuteWithTimeout() throws InterruptedException {
        boolean result = exercise.executeWithTimeout(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                fail("Thread interrupted");
            }
        }, 1000);
        assertTrue(result);
    }
} 