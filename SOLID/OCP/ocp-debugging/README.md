# Open/Closed Principle (OCP) Debugging Exercise

This exercise contains 10 broken scenarios that violate the Open/Closed Principle. Each scenario demonstrates a class that is not open for extension but closed for modification, requiring refactoring to follow OCP.

## Exercise Structure

The exercise consists of 10 classes, each violating OCP in different ways:

1. `ShapeCalculator`: Hardcoded shape calculations
   - Circle area calculation
   - Rectangle area calculation
   - Triangle area calculation

2. `PaymentProcessor`: Hardcoded payment methods
   - Credit card processing
   - PayPal processing
   - Bank transfer processing

3. `ReportGenerator`: Hardcoded report formats
   - PDF report generation
   - Excel report generation
   - CSV report generation

4. `NotificationService`: Hardcoded notification channels
   - Email notifications
   - SMS notifications
   - Push notifications

5. `DiscountCalculator`: Hardcoded discount types
   - Percentage discounts
   - Fixed amount discounts
   - Seasonal discounts

6. `DataExporter`: Hardcoded export formats
   - JSON export
   - XML export
   - YAML export

7. `LogFormatter`: Hardcoded log levels
   - Info level formatting
   - Error level formatting
   - Debug level formatting

8. `DataValidator`: Hardcoded validation rules
   - Email validation
   - Phone number validation
   - ZIP code validation

9. `FileCompressor`: Hardcoded compression types
   - ZIP compression
   - RAR compression
   - 7Z compression

10. `DataTransformer`: Hardcoded transformation types
    - Uppercase transformation
    - Lowercase transformation
    - Capitalize transformation

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to the test class `OCPDebugExerciseTest`
3. Right-click on the test class and select "Run 'OCPDebugExerciseTest'"

### Using Command Line
1. Open a terminal in the project directory
2. Run the following command:
   ```bash
   mvn test
   ```

## Debugging Hints

### Identifying OCP Violations
- Look for classes that use if-else or switch statements for type-based behavior
- Identify classes that need modification to add new functionality
- Look for hardcoded type checks and string comparisons

### Refactoring Strategies
- Use interfaces to define behavior contracts
- Implement the Strategy pattern for different behaviors
- Use inheritance or composition for extending functionality
- Consider the Template Method pattern for common algorithms
- Use the Factory pattern for object creation

### Common Violations
- Type-based conditional logic
- Hardcoded type checks
- String-based type identification
- Direct instantiation of concrete classes
- Lack of abstraction for varying behavior

## Learning Objectives

By completing this exercise, you will:
1. Understand the Open/Closed Principle
2. Learn to identify classes that violate OCP
3. Master techniques for making classes open for extension
4. Understand how to use interfaces and abstraction
5. Learn to implement the Strategy pattern
6. Understand the importance of polymorphism
7. Master the art of refactoring for OCP
8. Learn to design extensible systems
9. Understand the relationship between OCP and other SOLID principles
10. Develop skills in creating maintainable and extensible code 