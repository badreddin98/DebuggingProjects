package com.teaching.datatypes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class DataTypesDebugExerciseTest {
    @Test
    public void testNumberOperations() {
        DataTypesDebugExercise.NumberOperations ops = new DataTypesDebugExercise.NumberOperations();
        
        // Test division
        assertEquals(2.5, ops.divide(5, 2), 0.001);
        assertEquals(0.0, ops.divide(0, 5), 0.001);
        
        // Test factorial
        assertEquals(120, ops.calculateFactorial(5));
        assertEquals(1, ops.calculateFactorial(0));
    }

    @Test
    public void testFloatingPointComparison() {
        DataTypesDebugExercise.FloatingPointComparison comp = new DataTypesDebugExercise.FloatingPointComparison();
        
        // Test equality
        assertTrue(comp.areEqual(0.1 + 0.2, 0.3));
        assertFalse(comp.areEqual(0.1, 0.2));
        
        // Test zero
        assertTrue(comp.isZero(0.0));
        assertFalse(comp.isZero(0.1));
    }

    @Test
    public void testStringOperations() {
        DataTypesDebugExercise.StringOperations ops = new DataTypesDebugExercise.StringOperations();
        
        // Test concatenation
        String[] strings = {"Hello", " ", "World"};
        assertEquals("Hello World", ops.concatenate(strings));
        
        // Test palindrome
        assertTrue(ops.isPalindrome("radar"));
        assertFalse(ops.isPalindrome("hello"));
    }

    @Test
    public void testArrayOperations() {
        DataTypesDebugExercise.ArrayOperations ops = new DataTypesDebugExercise.ArrayOperations();
        
        // Test resize
        int[] arr = {1, 2, 3};
        int[] resized = ops.resizeArray(arr, 5);
        assertEquals(5, resized.length);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, resized);
        
        // Test find max
        assertEquals(5, ops.findMax(new int[]{1, 5, 3, 2}));
        assertEquals(0, ops.findMax(new int[]{-1, -5, -3}));
    }

    @Test
    public void testWrapperOperations() {
        DataTypesDebugExercise.WrapperOperations ops = new DataTypesDebugExercise.WrapperOperations();
        
        // Test addition
        assertEquals(5, ops.add(2, 3));
        assertNull(ops.add(null, 3));
        
        // Test positive check
        assertTrue(ops.isPositive(5));
        assertFalse(ops.isPositive(-5));
        assertFalse(ops.isPositive(null));
    }

    @Test
    public void testBigDecimalOperations() {
        DataTypesDebugExercise.BigDecimalOperations ops = new DataTypesDebugExercise.BigDecimalOperations();
        
        // Test interest calculation
        BigDecimal principal = new BigDecimal("1000.00");
        BigDecimal rate = new BigDecimal("0.05");
        assertEquals(new BigDecimal("50.00"), ops.calculateInterest(principal, rate));
        
        // Test comparison
        assertTrue(ops.isGreaterThan(new BigDecimal("1.5"), new BigDecimal("1.0")));
        assertFalse(ops.isGreaterThan(new BigDecimal("1.0"), new BigDecimal("1.5")));
    }

    @Test
    public void testDateOperations() {
        DataTypesDebugExercise.DateOperations ops = new DataTypesDebugExercise.DateOperations();
        
        // Test add days
        LocalDate date = LocalDate.of(2024, 1, 1);
        assertEquals(LocalDate.of(2024, 1, 8), ops.addDays(date, 7));
        
        // Test weekend check
        LocalDate weekend = LocalDate.of(2024, 1, 6); // Saturday
        LocalDate weekday = LocalDate.of(2024, 1, 1); // Monday
        assertTrue(ops.isWeekend(weekend));
        assertFalse(ops.isWeekend(weekday));
    }

    @Test
    public void testCollectionOperations() {
        DataTypesDebugExercise.CollectionOperations ops = new DataTypesDebugExercise.CollectionOperations();
        
        // Test add item
        ops.addItem("test");
        assertEquals("test", ops.getItem(0));
        
        // Test null handling
        ops.addItem(null);
        assertNull(ops.getItem(1));
    }

    @Test
    public void testEnumOperations() {
        DataTypesDebugExercise.EnumOperations ops = new DataTypesDebugExercise.EnumOperations();
        
        // Test status check
        assertTrue(ops.isActive(DataTypesDebugExercise.EnumOperations.Status.ACTIVE));
        assertFalse(ops.isActive(DataTypesDebugExercise.EnumOperations.Status.INACTIVE));
        
        // Test status conversion
        assertEquals(DataTypesDebugExercise.EnumOperations.Status.ACTIVE, 
                    ops.getStatus("ACTIVE"));
    }

    @Test
    public void testScopeOperations() {
        DataTypesDebugExercise.ScopeOperations ops = new DataTypesDebugExercise.ScopeOperations();
        
        // Test counter
        ops.incrementCounter();
        assertEquals(1, ops.getCounter());
        
        ops.incrementCounter();
        assertEquals(2, ops.getCounter());
    }
} 