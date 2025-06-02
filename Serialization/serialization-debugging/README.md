# Serialization Debugging Exercise

This exercise consists of 10 broken serialization scenarios that need to be fixed. Each scenario demonstrates different aspects of Java serialization.

## Exercise Structure

The exercise contains the following serialization scenarios to fix:

1. `Person` - Missing serialVersionUID
2. `Student` - Non-serializable field
3. `Account` - Incorrect custom serialization
4. `Employee` - Incorrect transient field handling
5. `Product` - Incorrect externalizable implementation
6. `Configuration` - Incorrect serialization of static fields
7. `Manager` - Incorrect handling of inherited fields
8. `Library` - Incorrect serialization of collections
9. `Node` - Incorrect handling of circular references
10. `Order` - Incorrect serialization of enums

## How to Run

### Using IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/serialization/SerializationDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'SerializationDebugExerciseTest'"

### Using Command Line
```bash
mvn test
```

## Debugging Hints

1. Check serialization basics:
   - Proper implementation of Serializable interface
   - Correct serialVersionUID
   - Valid field types
   - Proper constructor usage

2. Check serialization features:
   - Custom serialization methods
   - Externalizable interface
   - Transient fields
   - Static fields
   - Inherited fields
   - Collections
   - Circular references
   - Enums

3. Check serialization constraints:
   - Non-serializable fields
   - Security concerns
   - Version compatibility
   - Performance implications

4. Check serialization patterns:
   - Custom serialization
   - Externalization
   - Serialization proxies
   - Defensive copying

## Learning Objectives

By completing this exercise, you will:

1. Understand Java serialization
2. Learn how to properly implement Serializable
3. Understand serialization features and limitations
4. Learn how to work with custom serialization
5. Understand serialization patterns and use cases
6. Learn how to use serialization in real-world scenarios
7. Understand the relationship between serialization and other Java features
8. Learn how to debug serialization issues
9. Understand the benefits and drawbacks of serialization
10. Learn how to use serialization effectively in your code 