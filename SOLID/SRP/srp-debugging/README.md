# Single Responsibility Principle (SRP) Debugging Exercise

This exercise contains 10 broken scenarios that violate the Single Responsibility Principle. Each scenario demonstrates a class that has multiple responsibilities and needs to be refactored to follow SRP.

## Exercise Structure

The exercise consists of 10 classes, each violating SRP in different ways:

1. `UserManager`: Handles both user data and authentication
   - User data management
   - Authentication logic
   - Login history management

2. `OrderProcessor`: Handles both order processing and payment
   - Order item management
   - Payment processing
   - Invoice generation

3. `EmailService`: Handles both email sending and template management
   - SMTP server configuration
   - Template management
   - Email sending

4. `FileProcessor`: Handles both file operations and data processing
   - File reading/writing
   - Data processing
   - Result output

5. `CustomerManager`: Handles both database operations and business logic
   - Database operations
   - Customer validation
   - Welcome email sending

6. `Logger`: Handles both logging and configuration
   - Log level management
   - Log file management
   - Configuration loading

7. `ReportGenerator`: Handles both report generation and data analysis
   - Data collection
   - Statistical analysis
   - Report formatting

8. `CacheManager`: Handles both cache management and data retrieval
   - Cache operations
   - Data loading
   - Cache clearing

9. `DataValidator`: Handles both validation and data transformation
   - Data validation
   - Data transformation
   - File operations

10. `NotificationService`: Handles both notification and user preferences
    - Notification sending
    - Preference management
    - Notification history

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to the test class `SRPDebugExerciseTest`
3. Right-click on the test class and select "Run 'SRPDebugExerciseTest'"

### Using Command Line
1. Open a terminal in the project directory
2. Run the following command:
   ```bash
   mvn test
   ```

## Debugging Hints

### Identifying Responsibilities
- Look for classes that have multiple distinct purposes
- Identify methods that could be grouped by functionality
- Consider if the class name accurately reflects all its responsibilities

### Refactoring Strategies
- Split classes into smaller, focused classes
- Use composition to combine related functionality
- Create separate interfaces for different responsibilities
- Consider using the Facade pattern for complex subsystems

### Common Violations
- Classes that handle both data and presentation
- Classes that manage both business logic and infrastructure
- Classes that handle both configuration and execution
- Classes that manage both validation and processing

## Learning Objectives

By completing this exercise, you will:
1. Understand the Single Responsibility Principle
2. Learn to identify classes with multiple responsibilities
3. Master techniques for separating concerns
4. Understand how to create focused, maintainable classes
5. Learn to use composition effectively
6. Understand the importance of clear class boundaries
7. Master the art of refactoring for SRP
8. Learn to design interfaces that follow SRP
9. Understand the relationship between SRP and other SOLID principles
10. Develop skills in creating maintainable and testable code 