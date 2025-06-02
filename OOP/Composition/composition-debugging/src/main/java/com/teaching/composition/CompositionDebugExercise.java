package com.teaching.composition;

import java.util.List;
import java.util.ArrayList;

public class CompositionDebugExercise {
    // Bug 1: Inheritance Instead of Composition
    public static class Car extends Engine {
        public void drive() {
            start(); // Inherited method
            System.out.println("Car is driving");
        }
    }

    public static class Engine {
        public void start() {
            System.out.println("Engine starting");
        }
    }

    // Bug 2: Tight Coupling
    public static class Order {
        private MySQLDatabase database; // Direct dependency on concrete class
        
        public Order() {
            this.database = new MySQLDatabase();
        }
        
        public void save() {
            database.save(this);
        }
    }

    public static class MySQLDatabase {
        public void save(Object obj) {
            System.out.println("Saving to MySQL");
        }
    }

    // Bug 3: Exposed Internal Components
    public static class Computer {
        public CPU cpu;
        public Memory memory;
        public Storage storage;
        
        public Computer() {
            this.cpu = new CPU();
            this.memory = new Memory();
            this.storage = new Storage();
        }
    }

    public static class CPU {
        public void process() {
            System.out.println("Processing");
        }
    }

    public static class Memory {
        public void store() {
            System.out.println("Storing in memory");
        }
    }

    public static class Storage {
        public void save() {
            System.out.println("Saving to storage");
        }
    }

    // Bug 4: Missing Component Lifecycle Management
    public static class ConnectionPool {
        private List<Connection> connections = new ArrayList<>();
        
        public Connection getConnection() {
            Connection conn = new Connection();
            connections.add(conn);
            return conn;
        }
        
        // Missing method to release connections
    }

    public static class Connection {
        public void connect() {
            System.out.println("Connecting");
        }
    }

    // Bug 5: Improper Component Initialization
    public static class Logger {
        private FileWriter writer;
        
        public void log(String message) {
            if (writer == null) {
                writer = new FileWriter(); // Lazy initialization
            }
            writer.write(message);
        }
    }

    public static class FileWriter {
        public void write(String message) {
            System.out.println("Writing to file: " + message);
        }
    }

    // Bug 6: Circular Dependencies
    public static class Department {
        private List<Employee> employees = new ArrayList<>();
        
        public void addEmployee(Employee employee) {
            employees.add(employee);
            employee.setDepartment(this); // Circular reference
        }
    }

    public static class Employee {
        private Department department;
        
        public void setDepartment(Department department) {
            this.department = department;
        }
    }

    // Bug 7: Missing Component Interface
    public static class PaymentProcessor {
        private PayPalGateway paypal;
        private StripeGateway stripe;
        
        public void processPayment(String type, double amount) {
            if (type.equals("paypal")) {
                paypal.process(amount);
            } else if (type.equals("stripe")) {
                stripe.process(amount);
            }
        }
    }

    public static class PayPalGateway {
        public void process(double amount) {
            System.out.println("Processing PayPal payment");
        }
    }

    public static class StripeGateway {
        public void process(double amount) {
            System.out.println("Processing Stripe payment");
        }
    }

    // Bug 8: Improper Component Access
    public static class BankAccount {
        public double balance;
        private TransactionHistory history;
        
        public BankAccount() {
            this.history = new TransactionHistory();
        }
        
        public void deposit(double amount) {
            balance += amount;
            history.addTransaction("deposit", amount);
        }
        
        public TransactionHistory getHistory() {
            return history; // Exposing internal component
        }
    }

    public static class TransactionHistory {
        private List<String> transactions = new ArrayList<>();
        
        public void addTransaction(String type, double amount) {
            transactions.add(type + ": " + amount);
        }
    }

    // Bug 9: Missing Component Validation
    public static class User {
        private EmailService emailService;
        
        public void sendEmail(String to, String subject) {
            emailService.send(to, subject); // No validation of email service
        }
    }

    public static class EmailService {
        public void send(String to, String subject) {
            System.out.println("Sending email to: " + to);
        }
    }

    // Bug 10: Improper Component Composition
    public static class ReportGenerator {
        private PDFFormatter pdfFormatter;
        private ExcelFormatter excelFormatter;
        
        public void generateReport(String type, String data) {
            if (type.equals("pdf")) {
                pdfFormatter.format(data);
            } else if (type.equals("excel")) {
                excelFormatter.format(data);
            }
        }
    }

    public static class PDFFormatter {
        public void format(String data) {
            System.out.println("Formatting as PDF");
        }
    }

    public static class ExcelFormatter {
        public void format(String data) {
            System.out.println("Formatting as Excel");
        }
    }

    // Example of correct composition
    public static class CarComposition {
        private final Engine engine;
        private final Transmission transmission;
        private final Wheels wheels;
        
        public CarComposition() {
            this.engine = new Engine();
            this.transmission = new Transmission();
            this.wheels = new Wheels();
        }
        
        public void drive() {
            engine.start();
            transmission.shift();
            wheels.rotate();
        }
    }

    public static class Transmission {
        public void shift() {
            System.out.println("Shifting gears");
        }
    }

    public static class Wheels {
        public void rotate() {
            System.out.println("Wheels rotating");
        }
    }
} 