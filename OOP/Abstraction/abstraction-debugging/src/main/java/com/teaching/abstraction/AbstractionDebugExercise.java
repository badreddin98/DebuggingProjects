package com.teaching.abstraction;

import java.util.List;
import java.util.ArrayList;

public class AbstractionDebugExercise {
    // Bug 1: Concrete Class Instead of Abstract
    public static class Vehicle {
        public void start() {
            System.out.println("Starting vehicle");
        }
        
        public void stop() {
            System.out.println("Stopping vehicle");
        }
    }

    // Bug 2: Exposed Implementation Details
    public static class Database {
        private String connectionString;
        private String username;
        private String password;
        
        public void connect() {
            System.out.println("Connecting to database with: " + connectionString);
            System.out.println("Using credentials: " + username + "/" + password);
        }
    }

    // Bug 3: Mixed Levels of Abstraction
    public static class FileHandler {
        public void readFile(String path) {
            System.out.println("Reading file from: " + path);
        }
        
        public void writeFile(String path, String content) {
            System.out.println("Writing to file: " + path);
        }
        
        public void createDirectory(String path) {
            System.out.println("Creating directory: " + path);
        }
        
        public void deleteFile(String path) {
            System.out.println("Deleting file: " + path);
        }
    }

    // Bug 4: Leaky Abstraction
    public static class Cache {
        private List<String> items = new ArrayList<>();
        
        public void add(String item) {
            items.add(item);
        }
        
        public List<String> getItems() {
            return items; // Exposing internal implementation
        }
    }

    // Bug 5: Incomplete Abstraction
    public static class PaymentProcessor {
        public void processPayment(double amount) {
            System.out.println("Processing payment of: " + amount);
        }
        
        // Missing refund method
    }

    // Bug 6: Over-Abstraction
    public static abstract class DataSource {
        public abstract void connect();
        public abstract void disconnect();
        public abstract void query();
        public abstract void update();
        public abstract void delete();
        public abstract void insert();
        public abstract void commit();
        public abstract void rollback();
    }

    // Bug 7: Implementation in Interface
    public interface Logger {
        void log(String message);
        void error(String message);
        void warn(String message);
        
        default void formatMessage(String message) {
            // Implementation in interface
            System.out.println("[" + System.currentTimeMillis() + "] " + message);
        }
    }

    // Bug 8: Abstract Class with Static Methods
    public static abstract class Shape {
        protected double area;
        
        public abstract void calculateArea();
        
        public static double getArea(Shape shape) {
            return shape.area;
        }
    }

    // Bug 9: Exposed State
    public static class BankAccount {
        public double balance;
        public String accountNumber;
        public String ownerName;
        
        public void deposit(double amount) {
            balance += amount;
        }
        
        public void withdraw(double amount) {
            balance -= amount;
        }
    }

    // Bug 10: Mixed Responsibilities
    public static class UserManager {
        public void createUser(String username, String password) {
            System.out.println("Creating user: " + username);
        }
        
        public void sendWelcomeEmail(String email) {
            System.out.println("Sending welcome email to: " + email);
        }
        
        public void updateUserProfile(String username) {
            System.out.println("Updating profile for: " + username);
        }
    }

    // Example of correct abstraction
    public static abstract class AbstractVehicle {
        protected String model;
        protected int year;
        
        public AbstractVehicle(String model, int year) {
            this.model = model;
            this.year = year;
        }
        
        public abstract void start();
        public abstract void stop();
        public abstract void accelerate();
        public abstract void brake();
        
        public String getModel() {
            return model;
        }
        
        public int getYear() {
            return year;
        }
    }
    
    public static class Car extends AbstractVehicle {
        public Car(String model, int year) {
            super(model, year);
        }
        
        @Override
        public void start() {
            System.out.println("Starting car engine");
        }
        
        @Override
        public void stop() {
            System.out.println("Stopping car engine");
        }
        
        @Override
        public void accelerate() {
            System.out.println("Car accelerating");
        }
        
        @Override
        public void brake() {
            System.out.println("Car braking");
        }
    }
} 