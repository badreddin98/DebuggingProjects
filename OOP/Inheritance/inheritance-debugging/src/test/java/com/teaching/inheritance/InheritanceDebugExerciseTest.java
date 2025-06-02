package com.teaching.inheritance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InheritanceDebugExerciseTest {
    @Test
    public void testBirdAndPenguin() {
        InheritanceDebugExercise.Bird bird = new InheritanceDebugExercise.Bird();
        InheritanceDebugExercise.Penguin penguin = new InheritanceDebugExercise.Penguin();
        
        // Bird can fly
        assertDoesNotThrow(() -> bird.fly());
        
        // Penguin can't fly
        assertThrows(UnsupportedOperationException.class, () -> penguin.fly());
    }

    @Test
    public void testListAndCountingList() {
        InheritanceDebugExercise.CountingList list = new InheritanceDebugExercise.CountingList();
        
        list.add("Item 1");
        list.add("Item 2");
        
        assertEquals(2, list.getCount());
    }

    @Test
    public void testAnimalHierarchy() {
        InheritanceDebugExercise.Animal animal = new InheritanceDebugExercise.Animal();
        InheritanceDebugExercise.Dog dog = new InheritanceDebugExercise.Dog();
        InheritanceDebugExercise.Robot robot = new InheritanceDebugExercise.Robot();
        
        // Each makes its own sound
        assertDoesNotThrow(() -> animal.makeSound());
        assertDoesNotThrow(() -> dog.makeSound());
        assertDoesNotThrow(() -> robot.makeSound());
    }

    @Test
    public void testStackAndStringList() {
        InheritanceDebugExercise.StringList list = new InheritanceDebugExercise.StringList();
        
        list.add("Item 1");
        list.add("Item 2");
        
        // StringList inherits from Stack but doesn't maintain stack behavior
        assertDoesNotThrow(() -> list.add("Item 3"));
    }

    @Test
    public void testBaseAndDerived() {
        InheritanceDebugExercise.Base base = new InheritanceDebugExercise.Base();
        InheritanceDebugExercise.Derived derived = new InheritanceDebugExercise.Derived();
        
        // Base accepts any value
        assertDoesNotThrow(() -> base.setValue(-1));
        
        // Derived enforces positive values
        assertThrows(IllegalArgumentException.class, () -> derived.setValue(-1));
    }

    @Test
    public void testRectangleAndSquare() {
        InheritanceDebugExercise.Rectangle rectangle = new InheritanceDebugExercise.Rectangle();
        InheritanceDebugExercise.Square square = new InheritanceDebugExercise.Square();
        
        // Rectangle can have different width and height
        rectangle.setWidth(4);
        rectangle.setHeight(5);
        assertEquals(20, rectangle.getArea());
        
        // Square maintains equal width and height
        square.setWidth(4);
        assertEquals(4, square.getArea());
        square.setHeight(5);
        assertEquals(25, square.getArea());
    }

    @Test
    public void testConstants() {
        // Constants can be hidden in subclasses
        assertEquals(3.14159, InheritanceDebugExercise.Constants.PI);
        assertEquals(3.14, InheritanceDebugExercise.MathConstants.PI);
    }

    @Test
    public void testStaticMethods() {
        // Static methods don't follow polymorphism
        InheritanceDebugExercise.Parent parent = new InheritanceDebugExercise.Parent();
        InheritanceDebugExercise.Child child = new InheritanceDebugExercise.Child();
        InheritanceDebugExercise.Parent childAsParent = new InheritanceDebugExercise.Child();
        
        assertDoesNotThrow(() -> InheritanceDebugExercise.Parent.print());
        assertDoesNotThrow(() -> InheritanceDebugExercise.Child.print());
    }

    @Test
    public void testFinalMethods() {
        InheritanceDebugExercise.Vehicle vehicle = new InheritanceDebugExercise.Vehicle();
        InheritanceDebugExercise.Car car = new InheritanceDebugExercise.Car();
        
        // Final methods can't be overridden
        assertDoesNotThrow(() -> vehicle.start());
        assertDoesNotThrow(() -> car.start());
    }

    @Test
    public void testPrivateMethods() {
        InheritanceDebugExercise.ParentClass parent = new InheritanceDebugExercise.ParentClass();
        InheritanceDebugExercise.ChildClass child = new InheritanceDebugExercise.ChildClass();
        
        // Private methods can't be overridden
        assertDoesNotThrow(() -> parent.callPrivateMethod());
        assertDoesNotThrow(() -> child.callPrivateMethod());
    }

    @Test
    public void testShapeAndCircle() {
        InheritanceDebugExercise.Circle circle = new InheritanceDebugExercise.Circle("Red", 5.0);
        
        // Circle properly implements Shape
        assertEquals(Math.PI * 25, circle.getArea());
        assertEquals(2 * Math.PI * 5, circle.getPerimeter());
    }
} 