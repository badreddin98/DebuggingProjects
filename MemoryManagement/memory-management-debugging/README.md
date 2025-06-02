# Memory Management Debugging Exercise

This exercise contains 10 broken memory management scenarios that demonstrate common memory-related issues in Java applications. Students are required to identify and fix these issues.

## Exercise Structure

The exercise consists of two main files:
1. `MemoryManagementDebugExercise.java`: Contains the classes with memory management issues
2. `MemoryManagementDebugExerciseTest.java`: Contains the test cases to verify fixes

## Broken Scenarios

1. **Cache Memory Leak**
   - Class: `Cache`
   - Issue: Strong references in cache prevent garbage collection
   - Fix: Use weak references or implement cache eviction

2. **Stack Overflow**
   - Class: `RecursiveCalculator`
   - Issue: Infinite recursion without base case
   - Fix: Add proper base case and consider iterative approach

3. **Event Listener Memory Leak**
   - Class: `EventManager`
   - Issue: Listeners not properly removed
   - Fix: Implement proper listener removal

4. **Large Object Retention**
   - Class: `ImageProcessor`
   - Issue: Large objects kept in memory unnecessarily
   - Fix: Implement proper cleanup

5. **String Concatenation in Loop**
   - Class: `StringBuilder`
   - Issue: Inefficient string concatenation
   - Fix: Use StringBuilder class

6. **Resource Leak**
   - Class: `FileHandler`
   - Issue: File resources not properly closed
   - Fix: Use try-with-resources

7. **Thread Local Memory Leak**
   - Class: `ThreadLocalManager`
   - Issue: ThreadLocal not properly cleaned up
   - Fix: Implement proper cleanup

8. **Circular References**
   - Class: `Node`
   - Issue: Circular references preventing garbage collection
   - Fix: Break circular references

9. **Weak Reference Misuse**
   - Class: `WeakReferenceCache`
   - Issue: Weak references not properly used
   - Fix: Implement proper weak reference handling

10. **Finalizer Memory Leak**
    - Class: `Resource`
    - Issue: Finalizer not properly implemented
    - Fix: Use AutoCloseable instead

## Example of Correct Implementation

The `ProperResource` class demonstrates proper resource management:
- Implements AutoCloseable
- Proper resource cleanup in close method
- Use of try-with-resources

## How to Run the Exercise

1. Clone the repository
2. Open the project in your IDE
3. Run the tests to see them fail
4. Fix each issue one at a time
5. Verify your fixes by running the tests

## Learning Objectives

- Understand Java memory management
- Identify common memory leaks
- Learn proper resource management
- Practice memory optimization
- Understand garbage collection

## Memory Management Concepts

1. **Heap vs Stack**
   - Heap: Dynamic memory allocation
   - Stack: Method calls and local variables
   - Understanding memory allocation

2. **Reference Types**
   - Strong references
   - Weak references
   - Soft references
   - Phantom references

3. **Garbage Collection**
   - Mark and sweep
   - Generational collection
   - GC algorithms
   - GC tuning

4. **Memory Profiling**
   - Heap dumps
   - Memory leaks
   - Performance analysis
   - Tools and techniques

## Resources

- [Java Memory Management](https://www.oracle.com/java/technologies/javase/memory-management.html)
- [Understanding Java Garbage Collection](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html)
- [Java Performance Tuning](https://www.oracle.com/java/technologies/javase/performance.html)
- [Memory Leak Detection](https://www.oracle.com/java/technologies/javase/memory-leak-detection.html) 