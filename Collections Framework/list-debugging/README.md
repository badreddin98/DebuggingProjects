# List Collections Debugging Exercise

This exercise contains 10 broken List operations that need to be fixed. Each method in `ListDebugExercise.java` has a bug that needs to be identified and corrected.

## Exercise Description

The code contains 10 methods with different List operations that need to be fixed:

1. `removeEvenIndices()`: Should remove all elements at even indices from ArrayList
2. `reverseLinkedList()`: Should reverse the LinkedList using only LinkedList operations
3. `findMaxInVector()`: Should find the maximum value in the Vector
4. `pushToStack()`: Should implement a proper stack push operation
5. `removeAllOccurrences()`: Should remove all occurrences of a value from ArrayList
6. `rotateLinkedList()`: Should rotate the LinkedList by n positions
7. `isVectorSorted()`: Should check if the Vector is sorted
8. `popFromStack()`: Should implement a proper stack pop operation
9. `findMiddleElement()`: Should find the middle element of the ArrayList
10. `mergeSortedLists()`: Should merge two sorted ArrayLists

## Running the Exercise

### Using IntelliJ IDEA:
1. Open the project in IntelliJ IDEA
2. Wait for Maven to download dependencies
3. Navigate to `src/test/java/com/teaching/collections/list/ListDebugExerciseTest.java`
4. Run the tests to see which operations are failing
5. Fix the bugs in `ListDebugExercise.java`
6. Run the tests again to verify your fixes

### Using Command Line:
1. Open a terminal in the project directory
2. Run `mvn clean test` to see the failing tests
3. Fix the bugs in `ListDebugExercise.java`
4. Run `mvn test` again to verify your fixes

## Hints
- Each method has a comment indicating what it should do
- The test cases show the expected output
- Pay attention to concurrent modification issues
- Consider the performance implications of different List implementations
- Watch out for index out of bounds exceptions
- Handle empty collections appropriately
- Consider the order of elements in ordered collections
- Verify that your solution maintains collection invariants
- Check for proper use of List-specific operations
- Consider edge cases for each List implementation

## Learning Objectives
- Understanding different List implementations (ArrayList, LinkedList, Vector, Stack)
- Working with List-specific operations
- Handling concurrent modifications
- Performance considerations for different List types
- Edge case handling
- Proper use of List methods
- Understanding List invariants
- Working with ordered collections
- Implementing efficient List operations
- Understanding List implementation trade-offs 