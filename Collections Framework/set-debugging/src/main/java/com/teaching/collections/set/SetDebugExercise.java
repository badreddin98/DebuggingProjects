package com.teaching.collections.set;

import java.util.*;

public class SetDebugExercise {
    private HashSet<String> hashSet = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
    private TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 3, 1, 4, 2));
    private LinkedHashSet<Double> linkedHashSet = new LinkedHashSet<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5));

    // Bug 1: This method should add an element to HashSet if it doesn't exist
    public boolean addToHashSet(String element) {
        return hashSet.add(element); // Bug: No null check
    }

    // Bug 2: This method should find the smallest element in TreeSet
    public Integer findSmallestInTreeSet() {
        return treeSet.first(); // Bug: No empty check
    }

    // Bug 3: This method should remove all elements greater than a value from TreeSet
    public void removeGreaterThan(Integer value) {
        for (Integer num : treeSet) {
            if (num > value) {
                treeSet.remove(num); // Bug: Concurrent modification
            }
        }
    }

    // Bug 4: This method should check if LinkedHashSet maintains insertion order
    public boolean isOrdered() {
        Double[] array = linkedHashSet.toArray(new Double[0]);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) { // Bug: Incorrect order check
                return false;
            }
        }
        return true;
    }

    // Bug 5: This method should find common elements between two HashSets
    public Set<String> findCommonElements(Set<String> otherSet) {
        Set<String> common = new HashSet<>();
        for (String element : hashSet) {
            if (otherSet.contains(element)) {
                common.add(element);
            }
        }
        return common; // Bug: Inefficient implementation
    }

    // Bug 6: This method should get elements in range from TreeSet
    public Set<Integer> getElementsInRange(Integer from, Integer to) {
        return treeSet.subSet(from, to); // Bug: Incorrect range bounds
    }

    // Bug 7: This method should convert LinkedHashSet to array maintaining order
    public Double[] toOrderedArray() {
        return linkedHashSet.toArray(new Double[0]); // Bug: Array size not specified
    }

    // Bug 8: This method should check if HashSet contains all elements from another set
    public boolean containsAll(Set<String> otherSet) {
        for (String element : otherSet) {
            if (!hashSet.contains(element)) {
                return false;
            }
        }
        return true; // Bug: No null check
    }

    // Bug 9: This method should get the last element from TreeSet
    public Integer getLastElement() {
        return treeSet.last(); // Bug: No empty check
    }

    // Bug 10: This method should remove elements from LinkedHashSet that match a condition
    public void removeIf(Predicate<Double> condition) {
        for (Double element : linkedHashSet) {
            if (condition.test(element)) {
                linkedHashSet.remove(element); // Bug: Concurrent modification
            }
        }
    }
} 