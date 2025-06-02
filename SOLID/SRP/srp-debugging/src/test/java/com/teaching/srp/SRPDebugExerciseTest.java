package com.teaching.srp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class SRPDebugExerciseTest {
    @Test
    public void testUserManager() throws IOException {
        SRPDebugExercise.UserManager manager = new SRPDebugExercise.UserManager();
        
        // Test user data and authentication
        manager.setUserData("testUser", "password123");
        assertTrue(manager.authenticate("testUser", "password123"));
        assertFalse(manager.authenticate("testUser", "wrongPassword"));
        
        // Test login history
        String filename = "login_history.txt";
        manager.saveLoginHistoryToFile(filename);
        assertTrue(new File(filename).exists());
        new File(filename).delete();
    }

    @Test
    public void testOrderProcessor() {
        SRPDebugExercise.OrderProcessor processor = new SRPDebugExercise.OrderProcessor();
        
        // Test order processing
        processor.addItem("Item1", 10.0);
        processor.addItem("Item2", 20.0);
        
        // Test payment processing
        processor.processPayment("1234-5678", "12/25");
        
        // Test invoice generation
        processor.generateInvoice();
    }

    @Test
    public void testEmailService() {
        SRPDebugExercise.EmailService service = new SRPDebugExercise.EmailService();
        
        // Test email configuration
        service.setSmtpServer("smtp.example.com");
        service.setTemplate("Hello, {subject}!");
        
        // Test email sending
        service.sendEmail("user@example.com", "Test Subject");
    }

    @Test
    public void testFileProcessor() throws IOException {
        SRPDebugExercise.FileProcessor processor = new SRPDebugExercise.FileProcessor();
        
        // Test file operations
        processor.setFilePath("test.txt");
        processor.readFile();
        processor.processData();
        processor.writeResults("output.txt");
    }

    @Test
    public void testCustomerManager() {
        SRPDebugExercise.CustomerManager manager = new SRPDebugExercise.CustomerManager();
        
        // Test database operations
        manager.setDbConnection("jdbc:mysql://localhost:3306/test");
        manager.saveCustomer("John Doe", "john@example.com");
        
        // Test validation
        assertThrows(IllegalArgumentException.class, () -> 
            manager.validateCustomer(null, "email@example.com"));
        
        // Test welcome email
        manager.sendWelcomeEmail("john@example.com");
    }

    @Test
    public void testLogger() {
        SRPDebugExercise.Logger logger = new SRPDebugExercise.Logger();
        
        // Test logging configuration
        logger.setLogLevel("INFO");
        logger.setLogFile("app.log");
        
        // Test logging
        logger.log("Test message");
        
        // Test configuration loading
        logger.loadConfiguration("config.properties");
    }

    @Test
    public void testReportGenerator() {
        SRPDebugExercise.ReportGenerator generator = new SRPDebugExercise.ReportGenerator();
        
        // Test data analysis
        generator.addData(10.0);
        generator.addData(20.0);
        generator.addData(30.0);
        
        assertEquals(20.0, generator.calculateAverage(), 0.001);
        
        // Test report generation
        generator.generateReport("PDF");
    }

    @Test
    public void testCacheManager() {
        SRPDebugExercise.CacheManager manager = new SRPDebugExercise.CacheManager();
        
        // Test cache operations
        manager.addToCache("key1", "value1");
        assertEquals("value1", manager.getFromCache("key1"));
        
        manager.clearCache();
        assertNull(manager.getFromCache("key1"));
        
        // Test data loading
        manager.loadDataFromDatabase();
    }

    @Test
    public void testDataValidator() throws IOException {
        SRPDebugExercise.DataValidator validator = new SRPDebugExercise.DataValidator();
        
        // Test validation
        validator.setData("test data");
        assertTrue(validator.validate());
        
        // Test transformation
        assertEquals("TEST DATA", validator.transform());
        
        // Test file saving
        String filename = "output.txt";
        validator.saveToFile(filename);
        assertTrue(new File(filename).exists());
        new File(filename).delete();
    }

    @Test
    public void testNotificationService() {
        SRPDebugExercise.NotificationService service = new SRPDebugExercise.NotificationService();
        
        // Test notification
        service.sendNotification("Test notification");
        
        // Test preferences
        service.setUserPreference("email");
        service.updatePreference("sms");
    }
} 