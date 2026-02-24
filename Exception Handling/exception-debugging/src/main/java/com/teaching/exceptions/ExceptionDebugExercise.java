package com.teaching.exceptions;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.FileSystemNotFoundException;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ExceptionDebugExercise {
    List<String> data = new ArrayList<>();
    Map<String, Integer> counts = new HashMap<>();

    // Bug 1: This method should read a file and return its contents
    //I had to throw IOException for the input
    public String readFile(String filename) throws IOException {
        File file = new File(filename);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        return line;// Bug: No resource cleanup, no exception handling
    }

    // Bug 2: This method should parse an integer from a string
    public int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
            throw e; // important: rethrow so the test sees it
        }
    }

    // Bug 3: This method should divide two numbers
    public double divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("divide by zero not allowed");
            }
                return (double) a / b;
    }

    // Bug 4: This method should get an element from a list
    public String getElement(int index) {

        if (index < 0 || index >= data.size()) {// Bug: No bounds checking
            System.out.println("getElement error");
            throw new IndexOutOfBoundsException("Element index out of range");
        }
        return data.get(index);
    }



    // Bug 5: This method should update a count in the map
    public void updateCount(String key) {
        int count = counts.get(key); // Bug: No null check
       try {
           counts.put(key, count + 1);
       }catch (NullPointerException e){
           System.out.println("Key not found, initializing count");
           counts.put(key, 1);
       }
    }

    // Bug 6: This method should create a directory
    public void createDirectory(String path) {
        try {
            File dir = new File(path);

            if (dir.exists()) {
                System.out.println("Directory already exists");
            } else {
                dir.mkdir();
            }

        } catch (Exception e) {
            System.out.println("Error creating directory");
        }
    }

    // Bug 7: This method should convert a string to a date
    public Date parseDate(String dateStr) {
        try {
            return new Date(dateStr); // Bug: No date format validation

        }catch (DateTimeParseException dtpe){
            System.out.println("Invalid date format");

        }return  null;
    }

    // Bug 8: This method should copy a file
    // I add exception IoException so it can handle File input
    public void copyFile(String source, String destination) throws IOException {
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        }
    }

    // Bug 9: This method should validate an email address
    public boolean validateEmail(String email) {
        if (email == null) return false;
        int at = email.indexOf('@');
        int dot = email.indexOf(".com");
        return at > 0 && dot > at + 1;
    }


    // Bug 10: This method should process a list of numbers
    public List<Integer> processNumbers(List<String> numbers) {
        List<Integer> result = new ArrayList<>();
        for (String num : numbers) {
            result.add(Integer.parseInt(num)); // auto throws
        }
        return result;
    }
} // Bug: No exception handling for invalid numbers
