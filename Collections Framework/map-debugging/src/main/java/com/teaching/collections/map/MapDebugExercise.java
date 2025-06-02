package com.teaching.collections.map;

import java.util.*;

public class MapDebugExercise {
    private HashMap<String, Integer> hashMap = new HashMap<>();
    private TreeMap<String, Double> treeMap = new TreeMap<>();
    private LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

    public MapDebugExercise() {
        // Initialize HashMap
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        // Initialize TreeMap
        treeMap.put("apple", 1.1);
        treeMap.put("banana", 2.2);
        treeMap.put("cherry", 3.3);

        // Initialize LinkedHashMap
        linkedHashMap.put(1, "one");
        linkedHashMap.put(2, "two");
        linkedHashMap.put(3, "three");
    }

    // Bug 1: This method should add a key-value pair to HashMap if key doesn't exist
    public void putIfAbsent(String key, Integer value) {
        hashMap.put(key, value); // Bug: No check if key exists
    }

    // Bug 2: This method should get value from TreeMap or return default
    public Double getOrDefault(String key, Double defaultValue) {
        return treeMap.get(key); // Bug: No default value handling
    }

    // Bug 3: This method should merge two HashMaps
    public void mergeMaps(Map<String, Integer> otherMap) {
        for (Map.Entry<String, Integer> entry : otherMap.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue()); // Bug: No value merging
        }
    }

    // Bug 4: This method should get all keys in range from TreeMap
    public Set<String> getKeysInRange(String from, String to) {
        return treeMap.subMap(from, to).keySet(); // Bug: Incorrect range bounds
    }

    // Bug 5: This method should check if LinkedHashMap maintains insertion order
    public boolean isOrdered() {
        List<Integer> keys = new ArrayList<>(linkedHashMap.keySet());
        for (int i = 0; i < keys.size() - 1; i++) {
            if (keys.get(i) > keys.get(i + 1)) { // Bug: Incorrect order check
                return false;
            }
        }
        return true;
    }

    // Bug 6: This method should compute value if key is absent
    public Integer computeIfAbsent(String key, Integer value) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, value);
        }
        return hashMap.get(key); // Bug: Inefficient implementation
    }

    // Bug 7: This method should remove entries from TreeMap based on value
    public void removeByValue(Double value) {
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            if (entry.getValue().equals(value)) {
                treeMap.remove(entry.getKey()); // Bug: Concurrent modification
            }
        }
    }

    // Bug 8: This method should get all values in reverse order from LinkedHashMap
    public List<String> getValuesInReverseOrder() {
        List<String> values = new ArrayList<>(linkedHashMap.values());
        Collections.reverse(values);
        return values; // Bug: Inefficient implementation
    }

    // Bug 9: This method should check if all values in HashMap are positive
    public boolean areAllValuesPositive() {
        for (Integer value : hashMap.values()) {
            if (value <= 0) { // Bug: No null check
                return false;
            }
        }
        return true;
    }

    // Bug 10: This method should update value in TreeMap if it exists
    public void updateValue(String key, Double newValue) {
        if (treeMap.containsKey(key)) {
            treeMap.put(key, newValue); // Bug: No atomic update
        }
    }
} 