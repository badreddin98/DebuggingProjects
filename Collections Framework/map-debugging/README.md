# Map Debugging Exercise

This exercise contains 10 broken Map operations that need to be fixed. Each method has one or more bugs that you need to identify and fix.

## Exercise Structure

The exercise consists of a single class `MapDebugExercise.java` with 10 methods that need to be fixed:

1. `putIfAbsent(String key, Integer value)`: Add key-value pair to HashMap if key doesn't exist
2. `getOrDefault(String key, Double defaultValue)`: Get value from TreeMap or return default
3. `mergeMaps(Map<String, Integer> otherMap)`: Merge two HashMaps
4. `getKeysInRange(String from, String to)`: Get all keys in range from TreeMap
5. `isOrdered()`: Check if LinkedHashMap maintains insertion order
6. `computeIfAbsent(String key, Integer value)`: Compute value if key is absent
7. `removeByValue(Double value)`: Remove entries from TreeMap based on value
8. `getValuesInReverseOrder()`: Get all values in reverse order from LinkedHashMap
9. `areAllValuesPositive()`: Check if all values in HashMap are positive
10. `updateValue(String key, Double newValue)`: Update value in TreeMap if it exists

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/collections/map/MapDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'MapDebugExerciseTest'"
4. All tests will fail initially
5. Fix each method in `MapDebugExercise.java` and run the tests again

### Using Command Line

1. Open a terminal in the project directory
2. Run the tests:
   ```bash
   mvn test
   ```
3. All tests will fail initially
4. Fix each method in `MapDebugExercise.java` and run the tests again

## Debugging Hints

1. Check for null values and handle them appropriately
2. Consider the characteristics of different Map implementations:
   - HashMap: No order, key-value pairs
   - TreeMap: Sorted by keys, key-value pairs
   - LinkedHashMap: Insertion order, key-value pairs
3. Be careful with concurrent modifications
4. Consider performance implications of different operations
5. Handle edge cases (empty maps, null values, etc.)

## Learning Objectives

- Understanding different Map implementations and their characteristics
- Working with Map operations and methods
- Handling edge cases and null values
- Understanding Map ordering and key-value relationships
- Working with Map atomic operations and updates 