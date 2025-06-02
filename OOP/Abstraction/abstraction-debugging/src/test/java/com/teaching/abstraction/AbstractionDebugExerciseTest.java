package com.teaching.abstraction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AbstractionDebugExerciseTest {
    @Test
    public void testVehicleAbstraction() {
        // Vehicle should be abstract
        assertThrows(Exception.class, () -> new AbstractionDebugExercise.Vehicle());
    }

    @Test
    public void testDatabaseAbstraction() {
        AbstractionDebugExercise.Database db = new AbstractionDebugExercise.Database();
        // Implementation details should be hidden
        assertThrows(Exception.class, () -> db.connect());
    }

    @Test
    public void testFileHandlerAbstraction() {
        AbstractionDebugExercise.FileHandler handler = new AbstractionDebugExercise.FileHandler();
        // Mixed levels of abstraction
        assertThrows(Exception.class, () -> handler.readFile("test.txt"));
    }

    @Test
    public void testCacheAbstraction() {
        AbstractionDebugExercise.Cache cache = new AbstractionDebugExercise.Cache();
        cache.add("test");
        // Should not expose internal implementation
        List<String> items = cache.getItems();
        assertThrows(Exception.class, () -> items.add("new item"));
    }

    @Test
    public void testPaymentProcessorAbstraction() {
        AbstractionDebugExercise.PaymentProcessor processor = new AbstractionDebugExercise.PaymentProcessor();
        // Incomplete abstraction
        assertThrows(Exception.class, () -> processor.processPayment(100.0));
    }

    @Test
    public void testDataSourceAbstraction() {
        // Over-abstraction
        assertThrows(Exception.class, () -> {
            AbstractionDebugExercise.DataSource source = new AbstractionDebugExercise.DataSource() {
                @Override
                public void connect() {}
                @Override
                public void disconnect() {}
                @Override
                public void query() {}
                @Override
                public void update() {}
                @Override
                public void delete() {}
                @Override
                public void insert() {}
                @Override
                public void commit() {}
                @Override
                public void rollback() {}
            };
        });
    }

    @Test
    public void testLoggerAbstraction() {
        // Implementation in interface
        assertThrows(Exception.class, () -> {
            AbstractionDebugExercise.Logger logger = new AbstractionDebugExercise.Logger() {
                @Override
                public void log(String message) {}
                @Override
                public void error(String message) {}
                @Override
                public void warn(String message) {}
            };
            logger.formatMessage("test");
        });
    }

    @Test
    public void testShapeAbstraction() {
        // Abstract class with static methods
        assertThrows(Exception.class, () -> {
            AbstractionDebugExercise.Shape shape = new AbstractionDebugExercise.Shape() {
                @Override
                public void calculateArea() {}
            };
            AbstractionDebugExercise.Shape.getArea(shape);
        });
    }

    @Test
    public void testBankAccountAbstraction() {
        AbstractionDebugExercise.BankAccount account = new AbstractionDebugExercise.BankAccount();
        // Exposed state
        assertThrows(Exception.class, () -> {
            account.balance = 1000.0;
            account.deposit(100.0);
        });
    }

    @Test
    public void testUserManagerAbstraction() {
        AbstractionDebugExercise.UserManager manager = new AbstractionDebugExercise.UserManager();
        // Mixed responsibilities
        assertThrows(Exception.class, () -> {
            manager.createUser("test", "password");
            manager.sendWelcomeEmail("test@example.com");
        });
    }

    @Test
    public void testCorrectAbstraction() {
        AbstractionDebugExercise.Car car = new AbstractionDebugExercise.Car("Toyota", 2020);
        
        // Test abstract methods
        assertDoesNotThrow(() -> car.start());
        assertDoesNotThrow(() -> car.stop());
        assertDoesNotThrow(() -> car.accelerate());
        assertDoesNotThrow(() -> car.brake());
        
        // Test concrete methods
        assertEquals("Toyota", car.getModel());
        assertEquals(2020, car.getYear());
    }
} 