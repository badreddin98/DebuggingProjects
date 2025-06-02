package com.teaching.encapsulation;

import java.util.ArrayList;
import java.util.List;

public class EncapsulationDebugExercise {
    // Bug 1: Public fields in BankAccount
    public static class BankAccount {
        public double balance;
        public String accountNumber;
        public String ownerName;
    }

    // Bug 2: Exposed internal list in Student
    public static class Student {
        public List<String> courses = new ArrayList<>();
        public int grade;
    }

    // Bug 3: Mutable public array in TemperatureSensor
    public static class TemperatureSensor {
        public double[] readings = new double[10];
        public String unit;
    }

    // Bug 4: Public getter returning mutable object in ShoppingCart
    public static class ShoppingCart {
        private List<String> items = new ArrayList<>();

        public List<String> getItems() {
            return items; // Returns reference to internal list
        }
    }

    // Bug 5: Public setter with no validation in Person
    public static class Person {
        private int age;
        private String name;

        public void setAge(int age) {
            this.age = age; // No validation
        }

        public void setName(String name) {
            this.name = name; // No validation
        }
    }

    // Bug 6: Exposed internal state in Rectangle
    public static class Rectangle {
        public int width;
        public int height;

        public int getArea() {
            return width * height;
        }
    }

    // Bug 7: Public static mutable field in Configuration
    public static class Configuration {
        public static String databaseUrl;
        public static String username;
        public static String password;
    }

    // Bug 8: Exposed internal array in ImageProcessor
    public static class ImageProcessor {
        public int[] pixels;
        public int width;
        public int height;
    }

    // Bug 9: Public method exposing internal implementation in Stack
    public static class Stack {
        private List<String> elements = new ArrayList<>();

        public List<String> getInternalList() {
            return elements;
        }
    }

    // Bug 10: Public fields with no invariants in Time
    public static class Time {
        public int hours;
        public int minutes;
        public int seconds;
    }

    // Example of correct encapsulation
    public static class BankAccountEncapsulated {
        private double balance;
        private String accountNumber;
        private String ownerName;

        public BankAccountEncapsulated(String accountNumber, String ownerName) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = 0.0;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getOwnerName() {
            return ownerName;
        }
    }
} 