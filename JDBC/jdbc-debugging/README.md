# JDBC Debugging Exercise

This exercise consists of 10 broken JDBC scenarios that need to be fixed. Each scenario demonstrates a different aspect of database programming in Java.

## Exercise Structure

The exercise consists of a single class `JdbcDebugExercise.java` with 10 methods that need to be fixed:

1. `getConnection()`: Should properly manage database connections
2. `findUsersByName(String name)`: Should safely query users by name
3. `insertUser(String name, int age)`: Should safely insert a new user
4. `transferMoney(int fromId, int toId, double amount)`: Should safely transfer money between accounts
5. `insertUsers(List<String> names)`: Should efficiently insert multiple users
6. `getAccountBalance(int accountId)`: Should safely retrieve account balance
7. `updateUserLastLogin(int userId)`: Should properly handle date updates
8. `getAllUsers()`: Should efficiently handle large result sets
9. `saveUserImage(int userId, byte[] imageData)`: Should properly handle BLOB data
10. `callStoredProcedure(int userId)`: Should properly handle stored procedures

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/jdbc/JdbcDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'JdbcDebugExerciseTest'"

### Using Command Line

```bash
mvn test
```

## Debugging Hints

1. Check for proper resource management:
   - Connection closing
   - Statement closing
   - ResultSet closing
   - Using try-with-resources

2. Look for security issues:
   - SQL injection vulnerabilities
   - Proper parameter binding
   - Input validation

3. Consider performance:
   - Batch processing
   - Connection pooling
   - Prepared statements
   - Large result set handling

4. Handle transactions properly:
   - Transaction boundaries
   - Commit/rollback
   - Isolation levels
   - Deadlock prevention

## Learning Objectives

1. Understanding JDBC basics
2. Working with database connections
3. Handling SQL exceptions
4. Managing transactions
5. Using prepared statements
6. Working with result sets
7. Handling BLOB data
8. Using stored procedures
9. Implementing batch operations
10. Debugging database applications 