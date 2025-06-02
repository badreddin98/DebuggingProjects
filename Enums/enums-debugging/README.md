# Enums Debugging Exercise

This exercise consists of 10 broken enum scenarios that need to be fixed. Each scenario demonstrates different aspects of Java enums.

## Exercise Structure

The exercise contains the following enum scenarios to fix:

1. `Direction` - Incorrect enum declaration with values
2. `Planet` - Incorrect enum with constructor
3. `Operation` - Incorrect enum with abstract methods
4. `Day` - Incorrect enum with static fields
5. `Color` - Incorrect enum with interfaces
6. `Status` - Incorrect enum with generics
7. `Outer` - Incorrect enum with nested enums
8. `Legacy` - Incorrect enum with annotations
9. `Season` - Incorrect enum with switch expressions
10. `Size` - Incorrect enum with valueOf

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/enums/EnumsDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'EnumsDebugExerciseTest'"

### Using Command Line
```bash
mvn test
```

## Debugging Hints

1. Check enum declarations:
   - Proper use of `enum` keyword
   - Correct enum constants
   - Valid modifiers
   - Proper constructor usage

2. Check enum features:
   - Abstract methods
   - Static fields
   - Interfaces
   - Nested enums
   - Annotations
   - Switch expressions
   - valueOf method

3. Check enum constraints:
   - No generic type parameters
   - No inheritance
   - No instance fields
   - No synchronized methods

4. Check enum patterns:
   - Singleton pattern
   - Strategy pattern
   - State pattern
   - Command pattern

## Learning Objectives

By completing this exercise, you will:

1. Understand Java enums
2. Learn how to properly declare enums
3. Understand enum features and limitations
4. Learn how to work with enum constants
5. Understand enum patterns and use cases
6. Learn how to use enums in real-world scenarios
7. Understand the relationship between enums and other Java features
8. Learn how to debug enum issues
9. Understand the benefits of enums
10. Learn how to use enums effectively in your code 