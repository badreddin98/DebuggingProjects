package com.teaching.composition;

import java.util.List;
import java.util.ArrayList;

public class CompositionDebugExercise {
    // Bug 1: Inheritance instead of composition for car and engine
    public static class Car extends Engine {
        public void drive() {
            start();
            System.out.println("Car is driving");
        }
    }

    public static class Engine {
        public void start() {
            System.out.println("Engine started");
        }
    }

    // Bug 2: Inheritance instead of composition for computer and components
    public static class Computer extends CPU {
        public void process() {
            execute();
            System.out.println("Computer is processing");
        }
    }

    public static class CPU {
        public void execute() {
            System.out.println("CPU executing");
        }
    }

    // Bug 3: Inheritance instead of composition for house and room
    public static class House extends Room {
        public void live() {
            enter();
            System.out.println("Living in house");
        }
    }

    public static class Room {
        public void enter() {
            System.out.println("Entering room");
        }
    }

    // Bug 4: Inheritance instead of composition for book and page
    public static class Book extends Page {
        public void read() {
            turn();
            System.out.println("Reading book");
        }
    }

    public static class Page {
        public void turn() {
            System.out.println("Turning page");
        }
    }

    // Bug 5: Inheritance instead of composition for phone and battery
    public static class Phone extends Battery {
        public void use() {
            power();
            System.out.println("Using phone");
        }
    }

    public static class Battery {
        public void power() {
            System.out.println("Battery powering");
        }
    }

    // Bug 6: Inheritance instead of composition for student and course
    public static class Student extends Course {
        public void study() {
            attend();
            System.out.println("Student studying");
        }
    }

    public static class Course {
        public void attend() {
            System.out.println("Attending course");
        }
    }

    // Bug 7: Inheritance instead of composition for restaurant and menu
    public static class Restaurant extends Menu {
        public void serve() {
            display();
            System.out.println("Restaurant serving");
        }
    }

    public static class Menu {
        public void display() {
            System.out.println("Displaying menu");
        }
    }

    // Bug 8: Inheritance instead of composition for bank and account
    public static class Bank extends Account {
        public void operate() {
            deposit();
            System.out.println("Bank operating");
        }
    }

    public static class Account {
        public void deposit() {
            System.out.println("Depositing money");
        }
    }

    // Bug 9: Inheritance instead of composition for library and book
    public static class Library extends Book {
        public void manage() {
            read();
            System.out.println("Library managing");
        }
    }

    // Bug 10: Inheritance instead of composition for hospital and patient
    public static class Hospital extends Patient {
        public void treat() {
            diagnose();
            System.out.println("Hospital treating");
        }
    }

    public static class Patient {
        public void diagnose() {
            System.out.println("Diagnosing patient");
        }
    }

    // Example of correct composition
    public static class CarComposition {
        private final Engine engine;

        public CarComposition(Engine engine) {
            this.engine = engine;
        }

        public void drive() {
            engine.start();
            System.out.println("Car is driving");
        }
    }

    public static class ComputerComposition {
        private final CPU cpu;
        private final List<Memory> memory;
        private final List<Storage> storage;

        public ComputerComposition(CPU cpu) {
            this.cpu = cpu;
            this.memory = new ArrayList<>();
            this.storage = new ArrayList<>();
        }

        public void addMemory(Memory memory) {
            this.memory.add(memory);
        }

        public void addStorage(Storage storage) {
            this.storage.add(storage);
        }

        public void process() {
            cpu.execute();
            for (Memory m : memory) {
                m.access();
            }
            for (Storage s : storage) {
                s.store();
            }
            System.out.println("Computer is processing");
        }
    }

    public static class Memory {
        public void access() {
            System.out.println("Accessing memory");
        }
    }

    public static class Storage {
        public void store() {
            System.out.println("Storing data");
        }
    }
} 