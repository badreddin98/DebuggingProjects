package com.teaching.collections.queue;

import java.util.*;

public class QueueDebugExercise {
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private ArrayDeque<String> arrayDeque = new ArrayDeque<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();

    public QueueDebugExercise() {
        // Initialize PriorityQueue
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(2);

        // Initialize ArrayDeque
        arrayDeque.add("first");
        arrayDeque.add("second");
        arrayDeque.add("third");

        // Initialize LinkedList
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
    }

    // Bug 1: This method should add element to PriorityQueue if it's not already present
    public boolean addToPriorityQueue(Integer element) {
        return priorityQueue.add(element); // Bug: No duplicate check
    }

    // Bug 2: This method should get the next element from ArrayDeque without removing it
    public String peekNext() {
        return arrayDeque.remove(); // Bug: Removes element instead of peeking
    }

    // Bug 3: This method should remove and return the smallest element from PriorityQueue
    public Integer removeSmallest() {
        return priorityQueue.poll(); // Bug: No empty check
    }

    // Bug 4: This method should add element to both ends of ArrayDeque
    public void addToBothEnds(String element) {
        arrayDeque.add(element);
        arrayDeque.addLast(element); // Bug: Adds to same end twice
    }

    // Bug 5: This method should check if LinkedList is a palindrome
    public boolean isPalindrome() {
        for (int i = 0; i < linkedList.size() / 2; i++) {
            if (!linkedList.get(i).equals(linkedList.get(linkedList.size() - i - 1))) {
                return false;
            }
        }
        return true; // Bug: No null check
    }

    // Bug 6: This method should get all elements from PriorityQueue in order
    public List<Integer> getAllElements() {
        List<Integer> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }
        return result; // Bug: Modifies original queue
    }

    // Bug 7: This method should rotate ArrayDeque by n positions
    public void rotate(int n) {
        for (int i = 0; i < n; i++) {
            arrayDeque.addLast(arrayDeque.removeFirst()); // Bug: No negative rotation handling
        }
    }

    // Bug 8: This method should find the maximum element in LinkedList
    public Integer findMax() {
        return Collections.max(linkedList); // Bug: No empty check
    }

    // Bug 9: This method should check if PriorityQueue is sorted
    public boolean isSorted() {
        List<Integer> elements = new ArrayList<>(priorityQueue);
        for (int i = 0; i < elements.size() - 1; i++) {
            if (elements.get(i) > elements.get(i + 1)) {
                return false;
            }
        }
        return true; // Bug: Incorrect sorting check for PriorityQueue
    }

    // Bug 10: This method should remove all occurrences of an element from ArrayDeque
    public void removeAllOccurrences(String element) {
        while (arrayDeque.contains(element)) {
            arrayDeque.remove(element); // Bug: Inefficient removal
        }
    }
} 