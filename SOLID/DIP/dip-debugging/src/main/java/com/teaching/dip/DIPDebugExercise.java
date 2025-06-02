package com.teaching.dip;

import java.util.List;
import java.util.ArrayList;

public class DIPDebugExercise {
    // Bug 1: Direct dependency on concrete database implementation
    public static class UserService {
        private MySQLDatabase database = new MySQLDatabase();

        public void saveUser(String user) {
            database.save(user);
        }
    }

    public static class MySQLDatabase {
        public void save(String data) {
            System.out.println("Saving to MySQL: " + data);
        }
    }

    // Bug 2: Direct dependency on concrete logger implementation
    public static class OrderProcessor {
        private FileLogger logger = new FileLogger();

        public void processOrder(String order) {
            logger.log("Processing order: " + order);
        }
    }

    public static class FileLogger {
        public void log(String message) {
            System.out.println("Logging to file: " + message);
        }
    }

    // Bug 3: Direct dependency on concrete payment processor
    public static class ShoppingCart {
        private PayPalPaymentProcessor paymentProcessor = new PayPalPaymentProcessor();

        public void checkout(double amount) {
            paymentProcessor.processPayment(amount);
        }
    }

    public static class PayPalPaymentProcessor {
        public void processPayment(double amount) {
            System.out.println("Processing PayPal payment: " + amount);
        }
    }

    // Bug 4: Direct dependency on concrete notification service
    public static class UserManager {
        private EmailNotificationService notificationService = new EmailNotificationService();

        public void createUser(String user) {
            notificationService.sendNotification("Welcome " + user);
        }
    }

    public static class EmailNotificationService {
        public void sendNotification(String message) {
            System.out.println("Sending email: " + message);
        }
    }

    // Bug 5: Direct dependency on concrete file system
    public static class DocumentManager {
        private LocalFileSystem fileSystem = new LocalFileSystem();

        public void saveDocument(String document) {
            fileSystem.saveFile(document);
        }
    }

    public static class LocalFileSystem {
        public void saveFile(String content) {
            System.out.println("Saving to local file system: " + content);
        }
    }

    // Bug 6: Direct dependency on concrete cache implementation
    public static class ProductService {
        private RedisCache cache = new RedisCache();

        public String getProduct(String id) {
            return cache.get(id);
        }
    }

    public static class RedisCache {
        public String get(String key) {
            System.out.println("Getting from Redis: " + key);
            return "Product " + key;
        }
    }

    // Bug 7: Direct dependency on concrete message queue
    public static class OrderService {
        private RabbitMQ messageQueue = new RabbitMQ();

        public void placeOrder(String order) {
            messageQueue.publish(order);
        }
    }

    public static class RabbitMQ {
        public void publish(String message) {
            System.out.println("Publishing to RabbitMQ: " + message);
        }
    }

    // Bug 8: Direct dependency on concrete search engine
    public static class SearchService {
        private ElasticSearch searchEngine = new ElasticSearch();

        public List<String> search(String query) {
            return searchEngine.search(query);
        }
    }

    public static class ElasticSearch {
        public List<String> search(String query) {
            System.out.println("Searching in ElasticSearch: " + query);
            return new ArrayList<>();
        }
    }

    // Bug 9: Direct dependency on concrete authentication service
    public static class SecurityManager {
        private LDAPAuthentication authService = new LDAPAuthentication();

        public boolean authenticate(String user, String password) {
            return authService.authenticate(user, password);
        }
    }

    public static class LDAPAuthentication {
        public boolean authenticate(String user, String password) {
            System.out.println("Authenticating with LDAP: " + user);
            return true;
        }
    }

    // Bug 10: Direct dependency on concrete report generator
    public static class ReportService {
        private PDFReportGenerator reportGenerator = new PDFReportGenerator();

        public void generateReport(String data) {
            reportGenerator.generate(data);
        }
    }

    public static class PDFReportGenerator {
        public void generate(String data) {
            System.out.println("Generating PDF report: " + data);
        }
    }
} 