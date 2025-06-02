# Lambda Expression Debugging Exercise

This exercise consists of 10 broken lambda expression scenarios that need to be fixed. Each scenario demonstrates different aspects of Java lambda expressions and functional interfaces.

## Exercise Structure

The exercise consists of a single class `LambdaDebugExercise.java` with 10 methods that need to be fixed:

1. `filterNumbers`: Should filter positive numbers from a list
2. `mapToStrings`: Should convert numbers to strings using method reference
3. `allPositive`: Should check if all numbers are positive
4. `printNumbers`: Should print numbers using a consumer
5. `doubleNumbers`: Should double each number using a function
6. `generateNumbers`: Should generate random numbers using a supplier
7. `sumNumbers`: Should sum numbers using a binary operator
8. `sortStrings`: Should sort strings using a comparator
9. `incrementNumbers`: Should increment numbers using a unary operator
10. `processNumbers`: Should process numbers using multiple stream operations

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/lambda/LambdaDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'LambdaDebugExerciseTest'"
4. Fix each method in `LambdaDebugExercise.java` until all tests pass

### Using Command Line

1. Open a terminal in the project directory
2. Run the tests:
   ```bash
   mvn test
   ```
3. Fix each method in `LambdaDebugExercise.java` until all tests pass

## Debugging Hints

1. Check for proper lambda syntax
2. Verify method references
3. Ensure correct functional interface usage
4. Check stream operation order
5. Verify terminal operations
6. Check for proper type inference
7. Verify parallel stream usage
8. Check for proper exception handling
9. Verify null handling
10. Check for proper resource cleanup

## Learning Objectives

- Understand lambda expression syntax
- Work with functional interfaces
- Use method references
- Handle stream operations
- Work with collectors
- Understand type inference
- Handle parallel streams
- Work with primitive streams
- Understand stream pipeline
- Handle stream exceptions 