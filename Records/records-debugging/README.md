# Records Debugging Exercise

This exercise consists of 10 broken record scenarios that need to be fixed. Each scenario demonstrates different aspects of Java records.

## Exercise Structure

The exercise consists of a single class `RecordsDebugExercise.java` with 10 record declarations that need to be fixed:

1. `Person`: Should properly validate age in the compact constructor
2. `Address`: Should properly handle nested record declaration
3. `Student`: Should properly calculate average grade
4. `Email`: Should properly validate email address
5. `Employee`: Should properly handle record inheritance
6. `MutablePoint`: Should properly handle immutability
7. `Configuration`: Should properly handle static fields
8. `Point`: Should properly implement equals/hashCode
9. `SerializablePerson`: Should properly handle serialization
10. `Pair`: Should properly handle generic type parameters

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/records/RecordsDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'RecordsDebugExerciseTest'"
4. Fix each record in `RecordsDebugExercise.java` until all tests pass

### Using Command Line

1. Open a terminal in the project directory
2. Run the tests:
   ```bash
   mvn test
   ```
3. Fix each record in `RecordsDebugExercise.java` until all tests pass

## Debugging Hints

1. Check for proper record syntax:
   - Record declaration
   - Component declarations
   - Compact constructors
   - Custom methods

2. Look for record constraints:
   - Immutability
   - No inheritance
   - No instance fields
   - No synchronized methods

3. Consider record features:
   - Component accessors
   - equals/hashCode
   - toString
   - Serialization

4. Handle record validation:
   - Input validation
   - Null checks
   - Business rules
   - Error messages

## Learning Objectives

- Understand Java records
- Work with record components
- Handle record validation
- Use record methods
- Implement record patterns
- Handle record serialization
- Work with generic records
- Use record inheritance
- Handle record immutability
- Debug record issues 