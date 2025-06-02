package com.teaching.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismDebugExercise {
    // Bug 1: Type Checking Instead of Polymorphism
    public static class ShapeProcessor {
        public String processShape(Object shape) {
            if (shape instanceof Circle) {
                return "Processing circle";
            } else if (shape instanceof Rectangle) {
                return "Processing rectangle";
            } else if (shape instanceof Triangle) {
                return "Processing triangle";
            }
            return "Unknown shape";
        }
    }

    // Bug 2: Static Method Polymorphism
    public static class MathOperations {
        public static double add(double a, double b) {
            return a + b;
        }
    }

    public static class AdvancedMath extends MathOperations {
        public static double add(double a, double b) {
            return a + b + 1; // Intended to override but doesn't work
        }
    }

    // Bug 3: Field Hiding
    public static class Parent {
        public String value = "Parent";
    }

    public static class Child extends Parent {
        public String value = "Child"; // Hides parent field
    }

    // Bug 4: Covariant Return Type Issues
    public static class Animal {
        public Object getSound() {
            return "Some sound";
        }
    }

    public static class Dog extends Animal {
        @Override
        public String getSound() {
            return "Woof";
        }
    }

    // Bug 5: Method Overloading Confusion
    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public double add(double a, double b) {
            return a + b;
        }

        public String add(String a, String b) {
            return a + b;
        }
    }

    // Bug 6: Interface Implementation Issues
    public interface Drawable {
        void draw();
    }

    public static class Circle implements Drawable {
        public void draw() {
            System.out.println("Drawing circle");
        }
    }

    public static class Rectangle implements Drawable {
        // Missing draw() implementation
    }

    // Bug 7: Polymorphic Method Parameters
    public static class DataProcessor {
        public void process(List<Object> data) {
            // Process data
        }
    }

    public static class StringProcessor extends DataProcessor {
        @Override
        public void process(List<Object> data) {
            // Can't process List<String> specifically
        }
    }

    // Bug 8: Constructor Chaining
    public static class Base {
        protected int value;

        public Base(int value) {
            this.value = value;
        }
    }

    public static class Derived extends Base {
        public Derived() {
            // Missing super() call
        }
    }

    // Bug 9: Method Overriding with Different Access
    public static class ParentClass {
        protected void doSomething() {
            System.out.println("Parent doing something");
        }
    }

    public static class ChildClass extends ParentClass {
        private void doSomething() { // Can't reduce visibility
            System.out.println("Child doing something");
        }
    }

    // Bug 10: Polymorphic Collection Issues
    public static class AnimalList {
        private List<Animal> animals = new ArrayList<>();

        public void addAnimal(Animal animal) {
            animals.add(animal);
        }

        public List<Animal> getAnimals() {
            return animals;
        }
    }

    // Example of correct polymorphism
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

    public static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(String color, double width, double height) {
            super(color);
            this.width = width;
            this.height = height;
        }

        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + height);
        }
    }
} 