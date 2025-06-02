# Liskov Substitution Principle (LSP) Debugging Exercise

This exercise contains 10 broken scenarios that violate the Liskov Substitution Principle. Each scenario demonstrates a class hierarchy where subtypes cannot be substituted for their base types without breaking the program's behavior.

## Exercise Structure

The exercise consists of 10 pairs of classes, each violating LSP in different ways:

1. `Rectangle` and `Square`
   - Square modifies the behavior of setWidth and setHeight
   - Violates the contract of the base class

2. `Bird` and `Penguin`
   - Penguin throws an exception for the fly method
   - Breaks the behavioral contract of Bird

3. `Account` and `OverdraftAccount`
   - OverdraftAccount removes the balance check
   - Weakens the postconditions of withdraw

4. `File` and `ReadOnlyFile`
   - ReadOnlyFile throws an exception for write
   - Breaks the behavioral contract of File

5. `Collection` and `ImmutableCollection`
   - ImmutableCollection throws exceptions for modifications
   - Breaks the behavioral contract of Collection

6. `Vehicle` and `ElectricCar`
   - ElectricCar throws an exception for refuel
   - Breaks the behavioral contract of Vehicle

7. `Stack` and `BoundedStack`
   - BoundedStack adds a size restriction
   - Strengthens the preconditions of push

8. `Logger` and `ConsoleLogger`
   - ConsoleLogger adds null check
   - Strengthens the preconditions of log

9. `Shape` and `Circle`
   - Circle adds radius validation
   - Strengthens the preconditions of draw

10. `DatabaseConnection` and `ReadOnlyConnection`
    - ReadOnlyConnection throws an exception for updates
    - Breaks the behavioral contract of DatabaseConnection

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to the test class `LSPDebugExerciseTest`
3. Right-click on the test class and select "Run 'LSPDebugExerciseTest'"

### Using Command Line
1. Open a terminal in the project directory
2. Run the following command:
   ```bash
   mvn test
   ```

## Debugging Hints

### Identifying LSP Violations
- Look for subtypes that throw exceptions for base class methods
- Check for subtypes that strengthen preconditions
- Look for subtypes that weaken postconditions
- Identify subtypes that modify the behavior of base class methods
- Look for subtypes that violate the contract of the base class

### Refactoring Strategies
- Use composition instead of inheritance
- Create interfaces for specific behaviors
- Use the Interface Segregation Principle
- Consider the Template Method pattern
- Use the Strategy pattern for varying behaviors

### Common Violations
- Throwing exceptions in subtype methods
- Strengthening preconditions
- Weakening postconditions
- Modifying base class behavior
- Violating base class contracts

## Learning Objectives

By completing this exercise, you will:
1. Understand the Liskov Substitution Principle
2. Learn to identify LSP violations
3. Master techniques for creating proper inheritance hierarchies
4. Understand the importance of behavioral subtyping
5. Learn to use composition over inheritance
6. Understand the relationship between LSP and other SOLID principles
7. Master the art of designing substitutable types
8. Learn to create robust class hierarchies
9. Understand the importance of contracts in inheritance
10. Develop skills in creating maintainable and extensible code 