package com.teaching.fileio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipFile;

public class FileIoDebugExerciseTest {
    private FileIoDebugExercise exercise;
    private Path tempDir;

    @BeforeEach
    void setUp(@TempDir Path tempDir) {
        exercise = new FileIoDebugExercise();
        this.tempDir = tempDir;
    }

    @Test
    void testReadFile() throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, "Hello, World!".getBytes());
        String content = exercise.readFile(testFile.toString());
        assertEquals("Hello, World!", content);
    }

    @Test
    void testWriteToFile() throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        exercise.writeToFile(testFile.toString(), "Test content");
        String content = Files.readString(testFile);
        assertEquals("Test content", content);
    }

    @Test
    void testCopyFile() throws IOException {
        Path sourceFile = tempDir.resolve("source.txt");
        Path destFile = tempDir.resolve("dest.txt");
        Files.write(sourceFile, "Source content".getBytes());
        exercise.copyFile(sourceFile.toString(), destFile.toString());
        String content = Files.readString(destFile);
        assertEquals("Source content", content);
    }

    @Test
    void testCreateDirectory() throws IOException {
        Path dirPath = tempDir.resolve("testdir");
        exercise.createDirectory(dirPath.toString());
        assertTrue(Files.isDirectory(dirPath));
    }

    @Test
    void testAppendToFile() throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, "Initial content".getBytes());
        exercise.appendToFile(testFile.toString(), "\nAppended content");
        String content = Files.readString(testFile);
        assertEquals("Initial content\nAppended content", content);
    }

    @Test
    void testReadLargeFile() throws IOException {
        Path testFile = tempDir.resolve("large.txt");
        List<String> expectedLines = Arrays.asList("Line 1", "Line 2", "Line 3");
        Files.write(testFile, String.join("\n", expectedLines).getBytes());
        List<String> lines = exercise.readLargeFile(testFile.toString());
        assertEquals(expectedLines, lines);
    }

    @Test
    void testCreateTempFile() throws IOException {
        File tempFile = exercise.createTempFile("test", ".txt");
        assertTrue(tempFile.exists());
        assertTrue(tempFile.getName().startsWith("test"));
        assertTrue(tempFile.getName().endsWith(".txt"));
        tempFile.delete();
    }

    @Test
    void testMakeFileExecutable() throws IOException {
        Path testFile = tempDir.resolve("test.sh");
        Files.write(testFile, "#!/bin/bash\necho 'test'".getBytes());
        exercise.makeFileExecutable(testFile.toString());
        assertTrue(Files.isExecutable(testFile));
    }

    @Test
    void testCreateZipFile() throws IOException {
        Path file1 = tempDir.resolve("file1.txt");
        Path file2 = tempDir.resolve("file2.txt");
        Files.write(file1, "Content 1".getBytes());
        Files.write(file2, "Content 2".getBytes());
        Path zipFile = tempDir.resolve("test.zip");
        exercise.createZipFile(zipFile.toString(), 
            Arrays.asList(file1.toString(), file2.toString()));
        assertTrue(Files.exists(zipFile));
        try (ZipFile zip = new ZipFile(zipFile.toFile())) {
            assertEquals(2, zip.size());
        }
    }

    @Test
    void testWatchDirectory() throws IOException {
        Path watchDir = tempDir.resolve("watchdir");
        Files.createDirectory(watchDir);
        Thread watcherThread = new Thread(() -> {
            try {
                exercise.watchDirectory(watchDir.toString());
            } catch (IOException e) {
                fail("Watch directory failed", e);
            }
        });
        watcherThread.start();
        Files.write(watchDir.resolve("test.txt"), "test".getBytes());
        watcherThread.join(1000);
    }
} 