package com.teaching.polymorphism;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class PolymorphismDebugExerciseTest {
    @Test
    public void testShapeProcessor() {
        PolymorphismDebugExercise.ShapeProcessor processor = new PolymorphismDebugExercise.ShapeProcessor();
        PolymorphismDebugExercise.Circle circle = new PolymorphismDebugExercise.Circle("Red", 5.0);
        PolymorphismDebugExercise.Rectangle rectangle = new PolymorphismDebugExercise.Rectangle("Blue", 4.0, 6.0);
        
        // Type checking instead of polymorphism
        assertEquals("Processing circle", processor.processShape(circle));
        assertEquals("Processing rectangle", processor.processShape(rectangle));
    }

    @Test
    public void testStaticMethodPolymorphism() {
        // Static methods don't support polymorphism
        assertEquals(3.0, PolymorphismDebugExercise.MathOperations.add(1.0, 2.0));
        assertEquals(4.0, PolymorphismDebugExercise.AdvancedMath.add(1.0, 2.0));
    }

    @Test
    public void testFieldHiding() {
        PolymorphismDebugExercise.Parent parent = new PolymorphismDebugExercise.Parent();
        PolymorphismDebugExercise.Child child = new PolymorphismDebugExercise.Child();
        PolymorphismDebugExercise.Parent childAsParent = new PolymorphismDebugExercise.Child();
        
        assertEquals("Parent", parent.value);
        assertEquals("Child", child.value);
        assertEquals("Parent", childAsParent.value); // Field hiding
    }

    @Test
    public void testCovariantReturnTypes() {
        PolymorphismDebugExercise.Animal animal = new PolymorphismDebugExercise.Animal();
        PolymorphismDebugExercise.Dog dog = new PolymorphismDebugExercise.Dog();
        
        assertEquals("Some sound", animal.getSound());
        assertEquals("Woof", dog.getSound());
    }

    @Test
    public void testMethodOverloading() {
        PolymorphismDebugExercise.Calculator calc = new PolymorphismDebugExercise.Calculator();
        
        assertEquals(3, calc.add(1, 2));
        assertEquals(3.0, calc.add(1.0, 2.0));
        assertEquals("12", calc.add("1", "2"));
    }

    @Test
    public void testInterfaceImplementation() {
        PolymorphismDebugExercise.Circle circle = new PolymorphismDebugExercise.Circle("Red", 5.0);
        PolymorphismDebugExercise.Rectangle rectangle = new PolymorphismDebugExercise.Rectangle("Blue", 4.0, 6.0);
        
        // Circle implements Drawable
        assertDoesNotThrow(() -> circle.draw());
        
        // Rectangle doesn't implement Drawable
        assertFalse(rectangle instanceof PolymorphismDebugExercise.Drawable);
    }

    @Test
    public void testPolymorphicParameters() {
        PolymorphismDebugExercise.DataProcessor processor = new PolymorphismDebugExercise.DataProcessor();
        PolymorphismDebugExercise.StringProcessor stringProcessor = new PolymorphismDebugExercise.StringProcessor();
        
        List<Object> data = new ArrayList<>();
        data.add("test");
        
        // Both processors can handle List<Object>
        assertDoesNotThrow(() -> processor.process(data));
        assertDoesNotThrow(() -> stringProcessor.process(data));
    }

    @Test
    public void testConstructorChaining() {
        // Derived class constructor should call super
        assertThrows(Exception.class, () -> new PolymorphismDebugExercise.Derived());
    }

    @Test
    public void testMethodOverridingAccess() {
        PolymorphismDebugExercise.ParentClass parent = new PolymorphismDebugExercise.ParentClass();
        PolymorphismDebugExercise.ChildClass child = new PolymorphismDebugExercise.ChildClass();
        
        // Parent method is protected
        assertDoesNotThrow(() -> parent.doSomething());
        
        // Child method can't reduce visibility
        assertThrows(Exception.class, () -> child.doSomething());
    }

    @Test
    public void testPolymorphicCollections() {
        PolymorphismDebugExercise.AnimalList animalList = new PolymorphismDebugExercise.AnimalList();
        
        PolymorphismDebugExercise.Animal animal = new PolymorphismDebugExercise.Animal();
        PolymorphismDebugExercise.Dog dog = new PolymorphismDebugExercise.Dog();
        
        animalList.addAnimal(animal);
        animalList.addAnimal(dog);
        
        List<PolymorphismDebugExercise.Animal> animals = animalList.getAnimals();
        assertEquals(2, animals.size());
    }

    @Test
    public void testCorrectPolymorphism() {
        PolymorphismDebugExercise.Shape circle = new PolymorphismDebugExercise.Circle("Red", 5.0);
        PolymorphismDebugExercise.Shape rectangle = new PolymorphismDebugExercise.Rectangle("Blue", 4.0, 6.0);
        
        // Polymorphic method calls
        assertEquals(Math.PI * 25, circle.getArea());
        assertEquals(24.0, rectangle.getArea());
        
        assertEquals(2 * Math.PI * 5, circle.getPerimeter());
        assertEquals(20.0, rectangle.getPerimeter());
    }
} 