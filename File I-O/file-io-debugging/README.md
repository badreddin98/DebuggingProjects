# File I/O Debugging Exercise

This exercise consists of 10 broken File I/O scenarios that need to be fixed. Each scenario demonstrates a different aspect of file handling in Java.

## Exercise Structure

The exercise consists of a single class `FileIoDebugExercise.java` with 10 methods that need to be fixed:

1. `readFile(String filename)`: Should properly read a file with resource cleanup
2. `writeToFile(String filename, String content)`: Should properly write to a file with exception handling
3. `copyFile(String source, String destination)`: Should safely copy a file with existence checks
4. `createDirectory(String path)`: Should properly create a directory with error handling
5. `appendToFile(String filename, String content)`: Should safely append to a file with proper locking
6. `readLargeFile(String filename)`: Should efficiently read a large file with proper buffering
7. `createTempFile(String prefix, String suffix)`: Should properly handle temporary file creation
8. `makeFileExecutable(String filename)`: Should properly handle file permissions
9. `createZipFile(String zipFilename, List<String> files)`: Should properly handle zip file creation
10. `watchDirectory(String directory)`: Should properly handle directory watching

## How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/test/java/com/teaching/fileio/FileIoDebugExerciseTest.java`
3. Right-click on the test class and select "Run 'FileIoDebugExerciseTest'"

### Using Command Line

```bash
mvn test
```

## Debugging Hints

1. Check for proper resource management:
   - File stream closing
   - Using try-with-resources
   - Proper cleanup in finally blocks

2. Look for error handling:
   - File existence checks
   - Permission checks
   - Proper exception handling
   - Error recovery

3. Consider performance:
   - Buffering for large files
   - Efficient file operations
   - Memory management
   - Resource cleanup

4. Handle file operations safely:
   - File locking
   - Atomic operations
   - Transaction-like behavior
   - Backup strategies

## Learning Objectives

1. Understanding File I/O basics
2. Working with file streams
3. Handling file operations
4. Managing file resources
5. Using buffered operations
6. Working with file permissions
7. Handling temporary files
8. Using file watching
9. Implementing file compression
10. Debugging file operations 