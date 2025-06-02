# Composition Debugging Exercise

This exercise contains 10 broken scenarios that violate proper composition principles. Each scenario demonstrates a common mistake in object-oriented design where composition is misused or implemented incorrectly.

## Exercise Structure

The exercise consists of 10 broken scenarios, each demonstrating a violation of composition principles:

1. `Car` and `Engine`: Using inheritance instead of composition
2. `Order` and `MySQLDatabase`: Tight coupling between components
3. `Computer`: Exposed internal components
4. `ConnectionPool`: Missing component lifecycle management
5. `Logger`: Improper component initialization
6. `Department` and `Employee`: Circular dependencies
7. `PaymentProcessor`: Missing component interface
8. `BankAccount`: Improper component access
9. `User`: Missing component validation
10. `ReportGenerator`: Improper component composition

The exercise also includes an example of correct composition:
- `CarComposition`: Shows proper composition with encapsulated components

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/composition/CompositionDebugExerciseTest.java`
3. Run the test class or individual test methods

### Using Command Line
```bash
mvn test
```

## Debugging Hints

1. **Check Class Relationships**: Look for inheritance that should be composition
2. **Review Dependencies**: Check for tight coupling between components
3. **Examine Component Access**: Look for exposed internal components
4. **Verify Lifecycle Management**: Check for proper component initialization and cleanup
5. **Consider Dependencies**: Look for circular dependencies

## Refactoring Strategies

1. **Replace Inheritance with Composition**:
   - Use "has-a" instead of "is-a" relationships
   - Encapsulate components
   - Use interfaces for flexibility

2. **Fix Tight Coupling**:
   - Use dependency injection
   - Implement interfaces
   - Apply the dependency inversion principle

3. **Handle Component Access**:
   - Use proper encapsulation
   - Implement the facade pattern
   - Hide implementation details

4. **Improve Component Management**:
   - Implement proper initialization
   - Add lifecycle management
   - Use the builder pattern

## Common Violations

1. **Inheritance Overuse**: Using inheritance where composition is more appropriate
2. **Tight Coupling**: Direct dependencies on concrete implementations
3. **Exposed Components**: Revealing internal component details
4. **Missing Lifecycle**: Not managing component lifecycles
5. **Circular Dependencies**: Creating circular references between components

## Learning Objectives

By completing this exercise, you will learn to:
1. Identify composition violations
2. Implement proper component relationships
3. Use interfaces effectively
4. Manage component lifecycles
5. Apply the facade pattern
6. Use dependency injection
7. Implement proper encapsulation
8. Handle component initialization
9. Avoid circular dependencies
10. Apply proper object-oriented design principles 