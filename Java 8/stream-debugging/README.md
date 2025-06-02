# Stream API Debugging Exercise

This exercise contains 10 broken Stream API operations that need to be fixed. Each method in `StreamDebugExercise.java` has a bug that needs to be identified and corrected.

## Exercise Description

The code contains 10 methods with different Stream API operations that need to be fixed:

1. `sumEvenNumbers()`: Should return the sum of even numbers multiplied by 2
2. `getLongWords()`: Should return a list of words longer than 5 characters in uppercase
3. `averageOfLargeNumbers()`: Should return the average of numbers greater than 5
4. `joinWords()`: Should return a string of all words joined with commas
5. `areAllPositive()`: Should return true if all numbers are positive
6. `wordLengthMap()`: Should return a map of words to their lengths
7. `getAdultNames()`: Should return a list of names of people aged 18 or older
8. `findFirstDivisibleByThree()`: Should return the first number divisible by 3
9. `getSortedSquares()`: Should return a list of numbers squared and sorted
10. `countWordsWithA()`: Should return the count of words containing the letter 'a'

## Running the Exercise

### Using IntelliJ IDEA:
1. Open the project in IntelliJ IDEA
2. Wait for Maven to download dependencies
3. Navigate to `src/test/java/com/teaching/stream/StreamDebugExerciseTest.java`
4. Run the tests to see which operations are failing
5. Fix the bugs in `StreamDebugExercise.java`
6. Run the tests again to verify your fixes

### Using Command Line:
1. Open a terminal in the project directory
2. Run `mvn clean test` to see the failing tests
3. Fix the bugs in `StreamDebugExercise.java`
4. Run `mvn test` again to verify your fixes

## Hints
- Each method has a comment indicating what it should do
- The test cases show the expected output
- Pay attention to terminal operations in Stream API
- Check the handling of Optional values
- Verify the predicates used in filter operations
- Consider case sensitivity in string operations
- Watch out for duplicate keys in map operations
- Remember to handle null values appropriately
- Check sorting order in sorted operations
- Verify the order of operations in the stream pipeline

## Learning Objectives
- Understanding Stream API operations
- Working with terminal operations
- Handling Optional values
- Using proper predicates
- Understanding Stream pipeline composition
- Working with Collectors
- Map operations and key handling
- String operations in streams
- Sorting and ordering
- Null safety and error handling 