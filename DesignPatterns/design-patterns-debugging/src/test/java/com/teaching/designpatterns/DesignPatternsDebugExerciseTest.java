package com.teaching.designpatterns;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DesignPatternsDebugExerciseTest {
    // Bug 1: Singleton test - thread safety
    @Test
    void testSingletonThreadSafety() {
        // This test should fail with the current implementation
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();
        assertSame(instance1, instance2);
    }

    // Bug 2: Factory test - Open/Closed Principle
    @Test
    void testVehicleFactory() {
        VehicleFactory factory = new VehicleFactory();
        Vehicle car = factory.createVehicle("car");
        Vehicle truck = factory.createVehicle("truck");
        Vehicle motorcycle = factory.createVehicle("motorcycle");
        
        assertNotNull(car);
        assertNotNull(truck);
        assertNotNull(motorcycle);
    }

    // Bug 3: Observer test - loose coupling
    @Test
    void testWeatherStation() {
        WeatherStation station = new WeatherStation();
        WeatherDisplay display = mock(WeatherDisplay.class);
        station.addDisplay(display);
        station.updateWeather("Sunny");
        verify(display).update("Sunny");
    }

    // Bug 4: Strategy test - abstraction
    @Test
    void testPaymentProcessor() {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("credit", 100.0);
        processor.processPayment("paypal", 200.0);
        processor.processPayment("bitcoin", 300.0);
    }

    // Bug 5: Decorator test - composition
    @Test
    void testCoffeeDecorator() {
        BasicCoffee coffee = new BasicCoffee();
        MilkCoffee milkCoffee = new MilkCoffee();
        
        assertEquals("Basic Coffee", coffee.getDescription());
        assertEquals("Basic Coffee with Milk", milkCoffee.getDescription());
        assertEquals(1.0, coffee.getCost());
        assertEquals(1.5, milkCoffee.getCost());
    }

    // Bug 6: Command test - undo functionality
    @Test
    void testLightSwitch() {
        LightSwitch lightSwitch = new LightSwitch();
        lightSwitch.turnOn();
        lightSwitch.turnOff();
    }

    // Bug 7: Adapter test - Single Responsibility
    @Test
    void testModernSystem() {
        ModernSystem system = new ModernSystem();
        system.processData("test data");
    }

    // Bug 8: Template Method test - hooks
    @Test
    void testDataProcessor() {
        DataProcessor processor = new DataProcessor();
        processor.process();
    }

    // Bug 9: Builder test - validation
    @Test
    void testUserBuilder() {
        UserBuilder builder = new UserBuilder();
        User user = builder
            .setName("John")
            .setAge(30)
            .setEmail("john@example.com")
            .build();
    }

    // Bug 10: Chain of Responsibility test - fallback
    @Test
    void testRequestHandler() {
        RequestHandler handler = new RequestHandler();
        Request request = new Request();
        handler.handle(request);
    }

    // Example of correct design pattern test
    @Test
    void testThreadSafeSingleton() {
        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();
        assertSame(instance1, instance2);
    }
} 