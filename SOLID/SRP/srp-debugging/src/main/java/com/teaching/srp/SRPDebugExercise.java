package com.teaching.srp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SRPDebugExercise {
    // Bug 1: Class handling both user data and authentication
    public static class UserManager {
        private String username;
        private String password;
        private List<String> loginHistory = new ArrayList<>();

        public void setUserData(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean authenticate(String username, String password) {
            boolean isAuthenticated = this.username.equals(username) && this.password.equals(password);
            if (isAuthenticated) {
                loginHistory.add(LocalDateTime.now().toString());
            }
            return isAuthenticated;
        }

        public void saveLoginHistoryToFile(String filename) throws IOException {
            try (FileWriter writer = new FileWriter(filename)) {
                for (String login : loginHistory) {
                    writer.write(login + "\n");
                }
            }
        }
    }

    // Bug 2: Class handling both order processing and payment
    public static class OrderProcessor {
        private List<String> orderItems = new ArrayList<>();
        private double totalAmount;

        public void addItem(String item, double price) {
            orderItems.add(item);
            totalAmount += price;
        }

        public void processPayment(String cardNumber, String expiryDate) {
            // Process payment logic
            System.out.println("Processing payment for card: " + cardNumber);
        }

        public void generateInvoice() {
            System.out.println("Generating invoice for items: " + orderItems);
            System.out.println("Total amount: " + totalAmount);
        }
    }

    // Bug 3: Class handling both email sending and template management
    public static class EmailService {
        private String smtpServer;
        private String template;

        public void setSmtpServer(String smtpServer) {
            this.smtpServer = smtpServer;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public void sendEmail(String to, String subject) {
            String content = template.replace("{subject}", subject);
            System.out.println("Sending email to " + to + " using server " + smtpServer);
            System.out.println("Content: " + content);
        }
    }

    // Bug 4: Class handling both file operations and data processing
    public static class FileProcessor {
        private String filePath;
        private List<String> data = new ArrayList<>();

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public void readFile() throws IOException {
            // Read file logic
            System.out.println("Reading file: " + filePath);
        }

        public void processData() {
            for (String line : data) {
                // Process each line
                System.out.println("Processing: " + line);
            }
        }

        public void writeResults(String outputPath) throws IOException {
            // Write results logic
            System.out.println("Writing results to: " + outputPath);
        }
    }

    // Bug 5: Class handling both database operations and business logic
    public static class CustomerManager {
        private String dbConnection;

        public void setDbConnection(String connection) {
            this.dbConnection = connection;
        }

        public void saveCustomer(String name, String email) {
            // Save to database
            System.out.println("Saving customer to database: " + name);
        }

        public void validateCustomer(String name, String email) {
            // Business validation
            if (name == null || email == null) {
                throw new IllegalArgumentException("Name and email are required");
            }
        }

        public void sendWelcomeEmail(String email) {
            // Send welcome email
            System.out.println("Sending welcome email to: " + email);
        }
    }

    // Bug 6: Class handling both logging and configuration
    public static class Logger {
        private String logLevel;
        private String logFile;

        public void setLogLevel(String level) {
            this.logLevel = level;
        }

        public void setLogFile(String file) {
            this.logFile = file;
        }

        public void log(String message) {
            System.out.println("[" + logLevel + "] " + message);
        }

        public void loadConfiguration(String configFile) {
            // Load configuration
            System.out.println("Loading configuration from: " + configFile);
        }
    }

    // Bug 7: Class handling both report generation and data analysis
    public static class ReportGenerator {
        private List<Double> data = new ArrayList<>();

        public void addData(double value) {
            data.add(value);
        }

        public double calculateAverage() {
            return data.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        }

        public void generateReport(String format) {
            double avg = calculateAverage();
            System.out.println("Generating " + format + " report with average: " + avg);
        }
    }

    // Bug 8: Class handling both cache management and data retrieval
    public static class CacheManager {
        private List<String> cache = new ArrayList<>();

        public void addToCache(String key, String value) {
            cache.add(key + ":" + value);
        }

        public String getFromCache(String key) {
            return cache.stream()
                    .filter(entry -> entry.startsWith(key + ":"))
                    .findFirst()
                    .map(entry -> entry.split(":")[1])
                    .orElse(null);
        }

        public void clearCache() {
            cache.clear();
        }

        public void loadDataFromDatabase() {
            // Load data from database
            System.out.println("Loading data from database");
        }
    }

    // Bug 9: Class handling both validation and data transformation
    public static class DataValidator {
        private String data;

        public void setData(String data) {
            this.data = data;
        }

        public boolean validate() {
            return data != null && !data.isEmpty();
        }

        public String transform() {
            return data.toUpperCase();
        }

        public void saveToFile(String filename) throws IOException {
            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(transform());
            }
        }
    }

    // Bug 10: Class handling both notification and user preferences
    public static class NotificationService {
        private List<String> notifications = new ArrayList<>();
        private String userPreference;

        public void setUserPreference(String preference) {
            this.userPreference = preference;
        }

        public void sendNotification(String message) {
            notifications.add(message);
            System.out.println("Sending notification: " + message);
        }

        public void updatePreference(String newPreference) {
            this.userPreference = newPreference;
            System.out.println("Updated preference to: " + newPreference);
        }
    }
} 