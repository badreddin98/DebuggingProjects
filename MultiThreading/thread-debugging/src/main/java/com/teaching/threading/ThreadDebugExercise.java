package com.teaching.threading;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDebugExercise {
    private List<Integer> sharedList = new ArrayList<>();
    private Map<String, Integer> sharedMap = new HashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    private ReentrantLock lock = new ReentrantLock();
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    // Bug 1: This method should safely add elements to the shared list
    public void addToList(int element) {
        sharedList.add(element); // Bug: No synchronization
    }

    // Bug 2: This method should safely update the shared map
    public void updateMap(String key, int value) {
        sharedMap.put(key, value); // Bug: No synchronization
    }

    // Bug 3: This method should safely increment the counter
    public int incrementCounter() {
        return counter.getAndIncrement(); // Bug: No atomic operation
    }

    // Bug 4: This method should safely process items from the queue
    public String processQueue() {
        return queue.poll(); // Bug: No blocking wait
    }

    // Bug 5: This method should safely execute tasks in parallel
    public List<Integer> parallelProcess(List<Integer> numbers) {
        List<Integer> results = new ArrayList<>();
        for (Integer num : numbers) {
            results.add(num * 2); // Bug: No parallel processing
        }
        return results;
    }

    // Bug 6: This method should safely stop all processing
    public void stopProcessing() {
        running = false; // Bug: No volatile keyword
    }

    // Bug 7: This method should safely acquire and release the lock
    public void withLock(Runnable task) {
        lock.lock();
        task.run();
        // Bug: No lock release
    }

    // Bug 8: This method should safely wait for a condition
    public void waitForCondition() {
        while (!running) {
            Thread.sleep(100); // Bug: No proper wait/notify mechanism
        }
    }

    // Bug 9: This method should safely handle thread interruption
    public void handleInterruption() {
        while (running) {
            // Bug: No interruption handling
        }
    }

    // Bug 10: This method should safely execute a task with timeout
    public boolean executeWithTimeout(Runnable task, long timeout) {
        Thread thread = new Thread(task);
        thread.start();
        thread.join(timeout); // Bug: No proper timeout handling
        return true;
    }
} 