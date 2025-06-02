# Composition Debugging Exercise

This exercise contains 10 scenarios that violate the Composition principle by using inheritance where composition would be more appropriate. Each scenario demonstrates a common mistake in object-oriented design where classes are incorrectly related through inheritance instead of composition.

## Exercise Structure

The exercise consists of 10 broken scenarios, each demonstrating a violation of the Composition principle:

1. **Car and Engine**: `Car` incorrectly inherits from `Engine` instead of containing an engine
2. **Computer and CPU**: `Computer` incorrectly inherits from `CPU` instead of containing a CPU
3. **House and Room**: `House` incorrectly inherits from `Room` instead of containing rooms
4. **Book and Page**: `Book` incorrectly inherits from `Page` instead of containing pages
5. **Phone and Battery**: `Phone` incorrectly inherits from `Battery` instead of containing a battery
6. **Student and Course**: `Student` incorrectly inherits from `Course` instead of being enrolled in courses
7. **Restaurant and Menu**: `Restaurant` incorrectly inherits from `Menu` instead of having a menu
8. **Bank and Account**: `Bank` incorrectly inherits from `Account` instead of managing accounts
9. **Library and Book**: `Library` incorrectly inherits from `Book` instead of containing books
10. **Hospital and Patient**: `Hospital` incorrectly inherits from `Patient` instead of treating patients

The exercise also includes examples of correct composition implementations:
- `CarComposition`: Shows how a car should contain an engine
- `ComputerComposition`: Shows how a computer should contain CPU, memory, and storage components

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

1. **Identify the Relationship**: For each scenario, determine if the relationship between classes is "is-a" (inheritance) or "has-a" (composition)
2. **Look for Inheritance**: Check if classes are using `extends` where they should be using composition
3. **Consider Flexibility**: Think about how the design would need to change if requirements change
4. **Check for Multiple Components**: Consider if a class should be able to have multiple instances of a component

## Refactoring Strategies

1. **Replace Inheritance with Composition**:
   - Remove the `extends` keyword
   - Add a private field for the component
   - Add a constructor to initialize the component
   - Delegate method calls to the component

2. **Use Interfaces**:
   - Define interfaces for components
   - Use interface types for component fields
   - Allow for different implementations of components

3. **Consider Collections**:
   - Use lists or sets for multiple components
   - Add methods to manage components
   - Implement proper encapsulation

## Common Violations

1. **Inheriting Implementation**: Using inheritance to reuse implementation instead of composition
2. **Inheriting Behavior**: Using inheritance to share behavior instead of composition
3. **Inheriting State**: Using inheritance to share state instead of composition
4. **Inheriting Interface**: Using inheritance to share interface instead of composition
5. **Inheriting Multiple Components**: Using inheritance to combine multiple components instead of composition

## Learning Objectives

By completing this exercise, you will learn to:
1. Identify when to use composition instead of inheritance
2. Understand the "has-a" relationship in object-oriented design
3. Implement proper component-based design
4. Create flexible and maintainable class hierarchies
5. Apply the Composition principle in real-world scenarios 