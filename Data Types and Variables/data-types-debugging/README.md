# Data Types and Variables Debugging Exercise

This exercise contains 10 broken scenarios related to Java data types and variables that need to be fixed. Each scenario demonstrates different aspects of working with data types and variables in Java.

## Exercise Structure

The exercise consists of 10 classes, each containing bugs related to different data type and variable concepts:

1. `NumberOperations`: Incorrect primitive type usage
   - Integer division issues
   - Potential overflow in calculations

2. `FloatingPointComparison`: Incorrect floating-point comparison
   - Direct comparison of floating-point numbers
   - Comparison with zero

3. `StringOperations`: Incorrect string handling
   - Inefficient string concatenation
   - Reference comparison instead of value comparison

4. `ArrayOperations`: Incorrect array handling
   - Missing bounds checking
   - Incorrect initial values

5. `WrapperOperations`: Incorrect wrapper class usage
   - Potential NullPointerException
   - Incorrect null handling

6. `BigDecimalOperations`: Incorrect BigDecimal usage
   - Incorrect operator usage
   - Incorrect comparison methods

7. `DateOperations`: Incorrect date handling
   - Missing validation
   - Incorrect day values

8. `CollectionOperations`: Incorrect collection handling
   - Missing null checks
   - Missing bounds checking

9. `EnumOperations`: Incorrect enum usage
   - Direct comparison
   - Missing exception handling

10. `ScopeOperations`: Incorrect variable scope
    - Variable shadowing
    - Static variable usage

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to the test class `DataTypesDebugExerciseTest`
3. Right-click on the test class and select "Run 'DataTypesDebugExerciseTest'"

### Using Command Line
1. Open a terminal in the project directory
2. Run the following command:
   ```bash
   mvn test
   ```

## Debugging Hints

### Data Types
- Understand the difference between primitive types and wrapper classes
- Be aware of type conversion and potential loss of precision
- Consider the range and limitations of each data type

### Variables
- Pay attention to variable scope and lifetime
- Understand the difference between instance and static variables
- Be careful with variable shadowing

### Common Issues
- Null handling
- Bounds checking
- Type safety
- Memory efficiency
- Thread safety

## Learning Objectives

By completing this exercise, you will:
1. Understand the proper usage of different data types in Java
2. Learn how to handle primitive types and wrapper classes correctly
3. Master floating-point number comparisons
4. Understand string manipulation and comparison
5. Learn proper array and collection handling
6. Understand the importance of null checking
7. Master BigDecimal operations
8. Learn proper date handling
9. Understand enum usage and comparison
10. Master variable scope and static variable usage 