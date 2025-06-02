# Dependency Inversion Principle (DIP) Debugging Exercise

This exercise contains 10 broken scenarios that violate the Dependency Inversion Principle. Each scenario demonstrates a class that directly depends on concrete implementations instead of abstractions.

## Exercise Structure

The exercise consists of 10 pairs of classes, each violating DIP in different ways:

1. `UserService` and `MySQLDatabase`
   - Direct dependency on MySQL implementation
   - No abstraction for database operations
   - Hard to switch to different database

2. `OrderProcessor` and `FileLogger`
   - Direct dependency on file logging
   - No abstraction for logging
   - Hard to switch to different logging mechanism

3. `ShoppingCart` and `PayPalPaymentProcessor`
   - Direct dependency on PayPal
   - No abstraction for payment processing
   - Hard to support different payment methods

4. `UserManager` and `EmailNotificationService`
   - Direct dependency on email notifications
   - No abstraction for notifications
   - Hard to support different notification channels

5. `DocumentManager` and `LocalFileSystem`
   - Direct dependency on local file system
   - No abstraction for storage
   - Hard to switch to cloud storage

6. `ProductService` and `RedisCache`
   - Direct dependency on Redis
   - No abstraction for caching
   - Hard to switch to different cache implementation

7. `OrderService` and `RabbitMQ`
   - Direct dependency on RabbitMQ
   - No abstraction for message queuing
   - Hard to switch to different message broker

8. `SearchService` and `ElasticSearch`
   - Direct dependency on ElasticSearch
   - No abstraction for search
   - Hard to switch to different search engine

9. `SecurityManager` and `LDAPAuthentication`
   - Direct dependency on LDAP
   - No abstraction for authentication
   - Hard to support different auth methods

10. `ReportService` and `PDFReportGenerator`
    - Direct dependency on PDF generation
    - No abstraction for report generation
    - Hard to support different report formats

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to the test class `DIPDebugExerciseTest`
3. Right-click on the test class and select "Run 'DIPDebugExerciseTest'"

### Using Command Line
1. Open a terminal in the project directory
2. Run the following command:
   ```bash
   mvn test
   ```

## Debugging Hints

### Identifying DIP Violations
- Look for direct instantiation of concrete classes
- Check for hardcoded dependencies
- Look for classes that depend on specific implementations
- Identify classes that are hard to test
- Look for classes that are hard to modify

### Refactoring Strategies
- Create interfaces for dependencies
- Use dependency injection
- Apply the Interface Segregation Principle
- Consider the Factory pattern
- Use the Strategy pattern

### Common Violations
- Direct instantiation
- Hardcoded dependencies
- Concrete class dependencies
- Lack of abstractions
- Tight coupling

## Learning Objectives

By completing this exercise, you will:
1. Understand the Dependency Inversion Principle
2. Learn to identify DIP violations
3. Master techniques for creating abstractions
4. Understand the importance of dependency injection
5. Learn to use interfaces effectively
6. Understand the relationship between DIP and other SOLID principles
7. Master the art of loose coupling
8. Learn to create testable code
9. Understand the importance of flexibility
10. Develop skills in creating maintainable code 