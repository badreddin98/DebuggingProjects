package com.teaching.composition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CompositionDebugExerciseTest {
    @Test
    public void testInheritanceInsteadOfComposition() {
        // Car should use composition with Engine, not inheritance
        assertThrows(Exception.class, () -> {
            CompositionDebugExercise.Car car = new CompositionDebugExercise.Car();
            car.drive();
        });
    }

    @Test
    public void testTightCoupling() {
        CompositionDebugExercise.Order order = new CompositionDebugExercise.Order();
        // Order should not be tightly coupled to MySQLDatabase
        assertThrows(Exception.class, () -> order.save());
    }

    @Test
    public void testExposedInternalComponents() {
        CompositionDebugExercise.Computer computer = new CompositionDebugExercise.Computer();
        // Internal components should not be exposed
        assertThrows(Exception.class, () -> {
            computer.cpu.process();
            computer.memory.store();
            computer.storage.save();
        });
    }

    @Test
    public void testMissingComponentLifecycle() {
        CompositionDebugExercise.ConnectionPool pool = new CompositionDebugExercise.ConnectionPool();
        // Connection lifecycle should be managed
        assertThrows(Exception.class, () -> {
            CompositionDebugExercise.Connection conn = pool.getConnection();
            conn.connect();
        });
    }

    @Test
    public void testImproperComponentInitialization() {
        CompositionDebugExercise.Logger logger = new CompositionDebugExercise.Logger();
        // Components should be properly initialized
        assertThrows(Exception.class, () -> logger.log("test"));
    }

    @Test
    public void testCircularDependencies() {
        CompositionDebugExercise.Department dept = new CompositionDebugExercise.Department();
        CompositionDebugExercise.Employee emp = new CompositionDebugExercise.Employee();
        // Should not have circular dependencies
        assertThrows(Exception.class, () -> dept.addEmployee(emp));
    }

    @Test
    public void testMissingComponentInterface() {
        CompositionDebugExercise.PaymentProcessor processor = new CompositionDebugExercise.PaymentProcessor();
        // Should use interfaces for components
        assertThrows(Exception.class, () -> processor.processPayment("paypal", 100.0));
    }

    @Test
    public void testImproperComponentAccess() {
        CompositionDebugExercise.BankAccount account = new CompositionDebugExercise.BankAccount();
        // Should not expose internal components
        assertThrows(Exception.class, () -> {
            account.deposit(100.0);
            CompositionDebugExercise.TransactionHistory history = account.getHistory();
        });
    }

    @Test
    public void testMissingComponentValidation() {
        CompositionDebugExercise.User user = new CompositionDebugExercise.User();
        // Should validate components before use
        assertThrows(Exception.class, () -> user.sendEmail("test@example.com", "Test"));
    }

    @Test
    public void testImproperComponentComposition() {
        CompositionDebugExercise.ReportGenerator generator = new CompositionDebugExercise.ReportGenerator();
        // Should use proper composition patterns
        assertThrows(Exception.class, () -> generator.generateReport("pdf", "data"));
    }

    @Test
    public void testCorrectComposition() {
        CompositionDebugExercise.CarComposition car = new CompositionDebugExercise.CarComposition();
        
        // Test proper composition
        assertDoesNotThrow(() -> car.drive());
    }
} 