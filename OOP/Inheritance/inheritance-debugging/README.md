# Inheritance Debugging Exercise

This exercise contains 10 broken scenarios that violate proper inheritance principles. Each scenario demonstrates a common mistake in object-oriented design where inheritance is misused or implemented incorrectly.

## Exercise Structure

The exercise consists of 10 broken scenarios, each demonstrating a violation of inheritance principles:

1. `Bird` and `Penguin`: Breaking Liskov Substitution Principle
2. `List` and `CountingList`: Fragile Base Class Problem
3. `Animal`, `Dog`, `Robot`, and `RobotDog`: Diamond Problem
4. `Stack` and `StringList`: Inheritance for Code Reuse
5. `Base` and `Derived`: Tight Coupling
6. `Rectangle` and `Square`: Inheritance of Implementation
7. `Constants` and `MathConstants`: Inheritance of Constants
8. `Parent` and `Child`: Inheritance of Static Methods
9. `Vehicle` and `Car`: Inheritance of Final Methods
10. `ParentClass` and `ChildClass`: Inheritance of Private Methods

The exercise also includes an example of correct inheritance:
- `Shape` and `Circle`: Shows proper inheritance with abstract classes and method overriding

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/inheritance/InheritanceDebugExerciseTest.java`
3. Run the test class or individual test methods

### Using Command Line
```bash
mvn test
```

## Debugging Hints

1. **Check LSP Violations**: Look for subclasses that break the contract of their parent class
2. **Review Base Class Design**: Check if base classes are properly designed for extension
3. **Consider Multiple Inheritance**: Look for diamond problem scenarios
4. **Evaluate Inheritance Purpose**: Check if inheritance is used for the right reasons
5. **Examine Method Overriding**: Look for improper method overrides

## Refactoring Strategies

1. **Fix LSP Violations**:
   - Ensure subclasses maintain the contract of their parent class
   - Use interfaces for behavior contracts
   - Consider composition over inheritance

2. **Improve Base Class Design**:
   - Make base classes abstract when appropriate
   - Use protected methods for extension points
   - Document extension points clearly

3. **Handle Multiple Inheritance**:
   - Use interfaces instead of multiple inheritance
   - Consider composition for multiple behaviors
   - Use delegation for shared functionality

4. **Proper Method Overriding**:
   - Maintain method contracts
   - Use @Override annotation
   - Call super methods when appropriate

## Common Violations

1. **LSP Violations**: Subclasses breaking parent class contracts
2. **Fragile Base Class**: Base classes not designed for extension
3. **Diamond Problem**: Multiple inheritance conflicts
4. **Inheritance for Code Reuse**: Using inheritance where composition would be better
5. **Improper Method Overriding**: Breaking method contracts

## Learning Objectives

By completing this exercise, you will learn to:
1. Identify inheritance violations
2. Apply the Liskov Substitution Principle
3. Design proper inheritance hierarchies
4. Use composition over inheritance when appropriate
5. Implement proper method overriding
6. Handle multiple inheritance scenarios
7. Design extensible base classes
8. Maintain method contracts
9. Use interfaces effectively
10. Apply proper object-oriented design principles 