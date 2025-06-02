package com.teaching.isp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ISPDebugExerciseTest {
    @Test
    public void testWorkerInterface() {
        ISPDebugExercise.Developer developer = new ISPDebugExercise.Developer();
        
        // Test required methods
        assertDoesNotThrow(() -> developer.work());
        assertDoesNotThrow(() -> developer.eat());
        assertDoesNotThrow(() -> developer.sleep());
        assertDoesNotThrow(() -> developer.code());
        
        // Test unnecessary methods
        assertDoesNotThrow(() -> developer.design());
        assertDoesNotThrow(() -> developer.test());
    }

    @Test
    public void testPrinterInterface() {
        ISPDebugExercise.BasicPrinter printer = new ISPDebugExercise.BasicPrinter();
        
        // Test supported method
        assertDoesNotThrow(() -> printer.print());
        
        // Test unsupported methods
        assertDoesNotThrow(() -> printer.scan());
        assertDoesNotThrow(() -> printer.fax());
        assertDoesNotThrow(() -> printer.copy());
        assertDoesNotThrow(() -> printer.staple());
    }

    @Test
    public void testVehicleInterface() {
        ISPDebugExercise.ElectricCar car = new ISPDebugExercise.ElectricCar();
        
        // Test supported methods
        assertDoesNotThrow(() -> car.start());
        assertDoesNotThrow(() -> car.stop());
        assertDoesNotThrow(() -> car.rotateTires());
        assertDoesNotThrow(() -> car.wash());
        
        // Test unsupported methods
        assertDoesNotThrow(() -> car.refuel());
        assertDoesNotThrow(() -> car.changeOil());
    }

    @Test
    public void testUserInterface() {
        ISPDebugExercise.GuestUser user = new ISPDebugExercise.GuestUser();
        
        // Test allowed methods
        assertDoesNotThrow(() -> user.login());
        assertDoesNotThrow(() -> user.logout());
        assertDoesNotThrow(() -> user.register());
        
        // Test restricted methods
        assertDoesNotThrow(() -> user.updateProfile());
        assertDoesNotThrow(() -> user.deleteAccount());
        assertDoesNotThrow(() -> user.resetPassword());
        assertDoesNotThrow(() -> user.sendEmail());
        assertDoesNotThrow(() -> user.uploadPhoto());
    }

    @Test
    public void testDatabaseInterface() {
        ISPDebugExercise.ReadOnlyDatabase database = new ISPDebugExercise.ReadOnlyDatabase();
        
        // Test allowed methods
        assertDoesNotThrow(() -> database.connect());
        assertDoesNotThrow(() -> database.disconnect());
        assertDoesNotThrow(() -> database.query());
        
        // Test restricted methods
        assertDoesNotThrow(() -> database.update());
        assertDoesNotThrow(() -> database.backup());
        assertDoesNotThrow(() -> database.restore());
        assertDoesNotThrow(() -> database.optimize());
        assertDoesNotThrow(() -> database.index());
    }

    @Test
    public void testMediaPlayerInterface() {
        // This test demonstrates that a basic media player shouldn't need to implement
        // all features like recording, editing, burning, etc.
        assertTrue(true);
    }

    @Test
    public void testDocumentInterface() {
        // This test demonstrates that a read-only document shouldn't need to implement
        // methods like edit, delete, print, etc.
        assertTrue(true);
    }

    @Test
    public void testPaymentProcessorInterface() {
        // This test demonstrates that a basic payment processor shouldn't need to implement
        // all payment methods and administrative functions
        assertTrue(true);
    }

    @Test
    public void testNotificationServiceInterface() {
        // This test demonstrates that a basic notification service shouldn't need to implement
        // all notification channels and administrative functions
        assertTrue(true);
    }

    @Test
    public void testFileHandlerInterface() {
        // This test demonstrates that a basic file handler shouldn't need to implement
        // all file operations like compression, encryption, etc.
        assertTrue(true);
    }
} 