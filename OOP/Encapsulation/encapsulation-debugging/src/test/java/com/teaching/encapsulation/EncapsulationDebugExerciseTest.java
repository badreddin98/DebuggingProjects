package com.teaching.encapsulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class EncapsulationDebugExerciseTest {
    @Test
    public void testBankAccount() {
        EncapsulationDebugExercise.BankAccount account = new EncapsulationDebugExercise.BankAccount();
        account.balance = -1000; // Direct access to balance
        account.accountNumber = null; // Direct access to accountNumber
        assertEquals(-1000, account.balance);
    }

    @Test
    public void testStudent() {
        EncapsulationDebugExercise.Student student = new EncapsulationDebugExercise.Student();
        student.courses.add("Math"); // Direct access to courses list
        student.grade = 150; // Direct access to grade
        assertTrue(student.courses.contains("Math"));
        assertEquals(150, student.grade);
    }

    @Test
    public void testTemperatureSensor() {
        EncapsulationDebugExercise.TemperatureSensor sensor = new EncapsulationDebugExercise.TemperatureSensor();
        sensor.readings[0] = -1000; // Direct access to readings array
        sensor.unit = null; // Direct access to unit
        assertEquals(-1000, sensor.readings[0]);
    }

    @Test
    public void testShoppingCart() {
        EncapsulationDebugExercise.ShoppingCart cart = new EncapsulationDebugExercise.ShoppingCart();
        List<String> items = cart.getItems();
        items.add("Item"); // Modifying internal list through reference
        assertTrue(cart.getItems().contains("Item"));
    }

    @Test
    public void testPerson() {
        EncapsulationDebugExercise.Person person = new EncapsulationDebugExercise.Person();
        person.setAge(-10); // No validation
        person.setName(null); // No validation
        // No assertions as we can't access the fields directly
    }

    @Test
    public void testRectangle() {
        EncapsulationDebugExercise.Rectangle rect = new EncapsulationDebugExercise.Rectangle();
        rect.width = -5; // Direct access to width
        rect.height = -10; // Direct access to height
        assertEquals(50, rect.getArea()); // Incorrect area calculation
    }

    @Test
    public void testConfiguration() {
        EncapsulationDebugExercise.Configuration.databaseUrl = null;
        EncapsulationDebugExercise.Configuration.username = null;
        EncapsulationDebugExercise.Configuration.password = null;
        // No assertions as these are static fields
    }

    @Test
    public void testImageProcessor() {
        EncapsulationDebugExercise.ImageProcessor processor = new EncapsulationDebugExercise.ImageProcessor();
        processor.pixels = null; // Direct access to pixels
        processor.width = -1; // Direct access to width
        processor.height = -1; // Direct access to height
        // No assertions as we can't validate the state
    }

    @Test
    public void testStack() {
        EncapsulationDebugExercise.Stack stack = new EncapsulationDebugExercise.Stack();
        List<String> elements = stack.getInternalList();
        elements.add("Element"); // Modifying internal list through reference
        assertTrue(stack.getInternalList().contains("Element"));
    }

    @Test
    public void testTime() {
        EncapsulationDebugExercise.Time time = new EncapsulationDebugExercise.Time();
        time.hours = 25; // Direct access to hours
        time.minutes = 61; // Direct access to minutes
        time.seconds = 61; // Direct access to seconds
        // No assertions as we can't validate the time
    }

    @Test
    public void testBankAccountEncapsulated() {
        EncapsulationDebugExercise.BankAccountEncapsulated account = 
            new EncapsulationDebugExercise.BankAccountEncapsulated("123", "John");
        
        // Test deposit
        account.deposit(100);
        assertEquals(100, account.getBalance());
        
        // Test invalid deposit
        account.deposit(-50);
        assertEquals(100, account.getBalance());
        
        // Test withdraw
        assertTrue(account.withdraw(50));
        assertEquals(50, account.getBalance());
        
        // Test invalid withdraw
        assertFalse(account.withdraw(100));
        assertEquals(50, account.getBalance());
        
        // Test getters
        assertEquals("123", account.getAccountNumber());
        assertEquals("John", account.getOwnerName());
    }
} 