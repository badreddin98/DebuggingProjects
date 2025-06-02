package com.teaching.sealed;

public class SealedClassesDebugExercise {
    // Bug 1: Incorrect sealed class declaration
    public sealed class Shape {
        public final class Circle extends Shape {
            private final double radius;
            public Circle(double radius) { this.radius = radius; }
            public double getArea() { return Math.PI * radius * radius; }
        }
    }

    // Bug 2: Incorrect permits clause
    public sealed class Vehicle permits Car, Truck {
        protected String brand;
        public Vehicle(String brand) { this.brand = brand; }
    }
    public final class Car extends Vehicle {
        public Car(String brand) { super(brand); }
    }
    public final class Truck extends Vehicle {
        public Truck(String brand) { super(brand); }
    }

    // Bug 3: Incorrect non-sealed class
    public sealed class Expression {
        public non-sealed class Constant extends Expression {
            private final int value;
            public Constant(int value) { this.value = value; }
        }
    }

    // Bug 4: Incorrect sealed interface
    public sealed interface Operation {
        public final class Add implements Operation {
            public int execute(int a, int b) { return a + b; }
        }
        public final class Subtract implements Operation {
            public int execute(int a, int b) { return a - b; }
        }
    }

    // Bug 5: Incorrect sealed class with abstract methods
    public sealed abstract class Animal {
        public final class Dog extends Animal {
            public void makeSound() { System.out.println("Woof!"); }
        }
        public final class Cat extends Animal {
            public void makeSound() { System.out.println("Meow!"); }
        }
    }

    // Bug 6: Incorrect sealed class with generics
    public sealed class Container<T> {
        public final class Box<T> extends Container<T> {
            private T value;
            public Box(T value) { this.value = value; }
        }
    }

    // Bug 7: Incorrect sealed class with nested classes
    public sealed class Outer {
        public final class Inner extends Outer {
            public void doSomething() {}
        }
    }

    // Bug 8: Incorrect sealed class with static members
    public sealed class Utility {
        public static final class Helper extends Utility {
            public static void help() {}
        }
    }

    // Bug 9: Incorrect sealed class with interfaces
    public sealed class Service {
        public final class Implementation extends Service implements Runnable {
            public void run() {}
        }
    }

    // Bug 10: Incorrect sealed class with annotations
    @Deprecated
    public sealed class Legacy {
        public final class Modern extends Legacy {
            public void modernize() {}
        }
    }
} 