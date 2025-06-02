package com.teaching.collections;

import java.util.*;

public class CollectionDebugExercise {
    private List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    private Set<String> words = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
    private Map<String, Integer> wordCount = new HashMap<>();
    private Queue<String> tasks = new LinkedList<>(Arrays.asList("task1", "task2", "task3"));
    private Deque<Integer> numbersDeque = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

    // Bug 1: This method should remove all even numbers from the list
    public void removeEvenNumbers() {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i); // Bug: Concurrent modification
            }
        }
    }

    // Bug 2: This method should add a word to the set if it doesn't exist
    public boolean addUniqueWord(String word) {
        return words.add(word); // Bug: No null check
    }

    // Bug 3: This method should count occurrences of each word in a list
    public void countWords(List<String> wordList) {
        for (String word : wordList) {
            wordCount.put(word, wordCount.get(word) + 1); // Bug: No null check and incorrect counting
        }
    }

    // Bug 4: This method should process tasks in order and return completed tasks
    public List<String> processTasks() {
        List<String> completed = new ArrayList<>();
        while (!tasks.isEmpty()) {
            completed.add(tasks.poll()); // Bug: No null check
        }
        return completed;
    }

    // Bug 5: This method should reverse the order of numbers in the deque
    public void reverseDeque() {
        Deque<Integer> temp = new LinkedList<>();
        while (!numbersDeque.isEmpty()) {
            temp.addFirst(numbersDeque.removeFirst()); // Bug: Incorrect reversal logic
        }
        numbersDeque = temp;
    }

    // Bug 6: This method should find the maximum value in a list
    public Integer findMax(List<Integer> list) {
        Integer max = list.get(0); // Bug: No empty list check
        for (Integer num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Bug 7: This method should merge two maps, summing their values
    public Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.put(entry.getKey(), entry.getValue()); // Bug: No value merging
        }
        return result;
    }

    // Bug 8: This method should check if a list is sorted
    public boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) { // Bug: Index out of bounds
                return false;
            }
        }
        return true;
    }

    // Bug 9: This method should remove duplicates from a list while preserving order
    public List<String> removeDuplicates(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return new ArrayList<>(set); // Bug: Order not preserved
    }

    // Bug 10: This method should find common elements between two lists
    public List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        List<Integer> common = new ArrayList<>();
        for (Integer num : list1) {
            if (list2.contains(num)) {
                common.add(num);
            }
        }
        return common; // Bug: Duplicates not handled
    }
} 