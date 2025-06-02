package com.teaching.lsp;

import java.util.ArrayList;
import java.util.List;

public class LSPDebugExercise {
    // Bug 1: Rectangle-Square problem
    public static class Rectangle {
        protected int width;
        protected int height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getArea() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            this.width = width;
            this.height = width;
        }

        @Override
        public void setHeight(int height) {
            this.width = height;
            this.height = height;
        }
    }

    // Bug 2: Bird-Penguin problem
    public static class Bird {
        public void fly() {
            System.out.println("Flying...");
        }
    }

    public static class Penguin extends Bird {
        @Override
        public void fly() {
            throw new UnsupportedOperationException("Penguins can't fly!");
        }
    }

    // Bug 3: Account-OverdraftAccount problem
    public static class Account {
        protected double balance;

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            balance -= amount;
        }
    }

    public static class OverdraftAccount extends Account {
        @Override
        public void withdraw(double amount) {
            balance -= amount; // No check for insufficient funds
        }
    }

    // Bug 4: File-ReadOnlyFile problem
    public static class File {
        protected String content;

        public void write(String content) {
            this.content = content;
        }

        public String read() {
            return content;
        }
    }

    public static class ReadOnlyFile extends File {
        @Override
        public void write(String content) {
            throw new UnsupportedOperationException("Cannot write to read-only file");
        }
    }

    // Bug 5: Collection-ImmutableCollection problem
    public static class Collection {
        protected List<String> items = new ArrayList<>();

        public void add(String item) {
            items.add(item);
        }

        public void remove(String item) {
            items.remove(item);
        }
    }

    public static class ImmutableCollection extends Collection {
        @Override
        public void add(String item) {
            throw new UnsupportedOperationException("Cannot modify immutable collection");
        }

        @Override
        public void remove(String item) {
            throw new UnsupportedOperationException("Cannot modify immutable collection");
        }
    }

    // Bug 6: Vehicle-ElectricCar problem
    public static class Vehicle {
        protected double fuelLevel;

        public void refuel(double amount) {
            fuelLevel += amount;
        }
    }

    public static class ElectricCar extends Vehicle {
        @Override
        public void refuel(double amount) {
            throw new UnsupportedOperationException("Electric cars don't use fuel!");
        }
    }

    // Bug 7: Stack-BoundedStack problem
    public static class Stack {
        protected List<Integer> elements = new ArrayList<>();

        public void push(Integer element) {
            elements.add(element);
        }

        public Integer pop() {
            if (elements.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return elements.remove(elements.size() - 1);
        }
    }

    public static class BoundedStack extends Stack {
        private final int maxSize;

        public BoundedStack(int maxSize) {
            this.maxSize = maxSize;
        }

        @Override
        public void push(Integer element) {
            if (elements.size() >= maxSize) {
                throw new IllegalStateException("Stack is full");
            }
            elements.add(element);
        }
    }

    // Bug 8: Logger-ConsoleLogger problem
    public static class Logger {
        public void log(String message) {
            // Base implementation
        }
    }

    public static class ConsoleLogger extends Logger {
        @Override
        public void log(String message) {
            if (message == null) {
                throw new IllegalArgumentException("Message cannot be null");
            }
            System.out.println(message);
        }
    }

    // Bug 9: Shape-Circle problem
    public static class Shape {
        protected int x, y;

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void draw() {
            // Base implementation
        }
    }

    public static class Circle extends Shape {
        private int radius;

        public void setRadius(int radius) {
            if (radius <= 0) {
                throw new IllegalArgumentException("Radius must be positive");
            }
            this.radius = radius;
        }

        @Override
        public void draw() {
            if (radius <= 0) {
                throw new IllegalStateException("Circle must have a positive radius");
            }
            // Draw circle
        }
    }

    // Bug 10: DatabaseConnection-ReadOnlyConnection problem
    public static class DatabaseConnection {
        public void connect() {
            // Connect to database
        }

        public void executeQuery(String query) {
            // Execute query
        }

        public void executeUpdate(String query) {
            // Execute update
        }
    }

    public static class ReadOnlyConnection extends DatabaseConnection {
        @Override
        public void executeUpdate(String query) {
            throw new UnsupportedOperationException("Read-only connection cannot execute updates");
        }
    }
} 