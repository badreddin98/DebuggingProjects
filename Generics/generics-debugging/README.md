# Generics Debugging Exercise

This exercise consists of 10 broken generics scenarios that need to be fixed. Each scenario demonstrates a different aspect of Java generics.

## Exercise Structure

The exercise consists of a single class `GenericsDebugExercise.java` with 10 methods that need to be fixed:

1. `getList()`: Should return a properly typed list
2. `createArray(T element)`: Should create a type-safe array
3. `processList(List<?> list)`: Should properly handle unbounded wildcards
4. `addNumbers(List<T> numbers)`: Should properly handle bounded type parameters
5. `addToList(List<T> list, T element)`: Should maintain type safety
6. `getFirst(List<T> list)`: Should properly handle generic methods
7. `Box<T>`: Should properly handle generic classes
8. `copyList(List<? extends Number>, List<? super Number>)`: Should properly use wildcards
9. `Container<T>`: Should avoid type parameter shadowing
10. `createGenericArray(int size)`: Should properly create generic arrays

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/generics/GenericsDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'GenericsDebugExerciseTest'"

### Using Command Line

```bash
mvn test
```

## Debugging Hints

1. Check for type safety:
   - Raw type usage
   - Type erasure
   - Unchecked casts
   - Type bounds

2. Look for wildcard usage:
   - Upper bounded wildcards
   - Lower bounded wildcards
   - Unbounded wildcards
   - Wildcard capture

3. Consider generic methods:
   - Type parameter declaration
   - Type inference
   - Method overloading
   - Type bounds

4. Handle generic classes:
   - Type parameter declaration
   - Type parameter usage
   - Type parameter shadowing
   - Generic inheritance

## Learning Objectives

1. Understanding Java generics
2. Working with type parameters
3. Using wildcards
4. Handling type erasure
5. Implementing generic methods
6. Creating generic classes
7. Using type bounds
8. Avoiding type safety issues
9. Working with generic arrays
10. Debugging generic code 