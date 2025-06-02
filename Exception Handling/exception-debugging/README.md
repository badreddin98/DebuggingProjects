# Exception Handling Debugging Exercise

This exercise contains 10 broken exception handling scenarios that need to be fixed. Each method has one or more bugs related to exception handling that you need to identify and fix.

## Exercise Structure

The exercise consists of a single class `ExceptionDebugExercise.java` with 10 methods that need to be fixed:

1. `readFile(String filename)`: Read a file and return its contents
2. `parseInteger(String input)`: Parse an integer from a string
3. `divide(int a, int b)`: Divide two numbers
4. `getElement(int index)`: Get an element from a list
5. `updateCount(String key)`: Update a count in the map
6. `createDirectory(String path)`: Create a directory
7. `parseDate(String dateStr)`: Convert a string to a date
8. `copyFile(String source, String destination)`: Copy a file
9. `validateEmail(String email)`: Validate an email address
10. `processNumbers(List<String> numbers)`: Process a list of numbers

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/exceptions/ExceptionDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'ExceptionDebugExerciseTest'"
4. All tests will fail initially
5. Fix each method in `ExceptionDebugExercise.java` and run the tests again

### Using Command Line

1. Open a terminal in the project directory
2. Run the tests:
   ```bash
   mvn test
   ```
3. All tests will fail initially
4. Fix each method in `ExceptionDebugExercise.java` and run the tests again

## Debugging Hints

1. Check for proper exception handling:
   - Use try-catch blocks where appropriate
   - Handle specific exceptions rather than catching all
   - Clean up resources in finally blocks or use try-with-resources
2. Consider common exceptions:
   - FileNotFoundException
   - NumberFormatException
   - ArithmeticException
   - IndexOutOfBoundsException
   - NullPointerException
   - IllegalArgumentException
3. Validate input parameters
4. Handle edge cases
5. Use appropriate exception types

## Learning Objectives

- Understanding different types of exceptions
- Proper exception handling techniques
- Resource management
- Input validation
- Error handling best practices 