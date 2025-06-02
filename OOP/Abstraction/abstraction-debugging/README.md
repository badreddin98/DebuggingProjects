# Abstraction Debugging Exercise

This exercise contains 10 broken scenarios that violate proper abstraction principles. Each scenario demonstrates a common mistake in object-oriented design where abstraction is misused or implemented incorrectly.

## Exercise Structure

The exercise consists of 10 broken scenarios, each demonstrating a violation of abstraction principles:

1. `Vehicle`: Concrete class that should be abstract
2. `Database`: Exposed implementation details
3. `FileHandler`: Mixed levels of abstraction
4. `Cache`: Leaky abstraction exposing internal implementation
5. `PaymentProcessor`: Incomplete abstraction
6. `DataSource`: Over-abstraction with too many methods
7. `Logger`: Implementation in interface
8. `Shape`: Abstract class with static methods
9. `BankAccount`: Exposed state
10. `UserManager`: Mixed responsibilities

The exercise also includes an example of correct abstraction:
- `AbstractVehicle` and `Car`: Shows proper abstraction with abstract class and concrete implementation

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/abstraction/AbstractionDebugExerciseTest.java`
3. Run the test class or individual test methods

### Using Command Line
```bash
mvn test
```

## Debugging Hints

1. **Check Class Design**: Look for classes that should be abstract
2. **Review Implementation Details**: Check for exposed internal details
3. **Examine Method Levels**: Look for mixed levels of abstraction
4. **Verify State Access**: Check for exposed state
5. **Consider Responsibilities**: Look for mixed responsibilities

## Refactoring Strategies

1. **Improve Class Design**:
   - Use abstract classes appropriately
   - Implement interfaces
   - Hide implementation details

2. **Fix Implementation Exposure**:
   - Use proper encapsulation
   - Implement proper getters and setters
   - Use the facade pattern

3. **Handle Mixed Abstractions**:
   - Separate concerns
   - Use the single responsibility principle
   - Apply the interface segregation principle

4. **Improve State Management**:
   - Encapsulate state
   - Use immutable objects
   - Implement proper validation

## Common Violations

1. **Concrete Classes**: Using concrete classes where abstract classes are needed
2. **Exposed Details**: Revealing implementation details
3. **Mixed Levels**: Combining different levels of abstraction
4. **Leaky Abstractions**: Exposing internal implementation
5. **Incomplete Abstractions**: Missing essential methods

## Learning Objectives

By completing this exercise, you will learn to:
1. Identify abstraction violations
2. Implement proper abstract classes
3. Use interfaces effectively
4. Hide implementation details
5. Apply the facade pattern
6. Use the single responsibility principle
7. Implement proper encapsulation
8. Maintain proper abstraction levels
9. Use immutable objects correctly
10. Apply proper object-oriented design principles 