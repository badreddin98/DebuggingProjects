# Design Patterns Debugging Exercise

This exercise contains 10 broken design pattern implementations that violate best practices. Students are required to identify and fix these issues.

## Exercise Structure

The exercise consists of two main files:
1. `DesignPatternsDebugExercise.java`: Contains the classes with design pattern issues
2. `DesignPatternsDebugExerciseTest.java`: Contains the test cases to verify fixes

## Broken Scenarios

1. **Singleton Anti-pattern**
   - Class: `DatabaseConnection`
   - Issue: Not thread-safe implementation
   - Fix: Implement double-checked locking or use enum singleton

2. **Factory Anti-pattern**
   - Class: `VehicleFactory`
   - Issue: Violates Open/Closed Principle
   - Fix: Use abstract factory or factory method pattern

3. **Observer Anti-pattern**
   - Class: `WeatherStation`
   - Issue: Tight coupling between subject and observers
   - Fix: Use interfaces and loose coupling

4. **Strategy Anti-pattern**
   - Class: `PaymentProcessor`
   - Issue: No abstraction for payment strategies
   - Fix: Create payment strategy interface

5. **Decorator Anti-pattern**
   - Class: `BasicCoffee` and `MilkCoffee`
   - Issue: Using inheritance instead of composition
   - Fix: Implement proper decorator pattern

6. **Command Anti-pattern**
   - Class: `LightSwitch`
   - Issue: No undo functionality
   - Fix: Implement command pattern with undo

7. **Adapter Anti-pattern**
   - Class: `ModernSystem`
   - Issue: Violates Single Responsibility Principle
   - Fix: Create proper adapter class

8. **Template Method Anti-pattern**
   - Class: `DataProcessor`
   - Issue: No hooks for customization
   - Fix: Add hook methods

9. **Builder Anti-pattern**
   - Class: `UserBuilder`
   - Issue: No validation in build method
   - Fix: Add validation before object creation

10. **Chain of Responsibility Anti-pattern**
    - Class: `RequestHandler`
    - Issue: No fallback mechanism
    - Fix: Implement proper fallback handling

## Example of Correct Implementation

The `ThreadSafeSingleton` class demonstrates proper implementation of the Singleton pattern:
- Thread-safe using double-checked locking
- Private constructor
- Volatile instance variable
- Proper synchronization

## How to Run the Exercise

1. Clone the repository
2. Open the project in your IDE
3. Run the tests to see them fail
4. Fix each issue one at a time
5. Verify your fixes by running the tests

## Learning Objectives

- Understand common design patterns
- Identify anti-patterns and their issues
- Learn to implement patterns correctly
- Practice refactoring code to use patterns
- Understand when to use each pattern

## Design Pattern Categories

1. **Creational Patterns**
   - Singleton
   - Factory Method
   - Abstract Factory
   - Builder
   - Prototype

2. **Structural Patterns**
   - Adapter
   - Bridge
   - Composite
   - Decorator
   - Facade
   - Flyweight
   - Proxy

3. **Behavioral Patterns**
   - Chain of Responsibility
   - Command
   - Iterator
   - Mediator
   - Memento
   - Observer
   - State
   - Strategy
   - Template Method
   - Visitor

## Resources

- [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
- [Refactoring Guru](https://refactoring.guru/design-patterns)
- [Source Making](https://sourcemaking.com/design_patterns)
- [Java Design Patterns](https://java-design-patterns.com/) 