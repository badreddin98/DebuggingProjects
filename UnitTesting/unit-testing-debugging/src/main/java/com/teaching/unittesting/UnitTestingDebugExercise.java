package com.teaching.unittesting;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class UnitTestingDebugExercise {
    // Bug 1: Test with multiple assertions in one test
    public static class UserService {
        public boolean validateUser(String username, String password) {
            return username != null && !username.isEmpty() && 
                   password != null && password.length() >= 8;
        }
    }

    // Bug 2: Test with external dependencies
    public static class OrderProcessor {
        private Database database;
        
        public OrderProcessor(Database database) {
            this.database = database;
        }
        
        public void processOrder(Order order) {
            database.save(order);
            sendEmail(order.getCustomerEmail());
        }
        
        private void sendEmail(String email) {
            // External email service call
        }
    }

    // Bug 3: Test with non-deterministic behavior
    public static class RandomNumberGenerator {
        public int generateNumber() {
            return (int) (Math.random() * 100);
        }
    }

    // Bug 4: Test with shared state
    public static class Counter {
        private static int count = 0;
        
        public void increment() {
            count++;
        }
        
        public int getCount() {
            return count;
        }
    }

    // Bug 5: Test with time-dependent code
    public static class TimeBasedService {
        public boolean isBusinessHours() {
            LocalDateTime now = LocalDateTime.now();
            return now.getHour() >= 9 && now.getHour() < 17;
        }
    }

    // Bug 6: Test with too many responsibilities
    public static class UserManager {
        public void createUser(String username, String email, String password) {
            validateUser(username, email, password);
            saveToDatabase(username, email, password);
            sendWelcomeEmail(email);
            updateUserCount();
        }
        
        private void validateUser(String username, String email, String password) {
            // Validation logic
        }
        
        private void saveToDatabase(String username, String email, String password) {
            // Database operations
        }
        
        private void sendWelcomeEmail(String email) {
            // Email sending logic
        }
        
        private void updateUserCount() {
            // Update statistics
        }
    }

    // Bug 7: Test with hidden dependencies
    public static class ConfigurationManager {
        private static String configPath = "config.properties";
        
        public void setConfigPath(String path) {
            configPath = path;
        }
        
        public String getConfigPath() {
            return configPath;
        }
    }

    // Bug 8: Test with complex setup
    public static class ComplexService {
        private List<String> data;
        private Database db;
        private Cache cache;
        private Logger logger;
        
        public ComplexService() {
            data = new ArrayList<>();
            db = new Database();
            cache = new Cache();
            logger = new Logger();
        }
        
        public void processData(String input) {
            // Complex processing logic
        }
    }

    // Bug 9: Test with no assertions
    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
    }

    // Bug 10: Test with implementation details
    public static class StringFormatter {
        private List<String> words;
        
        public StringFormatter() {
            words = new ArrayList<>();
        }
        
        public void addWord(String word) {
            words.add(word);
        }
        
        public String format() {
            return String.join(" ", words);
        }
    }

    // Example of correct unit testing
    public static class BankAccount {
        private double balance;
        
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }
        
        public void deposit(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive");
            }
            balance += amount;
        }
        
        public void withdraw(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive");
            }
            if (amount > balance) {
                throw new IllegalStateException("Insufficient funds");
            }
            balance -= amount;
        }
        
        public double getBalance() {
            return balance;
        }
    }
} 