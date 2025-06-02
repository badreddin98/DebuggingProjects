# Polymorphism Debugging Exercise

This exercise contains 10 broken scenarios that violate proper polymorphism principles. Each scenario demonstrates a common mistake in object-oriented design where polymorphism is misused or implemented incorrectly.

## Exercise Structure

The exercise consists of 10 broken scenarios, each demonstrating a violation of polymorphism principles:

1. `ShapeProcessor`: Type checking instead of polymorphism
2. `MathOperations` and `AdvancedMath`: Static method polymorphism issues
3. `Parent` and `Child`: Field hiding problems
4. `Animal` and `Dog`: Covariant return type issues
5. `Calculator`: Method overloading confusion
6. `Drawable` interface: Interface implementation issues
7. `DataProcessor` and `StringProcessor`: Polymorphic method parameter problems
8. `Base` and `Derived`: Constructor chaining issues
9. `ParentClass` and `ChildClass`: Method overriding with different access
10. `AnimalList`: Polymorphic collection issues

The exercise also includes an example of correct polymorphism:
- `Shape`, `Circle`, and `Rectangle`: Shows proper polymorphism with abstract classes and method overriding

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/polymorphism/PolymorphismDebugExerciseTest.java`
3. Run the test class or individual test methods

### Using Command Line
```bash
mvn test
```

## Debugging Hints

1. **Check Type Checking**: Look for instanceof checks that could be replaced with polymorphism
2. **Review Static Methods**: Check if static methods are being used where instance methods would be better
3. **Examine Field Access**: Look for field hiding issues
4. **Verify Method Overriding**: Check for proper method overriding and access modifiers
5. **Consider Generic Types**: Look for issues with generic type parameters

## Refactoring Strategies

1. **Replace Type Checking**:
   - Use abstract methods in base classes
   - Implement interfaces
   - Use the strategy pattern

2. **Fix Static Method Issues**:
   - Convert static methods to instance methods
   - Use the template method pattern
   - Consider the factory pattern

3. **Handle Field Hiding**:
   - Use protected fields
   - Implement proper getters and setters
   - Consider using the builder pattern

4. **Improve Method Overriding**:
   - Use @Override annotation
   - Maintain method contracts
   - Follow Liskov Substitution Principle

## Common Violations

1. **Type Checking**: Using instanceof instead of polymorphism
2. **Static Methods**: Misusing static methods in inheritance
3. **Field Hiding**: Hiding fields in subclasses
4. **Method Overriding**: Breaking method contracts
5. **Generic Types**: Incorrect use of generic type parameters

## Learning Objectives

By completing this exercise, you will learn to:
1. Identify polymorphism violations
2. Implement proper method overriding
3. Use interfaces effectively
4. Handle generic type parameters
5. Apply the strategy pattern
6. Use the template method pattern
7. Implement proper constructor chaining
8. Maintain method contracts
9. Use abstract classes correctly
10. Apply proper object-oriented design principles 