# Set Debugging Exercise

This exercise contains 10 broken Set operations that need to be fixed. Each method has one or more bugs that you need to identify and fix.

## Exercise Structure

The exercise consists of a single class `SetDebugExercise.java` with 10 methods that need to be fixed:

1. `addToHashSet(String word)`: Add a word to HashSet with null check
2. `findSmallestInTreeSet()`: Find the smallest element in TreeSet
3. `removeGreaterThan(int value)`: Remove elements greater than value from TreeSet
4. `isOrdered()`: Check if LinkedHashSet is in ascending order
5. `findCommonElements(Set<String> otherSet)`: Find common elements between two sets
6. `getElementsInRange(int min, int max)`: Get elements within a range from TreeSet
7. `toOrderedArray()`: Convert LinkedHashSet to sorted array
8. `containsAll(Set<String> otherSet)`: Check if set contains all elements from another set
9. `getLastElement()`: Get the last element from TreeSet
10. `removeIf(Predicate<Double> predicate)`: Remove elements matching predicate from LinkedHashSet

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/collections/set/SetDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'SetDebugExerciseTest'"
4. All tests will fail initially
5. Fix each method in `SetDebugExercise.java` and run the tests again

### Using Command Line

1. Open a terminal in the project directory
2. Run the tests:
   ```bash
   mvn test
   ```
3. All tests will fail initially
4. Fix each method in `SetDebugExercise.java` and run the tests again

## Debugging Hints

1. Check for null values and handle them appropriately
2. Consider the characteristics of different Set implementations:
   - HashSet: No order, no duplicates
   - TreeSet: Sorted order, no duplicates
   - LinkedHashSet: Insertion order, no duplicates
3. Be careful with concurrent modifications
4. Consider performance implications of different operations
5. Handle edge cases (empty sets, null values, etc.)

## Learning Objectives

- Understanding different Set implementations and their characteristics
- Working with Set operations and methods
- Handling edge cases and null values
- Understanding Set ordering and uniqueness
- Working with Set predicates and filtering 