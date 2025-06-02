package com.teaching.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class DesignPatternsDebugExercise {
    // Bug 1: Singleton anti-pattern - not thread-safe
    public static class DatabaseConnection {
        private static DatabaseConnection instance;
        
        private DatabaseConnection() {}
        
        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }
    }

    // Bug 2: Factory anti-pattern - violates Open/Closed Principle
    public sealed class Vehicle permits Car, Truck, Motorcycle {}
    public final class Car extends Vehicle {}
    public final class Truck extends Vehicle {}
    public final class Motorcycle extends Vehicle {}

    public static class VehicleFactory {
        public Vehicle createVehicle(String type) {
            return switch (type) {
                case "car" -> new Car();
                case "truck" -> new Truck();
                case "motorcycle" -> new Motorcycle();
                default -> null;
            };
        }
    }

    // Bug 3: Observer anti-pattern - tight coupling
    public static class WeatherStation {
        private List<WeatherDisplay> displays = new ArrayList<>();
        
        public void addDisplay(WeatherDisplay display) {
            displays.add(display);
        }
        
        public void updateWeather(String weather) {
            for (WeatherDisplay display : displays) {
                display.update(weather);
            }
        }
    }

    // Bug 4: Strategy anti-pattern - no abstraction
    public static class PaymentProcessor {
        public void processPayment(String type, double amount) {
            switch (type) {
                case "credit" -> processCreditCard(amount);
                case "paypal" -> processPayPal(amount);
                case "bitcoin" -> processBitcoin(amount);
            }
        }
        
        private void processCreditCard(double amount) {
            // Credit card processing logic
        }
        
        private void processPayPal(double amount) {
            // PayPal processing logic
        }
        
        private void processBitcoin(double amount) {
            // Bitcoin processing logic
        }
    }

    // Bug 5: Decorator anti-pattern - inheritance instead of composition
    public static class BasicCoffee {
        public String getDescription() {
            return "Basic Coffee";
        }
        
        public double getCost() {
            return 1.0;
        }
    }
    
    public static class MilkCoffee extends BasicCoffee {
        @Override
        public String getDescription() {
            return super.getDescription() + " with Milk";
        }
        
        @Override
        public double getCost() {
            return super.getCost() + 0.5;
        }
    }

    // Bug 6: Command anti-pattern - no undo functionality
    public static class LightSwitch {
        public void turnOn() {
            // Turn on logic
        }
        
        public void turnOff() {
            // Turn off logic
        }
    }

    // Bug 7: Adapter anti-pattern - violates Single Responsibility Principle
    public static class LegacySystem {
        public void processData(String data) {
            // Legacy processing logic
        }
    }
    
    public static class ModernSystem {
        public void processData(String data) {
            LegacySystem legacy = new LegacySystem();
            legacy.processData(data);
            // Additional modern processing
        }
    }

    // Bug 8: Template Method anti-pattern - no hooks
    public static class DataProcessor {
        public void process() {
            readData();
            transformData();
            saveData();
        }
        
        protected void readData() {
            // Default implementation
        }
        
        protected void transformData() {
            // Default implementation
        }
        
        protected void saveData() {
            // Default implementation
        }
    }

    // Bug 9: Builder anti-pattern - no validation
    public record User(String name, int age, String email) {}
    
    public static class UserBuilder {
        private String name;
        private int age;
        private String email;
        
        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }
        
        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        
        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
        
        public User build() {
            return new User(name, age, email);
        }
    }

    // Bug 10: Chain of Responsibility anti-pattern - no fallback
    public record Request(String data) {}
    
    public static class RequestHandler {
        private RequestHandler next;
        
        public void setNext(RequestHandler next) {
            this.next = next;
        }
        
        public void handle(Request request) {
            if (canHandle(request)) {
                process(request);
            } else if (next != null) {
                next.handle(request);
            }
        }
        
        protected boolean canHandle(Request request) {
            return false;
        }
        
        protected void process(Request request) {
            // Default implementation
        }
    }

    // Example of correct design pattern implementation
    public static class ThreadSafeSingleton {
        private static volatile ThreadSafeSingleton instance;
        
        private ThreadSafeSingleton() {}
        
        public static ThreadSafeSingleton getInstance() {
            if (instance == null) {
                synchronized (ThreadSafeSingleton.class) {
                    if (instance == null) {
                        instance = new ThreadSafeSingleton();
                    }
                }
            }
            return instance;
        }
    }
}

// Supporting interfaces
interface WeatherDisplay {
    void update(String weather);
} 