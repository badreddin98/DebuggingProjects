# Sealed Classes Debugging Exercise

This exercise consists of 10 broken sealed class scenarios that need to be fixed. Each scenario demonstrates different aspects of Java sealed classes.

## Exercise Structure

The exercise contains the following sealed class scenarios to fix:

1. `Shape` - Incorrect sealed class declaration
2. `Vehicle` - Incorrect permits clause
3. `Expression` - Incorrect non-sealed class
4. `Operation` - Incorrect sealed interface
5. `Animal` - Incorrect sealed class with abstract methods
6. `Container` - Incorrect sealed class with generics
7. `Outer` - Incorrect sealed class with nested classes
8. `Utility` - Incorrect sealed class with static members
9. `Service` - Incorrect sealed class with interfaces
10. `Legacy` - Incorrect sealed class with annotations

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/sealed/SealedClassesDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'SealedClassesDebugExerciseTest'"

### Using Command Line
```bash
mvn test
```

## Debugging Hints

1. Check sealed class declarations:
   - Proper use of `sealed` keyword
   - Correct `permits` clause
   - Valid class hierarchy

2. Check permitted classes:
   - Proper class declarations
   - Correct modifiers
   - Valid inheritance

3. Check sealed interfaces:
   - Proper interface declarations
   - Correct permits clause
   - Valid implementations

4. Check sealed class features:
   - Abstract methods
   - Generics
   - Nested classes
   - Static members
   - Interfaces
   - Annotations

## Learning Objectives

By completing this exercise, you will:

1. Understand Java sealed classes
2. Learn how to properly declare sealed classes
3. Understand the rules for permitted classes
4. Learn how to work with sealed interfaces
5. Understand sealed class features and limitations
6. Learn how to use sealed classes in real-world scenarios
7. Understand the relationship between sealed classes and other Java features
8. Learn how to debug sealed class issues
9. Understand the benefits of sealed classes
10. Learn how to use sealed classes effectively in your code 