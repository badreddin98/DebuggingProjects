package com.teaching.inheritance;

import java.util.ArrayList;
import java.util.List;

public class InheritanceDebugExercise {
    // Bug 1: Breaking Liskov Substitution Principle
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

    // Bug 2: Fragile Base Class Problem
    public static class List {
        protected ArrayList<String> items = new ArrayList<>();
        
        public void add(String item) {
            items.add(item);
        }
    }

    public static class CountingList extends List {
        private int count = 0;
        
        @Override
        public void add(String item) {
            super.add(item);
            count++;
        }
        
        public int getCount() {
            return count;
        }
    }

    // Bug 3: Diamond Problem
    public static class Animal {
        public void makeSound() {
            System.out.println("Some sound");
        }
    }

    public static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Woof!");
        }
    }

    public static class Robot extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Beep!");
        }
    }

    public static class RobotDog extends Dog, Robot { // This won't compile, but demonstrates the problem
    }

    // Bug 4: Inheritance for Code Reuse
    public static class Stack {
        private ArrayList<String> elements = new ArrayList<>();
        
        public void push(String element) {
            elements.add(element);
        }
        
        public String pop() {
            return elements.remove(elements.size() - 1);
        }
    }

    public static class StringList extends Stack { // Misusing inheritance for code reuse
        public void add(String element) {
            push(element);
        }
    }

    // Bug 5: Tight Coupling
    public static class Base {
        protected int value;
        
        public void setValue(int value) {
            this.value = value;
        }
    }

    public static class Derived extends Base {
        public void setValue(int value) {
            if (value < 0) {
                throw new IllegalArgumentException("Value must be positive");
            }
            super.setValue(value);
        }
    }

    // Bug 6: Inheritance of Implementation
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

    // Bug 7: Inheritance of Constants
    public static class Constants {
        public static final double PI = 3.14159;
        public static final double E = 2.71828;
    }

    public static class MathConstants extends Constants {
        public static final double PI = 3.14; // Hiding parent constant
    }

    // Bug 8: Inheritance of Static Methods
    public static class Parent {
        public static void print() {
            System.out.println("Parent");
        }
    }

    public static class Child extends Parent {
        public static void print() {
            System.out.println("Child");
        }
    }

    // Bug 9: Inheritance of Final Methods
    public static class Vehicle {
        public final void start() {
            System.out.println("Starting vehicle...");
        }
    }

    public static class Car extends Vehicle {
        public void start() { // Can't override final method
            System.out.println("Starting car...");
        }
    }

    // Bug 10: Inheritance of Private Methods
    public static class ParentClass {
        private void privateMethod() {
            System.out.println("Parent private method");
        }
        
        public void callPrivateMethod() {
            privateMethod();
        }
    }

    public static class ChildClass extends ParentClass {
        private void privateMethod() { // Not actually overriding
            System.out.println("Child private method");
        }
    }

    // Example of correct inheritance
    public static abstract class Shape {
        protected String color;
        
        public Shape(String color) {
            this.color = color;
        }
        
        public abstract double getArea();
        public abstract double getPerimeter();
    }

    public static class Circle extends Shape {
        private double radius;
        
        public Circle(String color, double radius) {
            super(color);
            this.radius = radius;
        }
        
        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
        
        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }
} 