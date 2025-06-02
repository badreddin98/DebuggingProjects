# Reflection Debugging Exercise

This exercise consists of 10 broken reflection scenarios that need to be fixed. Each scenario demonstrates a different aspect of Java reflection.

## Exercise Structure

The exercise consists of a single class `ReflectionDebugExercise.java` with 10 methods that need to be fixed:

1. `getClassByName(String className)`: Should properly load a class by name
2. `invokeMethod(Object obj, String methodName)`: Should properly invoke a method
3. `getFieldValue(Object obj, String fieldName)`: Should properly access a field
4. `createInstance(String className)`: Should properly create an instance
5. `invokeMethodWithParams(Object obj, String methodName, Object... params)`: Should properly invoke a method with parameters
6. `createArray(String className, int size)`: Should properly create an array
7. `getAnnotations(Object obj)`: Should properly get annotations
8. `getInterfaces(Object obj)`: Should properly get interfaces
9. `getGenericTypes(Object obj)`: Should properly get generic types
10. `createProxy(Object target, Class<?>... interfaces)`: Should properly create a proxy

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/reflection/ReflectionDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'ReflectionDebugExerciseTest'"

### Using Command Line

```bash
mvn test
```

## Debugging Hints

1. Check for proper exception handling:
   - ClassNotFoundException
   - NoSuchMethodException
   - IllegalAccessException
   - InvocationTargetException

2. Look for access control:
   - Public access
   - Private access
   - Protected access
   - Package-private access

3. Consider reflection safety:
   - Method parameters
   - Field access
   - Constructor access
   - Proxy creation

4. Handle reflection features:
   - Annotations
   - Interfaces
   - Generic types
   - Arrays

## Learning Objectives

1. Understanding Java reflection
2. Working with reflection APIs
3. Handling reflection exceptions
4. Managing access control
5. Using reflection safely
6. Working with annotations
7. Handling interfaces
8. Managing generic types
9. Creating proxies
10. Debugging reflection code 