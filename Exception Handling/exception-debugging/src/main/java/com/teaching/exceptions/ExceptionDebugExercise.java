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
    public int parseInteger(String input)  {
        try {
            return Integer.parseInt(input);// Bug: No exception handling for invalid input
        }catch (NumberFormatException e){
            System.out.println("Invalid number");
        }return 0;
    }

    // Bug 3: This method should divide two numbers
    public double divide(int a, int b) {
        try {
            return (double) a / b; // Bug: No division by zero check
        }catch (ArithmeticException e){
            System.err.println("divide by zero not allowed");
        }return 0;
    }

    // Bug 4: This method should get an element from a list
    public String getElement(int index) {
        if (index < 0 || index >= data.size()) {// Bug: No bounds checking
            System.out.println("getElement error");
            return null;
        }
        return data.get(index);
    }



    // Bug 5: This method should update a count in the map
    public void updateCount(String key) {
       try {
           int count = counts.get(key); // Bug: No null check
           counts.put(key, count + 1);
       }catch (NullPointerException e){
           System.out.println("Key not found, initializing count");
       }
    }

    // Bug 6: This method should create a directory
    public void createDirectory(String path) {
        try {
            File dir = new File(path);
            dir.mkdir();  // Bug: No check if directory already exists

            if (dir.exists()){
                System.out.println("Directory already exists");
            }else {
                dir.mkdir();
            }
        }catch (Exception e){
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
    public void copyFile(String source, String destination) {
         try {
             FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination);

             byte[] buffer = new byte[1024];
             int length;
             while ((length = in.read(buffer)) > 0) {
                 out.write(buffer, 0, length);
             }
             in.close();
             out.close();
             // Bug: No resource cleanup, no exception handling
         }catch ( FileNotFoundException e ){
             System.out.println("File not found");

         }catch (IOException e){
             System.out.println("File I/O Error");
         }
    }

    // Bug 9: This method should validate an email address
    public boolean validateEmail(String email) {
        try {
            return email.contains("@"); // Bug: Incomplete email validation
        }catch (NullPointerException e){
            System.out.println("Incorrect email format");
        }return false;
    }

    // Bug 10: This method should process a list of numbers
    public List<Integer> processNumbers(List<String> numbers) {
        List<Integer> result = new ArrayList<>();

            for (String num : numbers) {
                try {
                    result.add(Integer.parseInt(num));
                }catch (NumberFormatException e){
                    System.out.println("Invalid number");
                }
            }
        return result;

    } // Bug: No exception handling for invalid numbers
} 