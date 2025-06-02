# Interface Segregation Principle (ISP) Debugging Exercise

This exercise contains 10 broken scenarios that violate the Interface Segregation Principle. Each scenario demonstrates an interface that forces clients to depend on methods they don't use.

## Exercise Structure

The exercise consists of 10 interfaces, each violating ISP in different ways:

1. `Worker` Interface
   - Too many responsibilities
   - Forces developers to implement design and test methods
   - Violates single responsibility

2. `Printer` Interface
   - Unrelated methods (print, scan, fax, copy, staple)
   - Basic printers forced to implement advanced features
   - Mixed concerns

3. `Vehicle` Interface
   - Mixed concerns (operation and maintenance)
   - Electric cars forced to implement fuel-related methods
   - Maintenance operations mixed with core functionality

4. `User` Interface
   - Too many features
   - Guest users forced to implement admin features
   - Mixed user roles and permissions

5. `Database` Interface
   - Mixed operations (read, write, maintenance)
   - Read-only databases forced to implement write operations
   - Administrative functions mixed with core operations

6. `MediaPlayer` Interface
   - Too many features
   - Basic players forced to implement advanced features
   - Mixed playback and editing capabilities

7. `Document` Interface
   - Mixed operations
   - Read-only documents forced to implement write operations
   - Administrative functions mixed with core operations

8. `PaymentProcessor` Interface
   - Too many payment methods
   - Basic processors forced to implement all payment types
   - Administrative functions mixed with core operations

9. `NotificationService` Interface
   - Mixed notification channels
   - Basic services forced to implement all channels
   - Administrative functions mixed with core operations

10. `FileHandler` Interface
    - Too many operations
    - Basic handlers forced to implement advanced features
    - Mixed core and utility operations

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to the test class `ISPDebugExerciseTest`
3. Right-click on the test class and select "Run 'ISPDebugExerciseTest'"

### Using Command Line
1. Open a terminal in the project directory
2. Run the following command:
   ```bash
   mvn test
   ```

## Debugging Hints

### Identifying ISP Violations
- Look for interfaces with many methods
- Identify methods that are not used by all implementers
- Look for interfaces that mix different concerns
- Check for methods that throw "not supported" exceptions
- Look for interfaces that force implementers to provide empty implementations

### Refactoring Strategies
- Split large interfaces into smaller ones
- Create role-specific interfaces
- Use interface inheritance
- Apply the Single Responsibility Principle
- Consider the Adapter pattern

### Common Violations
- Fat interfaces
- Unused method implementations
- Mixed concerns
- Forced dependencies
- Empty method implementations

## Learning Objectives

By completing this exercise, you will:
1. Understand the Interface Segregation Principle
2. Learn to identify ISP violations
3. Master techniques for creating focused interfaces
4. Understand the importance of client-specific interfaces
5. Learn to split large interfaces into smaller ones
6. Understand the relationship between ISP and other SOLID principles
7. Master the art of interface design
8. Learn to create maintainable and flexible interfaces
9. Understand the importance of role-based interfaces
10. Develop skills in creating cohesive interfaces 