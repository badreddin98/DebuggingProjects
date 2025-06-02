package com.teaching.ocp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class OCPDebugExerciseTest {
    @Test
    public void testShapeCalculator() {
        OCPDebugExercise.ShapeCalculator calculator = new OCPDebugExercise.ShapeCalculator();
        
        // Test circle
        assertEquals(Math.PI * 4, calculator.calculateArea("circle", 2.0), 0.001);
        
        // Test rectangle
        assertEquals(6.0, calculator.calculateArea("rectangle", 2.0, 3.0), 0.001);
        
        // Test triangle
        assertEquals(3.0, calculator.calculateArea("triangle", 2.0, 3.0), 0.001);
        
        // Test unknown shape
        assertThrows(IllegalArgumentException.class, () -> 
            calculator.calculateArea("hexagon", 2.0));
    }

    @Test
    public void testPaymentProcessor() {
        OCPDebugExercise.PaymentProcessor processor = new OCPDebugExercise.PaymentProcessor();
        
        // Test credit card payment
        processor.processPayment("credit_card", 100.0);
        
        // Test PayPal payment
        processor.processPayment("paypal", 200.0);
        
        // Test bank transfer
        processor.processPayment("bank_transfer", 300.0);
        
        // Test unsupported payment method
        assertThrows(IllegalArgumentException.class, () -> 
            processor.processPayment("bitcoin", 100.0));
    }

    @Test
    public void testReportGenerator() {
        OCPDebugExercise.ReportGenerator generator = new OCPDebugExercise.ReportGenerator();
        
        // Test PDF report
        generator.generateReport("pdf", "Test data");
        
        // Test Excel report
        generator.generateReport("excel", "Test data");
        
        // Test CSV report
        generator.generateReport("csv", "Test data");
        
        // Test unsupported format
        assertThrows(IllegalArgumentException.class, () -> 
            generator.generateReport("docx", "Test data"));
    }

    @Test
    public void testNotificationService() {
        OCPDebugExercise.NotificationService service = new OCPDebugExercise.NotificationService();
        
        // Test email notification
        service.sendNotification("email", "Test message");
        
        // Test SMS notification
        service.sendNotification("sms", "Test message");
        
        // Test push notification
        service.sendNotification("push", "Test message");
        
        // Test unsupported channel
        assertThrows(IllegalArgumentException.class, () -> 
            service.sendNotification("fax", "Test message"));
    }

    @Test
    public void testDiscountCalculator() {
        OCPDebugExercise.DiscountCalculator calculator = new OCPDebugExercise.DiscountCalculator();
        
        // Test percentage discount
        assertEquals(10.0, calculator.calculateDiscount("percentage", 100.0), 0.001);
        
        // Test fixed discount
        assertEquals(50.0, calculator.calculateDiscount("fixed", 100.0), 0.001);
        
        // Test seasonal discount
        assertEquals(20.0, calculator.calculateDiscount("seasonal", 100.0), 0.001);
        
        // Test unsupported discount type
        assertThrows(IllegalArgumentException.class, () -> 
            calculator.calculateDiscount("holiday", 100.0));
    }

    @Test
    public void testDataExporter() {
        OCPDebugExercise.DataExporter exporter = new OCPDebugExercise.DataExporter();
        List<String> data = Arrays.asList("item1", "item2", "item3");
        
        // Test JSON export
        exporter.exportData("json", data);
        
        // Test XML export
        exporter.exportData("xml", data);
        
        // Test YAML export
        exporter.exportData("yaml", data);
        
        // Test unsupported format
        assertThrows(IllegalArgumentException.class, () -> 
            exporter.exportData("txt", data));
    }

    @Test
    public void testLogFormatter() {
        OCPDebugExercise.LogFormatter formatter = new OCPDebugExercise.LogFormatter();
        
        // Test info level
        assertEquals("[INFO] Test message", formatter.formatLog("info", "Test message"));
        
        // Test error level
        assertEquals("[ERROR] Test message", formatter.formatLog("error", "Test message"));
        
        // Test debug level
        assertEquals("[DEBUG] Test message", formatter.formatLog("debug", "Test message"));
        
        // Test unsupported level
        assertThrows(IllegalArgumentException.class, () -> 
            formatter.formatLog("warning", "Test message"));
    }

    @Test
    public void testDataValidator() {
        OCPDebugExercise.DataValidator validator = new OCPDebugExercise.DataValidator();
        
        // Test email validation
        assertTrue(validator.validate("email", "test@example.com"));
        assertFalse(validator.validate("email", "invalid-email"));
        
        // Test phone validation
        assertTrue(validator.validate("phone", "1234567890"));
        assertFalse(validator.validate("phone", "123-456-7890"));
        
        // Test zipcode validation
        assertTrue(validator.validate("zipcode", "12345"));
        assertFalse(validator.validate("zipcode", "1234"));
        
        // Test unsupported validation type
        assertThrows(IllegalArgumentException.class, () -> 
            validator.validate("ssn", "123-45-6789"));
    }

    @Test
    public void testFileCompressor() {
        OCPDebugExercise.FileCompressor compressor = new OCPDebugExercise.FileCompressor();
        
        // Test ZIP compression
        compressor.compressFile("zip", "test.txt");
        
        // Test RAR compression
        compressor.compressFile("rar", "test.txt");
        
        // Test 7Z compression
        compressor.compressFile("7z", "test.txt");
        
        // Test unsupported compression type
        assertThrows(IllegalArgumentException.class, () -> 
            compressor.compressFile("tar", "test.txt"));
    }

    @Test
    public void testDataTransformer() {
        OCPDebugExercise.DataTransformer transformer = new OCPDebugExercise.DataTransformer();
        
        // Test uppercase transformation
        assertEquals("TEST", transformer.transform("uppercase", "test"));
        
        // Test lowercase transformation
        assertEquals("test", transformer.transform("lowercase", "TEST"));
        
        // Test capitalize transformation
        assertEquals("Test", transformer.transform("capitalize", "test"));
        
        // Test unsupported transformation type
        assertThrows(IllegalArgumentException.class, () -> 
            transformer.transform("reverse", "test"));
    }
} 