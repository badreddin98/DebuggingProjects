package com.teaching.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDebugExercise {
    // Bug 1: Missing serialVersionUID
    public static class Person implements Serializable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    // Bug 2: Non-serializable field
    public static class Student implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private Thread thread; // Non-serializable field

        public Student(String name) {
            this.name = name;
            this.thread = new Thread();
        }
    }

    // Bug 3: Incorrect custom serialization
    public static class Account implements Serializable {
        private static final long serialVersionUID = 1L;
        private String accountNumber;
        private double balance;

        public Account(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
        }
    }

    // Bug 4: Incorrect transient field handling
    public static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private transient double salary;
        private transient List<String> projects;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
            this.projects = new ArrayList<>();
        }
    }

    // Bug 5: Incorrect externalizable implementation
    public static class Product implements Externalizable {
        private String name;
        private double price;

        public Product() {
            // Required no-arg constructor
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name);
            out.writeDouble(price);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
            price = in.readDouble();
        }
    }

    // Bug 6: Incorrect serialization of static fields
    public static class Configuration implements Serializable {
        private static final long serialVersionUID = 1L;
        private static String version = "1.0";
        private String name;
        private String value;

        public Configuration(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

    // Bug 7: Incorrect handling of inherited fields
    public static class Manager extends Employee {
        private static final long serialVersionUID = 1L;
        private String department;

        public Manager(String name, double salary, String department) {
            super(name, salary);
            this.department = department;
        }
    }

    // Bug 8: Incorrect serialization of collections
    public static class Library implements Serializable {
        private static final long serialVersionUID = 1L;
        private List<Book> books;

        public Library() {
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }
    }

    public static class Book implements Serializable {
        private static final long serialVersionUID = 1L;
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    // Bug 9: Incorrect handling of circular references
    public static class Node implements Serializable {
        private static final long serialVersionUID = 1L;
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // Bug 10: Incorrect serialization of enums
    public static class Order implements Serializable {
        private static final long serialVersionUID = 1L;
        private String orderId;
        private OrderStatus status;

        public Order(String orderId, OrderStatus status) {
            this.orderId = orderId;
            this.status = status;
        }
    }

    public enum OrderStatus {
        PENDING,
        PROCESSING,
        COMPLETED,
        CANCELLED
    }
} 