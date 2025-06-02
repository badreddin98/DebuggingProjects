# Multi-Threading Debugging Exercise

This exercise consists of 10 broken multi-threading scenarios that need to be fixed. Each scenario demonstrates a different aspect of concurrent programming in Java.

## Exercise Structure

The exercise consists of a single class `ThreadDebugExercise.java` with 10 methods that need to be fixed:

1. `addToList(int element)`: Should safely add elements to the shared list
2. `updateMap(String key, int value)`: Should safely update the shared map
3. `incrementCounter()`: Should safely increment the counter
4. `processQueue()`: Should safely process items from the queue
5. `parallelProcess(List<Integer> numbers)`: Should safely execute tasks in parallel
6. `stopProcessing()`: Should safely stop all processing
7. `withLock(Runnable task)`: Should safely acquire and release the lock
8. `waitForCondition()`: Should safely wait for a condition
9. `handleInterruption()`: Should safely handle thread interruption
10. `executeWithTimeout(Runnable task, long timeout)`: Should safely execute a task with timeout

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/threading/ThreadDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'ThreadDebugExerciseTest'"

### Using Command Line

```bash
mvn test
```

## Debugging Hints

1. Check for proper synchronization mechanisms:
   - `synchronized` blocks
   - `Lock` objects
   - `AtomicInteger` and other atomic classes
   - `volatile` keyword

2. Look for common threading issues:
   - Race conditions
   - Deadlocks
   - Starvation
   - Thread interference

3. Consider thread safety:
   - Immutable objects
   - Thread-safe collections
   - Proper resource cleanup
   - Thread interruption handling

4. Test for concurrent behavior:
   - Multiple threads accessing shared resources
   - Thread coordination
   - Thread lifecycle management
   - Timeout handling

## Learning Objectives

1. Understanding thread synchronization mechanisms
2. Working with concurrent collections
3. Handling thread interruption
4. Managing thread lifecycle
5. Implementing thread-safe operations
6. Using locks and conditions
7. Working with atomic operations
8. Handling timeouts and deadlines
9. Coordinating multiple threads
10. Debugging concurrent applications 