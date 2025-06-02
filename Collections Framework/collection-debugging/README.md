# Collections Framework Debugging Exercise

This exercise contains 10 broken collection operations that need to be fixed. Each method in `CollectionDebugExercise.java` has a bug that needs to be identified and corrected.

## Exercise Description

The code contains 10 methods with different collection operations that need to be fixed:

1. `removeEvenNumbers()`: Should remove all even numbers from the list
2. `addUniqueWord()`: Should add a word to the set if it doesn't exist
3. `countWords()`: Should count occurrences of each word in a list
4. `processTasks()`: Should process tasks in order and return completed tasks
5. `reverseDeque()`: Should reverse the order of numbers in the deque
6. `findMax()`: Should find the maximum value in a list
7. `mergeMaps()`: Should merge two maps, summing their values
8. `isSorted()`: Should check if a list is sorted
9. `removeDuplicates()`: Should remove duplicates from a list while preserving order
10. `findCommonElements()`: Should find common elements between two lists

## Running the Exercise

### Using IntelliJ IDEA:
1. Open the project in IntelliJ IDEA
2. Wait for Maven to download dependencies
3. Navigate to `src/test/java/com/teaching/collections/CollectionDebugExerciseTest.java`
4. Run the tests to see which operations are failing
5. Fix the bugs in `CollectionDebugExercise.java`
6. Run the tests again to verify your fixes

### Using Command Line:
1. Open a terminal in the project directory
2. Run `mvn clean test` to see the failing tests
3. Fix the bugs in `CollectionDebugExercise.java`
4. Run `mvn test` again to verify your fixes

## Hints
- Each method has a comment indicating what it should do
- The test cases show the expected output
- Pay attention to concurrent modification issues
- Check for null values and edge cases
- Verify collection operations and their side effects
- Consider the order of elements in ordered collections
- Watch out for index out of bounds exceptions
- Handle empty collections appropriately
- Consider the performance implications of your fixes
- Verify that your solution maintains collection invariants

## Learning Objectives
- Understanding different collection types
- Working with Lists, Sets, and Maps
- Handling concurrent modifications
- Null safety and error handling
- Collection operations and their side effects
- Order preservation in collections
- Edge case handling
- Performance considerations
- Collection invariants
- Common collection patterns and anti-patterns 