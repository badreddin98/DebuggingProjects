package com.teaching.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnumsDebugExerciseTest {
    private final EnumsDebugExercise exercise = new EnumsDebugExercise();

    @Test
    void testDirection() {
        assertEquals(EnumsDebugExercise.Direction.SOUTH, 
            EnumsDebugExercise.Direction.NORTH.opposite());
        assertEquals(EnumsDebugExercise.Direction.NORTH, 
            EnumsDebugExercise.Direction.SOUTH.opposite());
        assertEquals(EnumsDebugExercise.Direction.WEST, 
            EnumsDebugExercise.Direction.EAST.opposite());
        assertEquals(EnumsDebugExercise.Direction.EAST, 
            EnumsDebugExercise.Direction.WEST.opposite());
    }

    @Test
    void testPlanet() {
        assertEquals(9.8, EnumsDebugExercise.Planet.EARTH.surfaceGravity(), 0.1);
        assertTrue(EnumsDebugExercise.Planet.JUPITER.surfaceGravity() > 
            EnumsDebugExercise.Planet.EARTH.surfaceGravity());
    }

    @Test
    void testOperation() {
        assertEquals(5.0, EnumsDebugExercise.Operation.PLUS.apply(2.0, 3.0));
        assertEquals(-1.0, EnumsDebugExercise.Operation.MINUS.apply(2.0, 3.0));
        assertEquals(6.0, EnumsDebugExercise.Operation.TIMES.apply(2.0, 3.0));
        assertEquals(2.0, EnumsDebugExercise.Operation.DIVIDE.apply(6.0, 3.0));
    }

    @Test
    void testDay() {
        assertFalse(EnumsDebugExercise.Day.MONDAY.isWeekend());
        assertTrue(EnumsDebugExercise.Day.SATURDAY.isWeekend());
        assertTrue(EnumsDebugExercise.Day.SUNDAY.isWeekend());
    }

    @Test
    void testColor() {
        assertEquals(0xFF0000, EnumsDebugExercise.Color.RED.getRGB());
        assertEquals(0x00FF00, EnumsDebugExercise.Color.GREEN.getRGB());
        assertEquals(0x0000FF, EnumsDebugExercise.Color.BLUE.getRGB());
    }

    @Test
    void testStatus() {
        EnumsDebugExercise.Status status = EnumsDebugExercise.Status.COMPLETED;
        status.setResult("Success");
        assertEquals("Success", status.getResult());
    }

    @Test
    void testOuter() {
        EnumsDebugExercise.Outer.Inner inner = EnumsDebugExercise.Outer.Inner.X;
        assertNotNull(inner);
    }

    @Test
    void testLegacy() {
        assertEquals("old", EnumsDebugExercise.Legacy.OLD.toString());
        assertEquals("new", EnumsDebugExercise.Legacy.NEW.toString());
    }

    @Test
    void testSeason() {
        assertEquals("Warm and blooming", 
            EnumsDebugExercise.Season.SPRING.getDescription());
        assertEquals("Hot and sunny", 
            EnumsDebugExercise.Season.SUMMER.getDescription());
        assertEquals("Cool and colorful", 
            EnumsDebugExercise.Season.AUTUMN.getDescription());
        assertEquals("Cold and snowy", 
            EnumsDebugExercise.Season.WINTER.getDescription());
    }

    @Test
    void testSize() {
        assertEquals(EnumsDebugExercise.Size.SMALL, 
            EnumsDebugExercise.Size.fromCode("S"));
        assertEquals(EnumsDebugExercise.Size.MEDIUM, 
            EnumsDebugExercise.Size.fromCode("M"));
        assertEquals(EnumsDebugExercise.Size.LARGE, 
            EnumsDebugExercise.Size.fromCode("L"));
        assertEquals(EnumsDebugExercise.Size.EXTRA_LARGE, 
            EnumsDebugExercise.Size.fromCode("XL"));
        assertThrows(IllegalArgumentException.class, () -> 
            EnumsDebugExercise.Size.fromCode("XXL"));
    }
} 