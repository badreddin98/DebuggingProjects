# Queue/Deque Debugging Exercise

This exercise contains 10 broken Queue and Deque operations that need to be fixed. Each method has one or more bugs that you need to identify and fix.

## Exercise Structure

The exercise consists of a single class `QueueDebugExercise.java` with 10 methods that need to be fixed:

1. `addToPriorityQueue(Integer element)`: Add element to PriorityQueue if not present
2. `peekNext()`: Get next element from ArrayDeque without removing it
3. `removeSmallest()`: Remove and return smallest element from PriorityQueue
4. `addToBothEnds(String element)`: Add element to both ends of ArrayDeque
5. `isPalindrome()`: Check if LinkedList is a palindrome
6. `getAllElements()`: Get all elements from PriorityQueue in order
7. `rotate(int n)`: Rotate ArrayDeque by n positions
8. `findMax()`: Find maximum element in LinkedList
9. `isSorted()`: Check if PriorityQueue is sorted
10. `removeAllOccurrences(String element)`: Remove all occurrences of element from ArrayDeque

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/collections/queue/QueueDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'QueueDebugExerciseTest'"
4. All tests will fail initially
5. Fix each method in `QueueDebugExercise.java` and run the tests again

### Using Command Line

1. Open a terminal in the project directory
2. Run the tests:
   ```bash
   mvn test
   ```
3. All tests will fail initially
4. Fix each method in `QueueDebugExercise.java` and run the tests again

## Debugging Hints

1. Check for null values and handle them appropriately
2. Consider the characteristics of different Queue/Deque implementations:
   - PriorityQueue: Sorted by natural order or comparator
   - ArrayDeque: Double-ended queue with array backing
   - LinkedList: Doubly-linked list implementation
3. Be careful with concurrent modifications
4. Consider performance implications of different operations
5. Handle edge cases (empty queues, null values, etc.)

## Learning Objectives

- Understanding different Queue and Deque implementations
- Working with Queue/Deque operations and methods
- Handling edge cases and null values
- Understanding Queue ordering and priority
- Working with Deque operations (first/last) 