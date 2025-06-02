package com.teaching.composition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompositionDebugExerciseTest {
    @Test
    public void testCarComposition() {
        CompositionDebugExercise.Engine engine = new CompositionDebugExercise.Engine();
        CompositionDebugExercise.CarComposition car = new CompositionDebugExercise.CarComposition(engine);
        assertDoesNotThrow(() -> car.drive());
    }

    @Test
    public void testComputerComposition() {
        CompositionDebugExercise.CPU cpu = new CompositionDebugExercise.CPU();
        CompositionDebugExercise.ComputerComposition computer = new CompositionDebugExercise.ComputerComposition(cpu);
        
        CompositionDebugExercise.Memory memory = new CompositionDebugExercise.Memory();
        CompositionDebugExercise.Storage storage = new CompositionDebugExercise.Storage();
        
        computer.addMemory(memory);
        computer.addStorage(storage);
        
        assertDoesNotThrow(() -> computer.process());
    }

    @Test
    public void testCarInheritance() {
        CompositionDebugExercise.Car car = new CompositionDebugExercise.Car();
        assertDoesNotThrow(() -> car.drive());
    }

    @Test
    public void testComputerInheritance() {
        CompositionDebugExercise.Computer computer = new CompositionDebugExercise.Computer();
        assertDoesNotThrow(() -> computer.process());
    }

    @Test
    public void testHouseInheritance() {
        CompositionDebugExercise.House house = new CompositionDebugExercise.House();
        assertDoesNotThrow(() -> house.live());
    }

    @Test
    public void testBookInheritance() {
        CompositionDebugExercise.Book book = new CompositionDebugExercise.Book();
        assertDoesNotThrow(() -> book.read());
    }

    @Test
    public void testPhoneInheritance() {
        CompositionDebugExercise.Phone phone = new CompositionDebugExercise.Phone();
        assertDoesNotThrow(() -> phone.use());
    }

    @Test
    public void testStudentInheritance() {
        CompositionDebugExercise.Student student = new CompositionDebugExercise.Student();
        assertDoesNotThrow(() -> student.study());
    }

    @Test
    public void testRestaurantInheritance() {
        CompositionDebugExercise.Restaurant restaurant = new CompositionDebugExercise.Restaurant();
        assertDoesNotThrow(() -> restaurant.serve());
    }

    @Test
    public void testBankInheritance() {
        CompositionDebugExercise.Bank bank = new CompositionDebugExercise.Bank();
        assertDoesNotThrow(() -> bank.operate());
    }

    @Test
    public void testLibraryInheritance() {
        CompositionDebugExercise.Library library = new CompositionDebugExercise.Library();
        assertDoesNotThrow(() -> library.manage());
    }

    @Test
    public void testHospitalInheritance() {
        CompositionDebugExercise.Hospital hospital = new CompositionDebugExercise.Hospital();
        assertDoesNotThrow(() -> hospital.treat());
    }
} 