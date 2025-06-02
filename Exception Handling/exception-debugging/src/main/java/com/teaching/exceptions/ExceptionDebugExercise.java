package com.teaching.exceptions;

import java.io.*;
import java.util.*;

public class ExceptionDebugExercise {
    private List<String> data = new ArrayList<>();
    private Map<String, Integer> counts = new HashMap<>();

    // Bug 1: This method should read a file and return its contents
    public String readFile(String filename) {
        File file = new File(filename);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        return line; // Bug: No resource cleanup, no exception handling
    }

    // Bug 2: This method should parse an integer from a string
    public int parseInteger(String input) {
        return Integer.parseInt(input); // Bug: No exception handling for invalid input
    }

    // Bug 3: This method should divide two numbers
    public double divide(int a, int b) {
        return a / b; // Bug: No division by zero check
    }

    // Bug 4: This method should get an element from a list
    public String getElement(int index) {
        return data.get(index); // Bug: No bounds checking
    }

    // Bug 5: This method should update a count in the map
    public void updateCount(String key) {
        int count = counts.get(key); // Bug: No null check
        counts.put(key, count + 1);
    }

    // Bug 6: This method should create a directory
    public void createDirectory(String path) {
        File dir = new File(path);
        dir.mkdir(); // Bug: No check if directory already exists
    }

    // Bug 7: This method should convert a string to a date
    public Date parseDate(String dateStr) {
        return new Date(dateStr); // Bug: No date format validation
    }

    // Bug 8: This method should copy a file
    public void copyFile(String source, String destination) {
        FileInputStream in = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(destination);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        // Bug: No resource cleanup, no exception handling
    }

    // Bug 9: This method should validate an email address
    public boolean validateEmail(String email) {
        return email.contains("@"); // Bug: Incomplete email validation
    }

    // Bug 10: This method should process a list of numbers
    public List<Integer> processNumbers(List<String> numbers) {
        List<Integer> result = new ArrayList<>();
        for (String num : numbers) {
            result.add(Integer.parseInt(num));
        }
        return result; // Bug: No exception handling for invalid numbers
    }
} 