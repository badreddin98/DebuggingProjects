package com.teaching.sealed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SealedClassesDebugExerciseTest {
    private final SealedClassesDebugExercise exercise = new SealedClassesDebugExercise();

    @Test
    void testShape() {
        SealedClassesDebugExercise.Shape.Circle circle = 
            new SealedClassesDebugExercise.Shape.Circle(5.0);
        assertEquals(78.54, circle.getArea(), 0.01);
    }

    @Test
    void testVehicle() {
        SealedClassesDebugExercise.Car car = 
            new SealedClassesDebugExercise.Car("Toyota");
        SealedClassesDebugExercise.Truck truck = 
            new SealedClassesDebugExercise.Truck("Ford");
        assertEquals("Toyota", car.brand);
        assertEquals("Ford", truck.brand);
    }

    @Test
    void testExpression() {
        SealedClassesDebugExercise.Expression.Constant constant = 
            new SealedClassesDebugExercise.Expression.Constant(42);
        assertNotNull(constant);
    }

    @Test
    void testOperation() {
        SealedClassesDebugExercise.Operation.Add add = 
            new SealedClassesDebugExercise.Operation.Add();
        SealedClassesDebugExercise.Operation.Subtract subtract = 
            new SealedClassesDebugExercise.Operation.Subtract();
        assertEquals(5, add.execute(2, 3));
        assertEquals(-1, subtract.execute(2, 3));
    }

    @Test
    void testAnimal() {
        SealedClassesDebugExercise.Animal.Dog dog = 
            new SealedClassesDebugExercise.Animal.Dog();
        SealedClassesDebugExercise.Animal.Cat cat = 
            new SealedClassesDebugExercise.Animal.Cat();
        assertNotNull(dog);
        assertNotNull(cat);
    }

    @Test
    void testContainer() {
        SealedClassesDebugExercise.Container<String>.Box<String> box = 
            new SealedClassesDebugExercise.Container<String>().new Box<>("test");
        assertNotNull(box);
    }

    @Test
    void testOuter() {
        SealedClassesDebugExercise.Outer.Inner inner = 
            new SealedClassesDebugExercise.Outer().new Inner();
        assertNotNull(inner);
    }

    @Test
    void testUtility() {
        SealedClassesDebugExercise.Utility.Helper helper = 
            new SealedClassesDebugExercise.Utility.Helper();
        assertNotNull(helper);
    }

    @Test
    void testService() {
        SealedClassesDebugExercise.Service.Implementation impl = 
            new SealedClassesDebugExercise.Service.Implementation();
        assertNotNull(impl);
        assertTrue(impl instanceof Runnable);
    }

    @Test
    void testLegacy() {
        SealedClassesDebugExercise.Legacy.Modern modern = 
            new SealedClassesDebugExercise.Legacy.Modern();
        assertNotNull(modern);
    }
} 