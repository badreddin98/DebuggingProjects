# Encapsulation Debugging Exercise

This exercise contains 10 broken scenarios that violate the Encapsulation principle. Each scenario demonstrates a common mistake in object-oriented design where internal state is exposed or not properly protected.

## Exercise Structure

The exercise consists of 10 broken scenarios, each demonstrating a violation of the Encapsulation principle:

1. `BankAccount`: Public fields exposing balance and account details
2. `Student`: Exposed internal list and grade
3. `TemperatureSensor`: Mutable public array and unit
4. `ShoppingCart`: Getter returning mutable object reference
5. `Person`: Setters with no validation
6. `Rectangle`: Exposed internal state (width and height)
7. `Configuration`: Public static mutable fields
8. `ImageProcessor`: Exposed internal array and dimensions
9. `Stack`: Public method exposing internal implementation
10. `Time`: Public fields with no invariants

The exercise also includes an example of correct encapsulation:
- `BankAccountEncapsulated`: Shows proper encapsulation with private fields, validation, and controlled access

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/encapsulation/EncapsulationDebugExerciseTest.java`
3. Run the test class or individual test methods

### Using Command Line
```bash
mvn test
```

## Debugging Hints

1. **Identify Exposed State**: Look for public fields and methods that expose internal state
2. **Check Mutable Objects**: Look for getters that return mutable object references
3. **Validate Input**: Check for missing validation in setters
4. **Consider Invariants**: Look for classes that don't maintain their invariants
5. **Review Access Modifiers**: Check if fields and methods have appropriate access levels

## Refactoring Strategies

1. **Make Fields Private**:
   - Change public fields to private
   - Add getters and setters with validation
   - Consider making fields final if they shouldn't change

2. **Protect Mutable Objects**:
   - Return defensive copies of mutable objects
   - Use immutable collections where possible
   - Consider using builder pattern for complex objects

3. **Add Validation**:
   - Validate input in setters
   - Throw appropriate exceptions for invalid input
   - Maintain class invariants

4. **Use Immutable Objects**:
   - Make fields final
   - Don't provide setters
   - Return new instances for modifications

## Common Violations

1. **Public Fields**: Exposing internal state directly
2. **Mutable References**: Returning references to mutable objects
3. **Missing Validation**: Not validating input in setters
4. **Exposed Implementation**: Revealing internal implementation details
5. **No Invariants**: Not maintaining class invariants

## Learning Objectives

By completing this exercise, you will learn to:
1. Identify encapsulation violations
2. Implement proper access control
3. Protect internal state
4. Maintain class invariants
5. Use defensive programming techniques
6. Create robust and maintainable classes
7. Understand the importance of validation
8. Apply proper object-oriented design principles
9. Use immutable objects effectively
10. Implement proper getters and setters 