package com.teaching.lsp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LSPDebugExerciseTest {
    @Test
    public void testRectangleSquare() {
        // Test Rectangle
        LSPDebugExercise.Rectangle rectangle = new LSPDebugExercise.Rectangle();
        rectangle.setWidth(4);
        rectangle.setHeight(5);
        assertEquals(20, rectangle.getArea());

        // Test Square
        LSPDebugExercise.Square square = new LSPDebugExercise.Square();
        square.setWidth(4);
        square.setHeight(5); // This should maintain square properties
        assertEquals(25, square.getArea()); // This will fail due to LSP violation
    }

    @Test
    public void testBirdPenguin() {
        // Test Bird
        LSPDebugExercise.Bird bird = new LSPDebugExercise.Bird();
        assertDoesNotThrow(() -> bird.fly());

        // Test Penguin
        LSPDebugExercise.Penguin penguin = new LSPDebugExercise.Penguin();
        assertThrows(UnsupportedOperationException.class, () -> penguin.fly());
    }

    @Test
    public void testAccountOverdraftAccount() {
        // Test Account
        LSPDebugExercise.Account account = new LSPDebugExercise.Account();
        account.deposit(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(150));

        // Test OverdraftAccount
        LSPDebugExercise.OverdraftAccount overdraftAccount = new LSPDebugExercise.OverdraftAccount();
        overdraftAccount.deposit(100);
        assertDoesNotThrow(() -> overdraftAccount.withdraw(150)); // This will pass but violates LSP
    }

    @Test
    public void testFileReadOnlyFile() {
        // Test File
        LSPDebugExercise.File file = new LSPDebugExercise.File();
        assertDoesNotThrow(() -> file.write("content"));

        // Test ReadOnlyFile
        LSPDebugExercise.ReadOnlyFile readOnlyFile = new LSPDebugExercise.ReadOnlyFile();
        assertThrows(UnsupportedOperationException.class, () -> readOnlyFile.write("content"));
    }

    @Test
    public void testCollectionImmutableCollection() {
        // Test Collection
        LSPDebugExercise.Collection collection = new LSPDebugExercise.Collection();
        assertDoesNotThrow(() -> collection.add("item"));
        assertDoesNotThrow(() -> collection.remove("item"));

        // Test ImmutableCollection
        LSPDebugExercise.ImmutableCollection immutableCollection = new LSPDebugExercise.ImmutableCollection();
        assertThrows(UnsupportedOperationException.class, () -> immutableCollection.add("item"));
        assertThrows(UnsupportedOperationException.class, () -> immutableCollection.remove("item"));
    }

    @Test
    public void testVehicleElectricCar() {
        // Test Vehicle
        LSPDebugExercise.Vehicle vehicle = new LSPDebugExercise.Vehicle();
        assertDoesNotThrow(() -> vehicle.refuel(50));

        // Test ElectricCar
        LSPDebugExercise.ElectricCar electricCar = new LSPDebugExercise.ElectricCar();
        assertThrows(UnsupportedOperationException.class, () -> electricCar.refuel(50));
    }

    @Test
    public void testStackBoundedStack() {
        // Test Stack
        LSPDebugExercise.Stack stack = new LSPDebugExercise.Stack();
        assertDoesNotThrow(() -> {
            for (int i = 0; i < 100; i++) {
                stack.push(i);
            }
        });

        // Test BoundedStack
        LSPDebugExercise.BoundedStack boundedStack = new LSPDebugExercise.BoundedStack(5);
        assertDoesNotThrow(() -> {
            for (int i = 0; i < 5; i++) {
                boundedStack.push(i);
            }
        });
        assertThrows(IllegalStateException.class, () -> boundedStack.push(6));
    }

    @Test
    public void testLoggerConsoleLogger() {
        // Test Logger
        LSPDebugExercise.Logger logger = new LSPDebugExercise.Logger();
        assertDoesNotThrow(() -> logger.log(null));

        // Test ConsoleLogger
        LSPDebugExercise.ConsoleLogger consoleLogger = new LSPDebugExercise.ConsoleLogger();
        assertThrows(IllegalArgumentException.class, () -> consoleLogger.log(null));
    }

    @Test
    public void testShapeCircle() {
        // Test Shape
        LSPDebugExercise.Shape shape = new LSPDebugExercise.Shape();
        assertDoesNotThrow(() -> shape.draw());

        // Test Circle
        LSPDebugExercise.Circle circle = new LSPDebugExercise.Circle();
        assertThrows(IllegalStateException.class, () -> circle.draw());
        assertThrows(IllegalArgumentException.class, () -> circle.setRadius(-1));
    }

    @Test
    public void testDatabaseConnectionReadOnlyConnection() {
        // Test DatabaseConnection
        LSPDebugExercise.DatabaseConnection connection = new LSPDebugExercise.DatabaseConnection();
        assertDoesNotThrow(() -> connection.executeUpdate("UPDATE table SET column = value"));

        // Test ReadOnlyConnection
        LSPDebugExercise.ReadOnlyConnection readOnlyConnection = new LSPDebugExercise.ReadOnlyConnection();
        assertThrows(UnsupportedOperationException.class, 
            () -> readOnlyConnection.executeUpdate("UPDATE table SET column = value"));
    }
} 