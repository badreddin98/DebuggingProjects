package com.teaching.unittesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitTestingDebugExerciseTest {
    // Bug 1: Multiple assertions in one test
    @Test
    void testUserValidation() {
        UserService service = new UserService();
        assertTrue(service.validateUser("validUser", "validPassword"));
        assertFalse(service.validateUser("", "validPassword"));
        assertFalse(service.validateUser("validUser", "short"));
        assertFalse(service.validateUser(null, "validPassword"));
        assertFalse(service.validateUser("validUser", null));
    }

    // Bug 2: Test with external dependencies
    @Test
    void testOrderProcessing() {
        Database database = new Database();
        OrderProcessor processor = new OrderProcessor(database);
        Order order = new Order("customer@email.com");
        processor.processOrder(order);
        // No assertions, just hoping it works
    }

    // Bug 3: Test with non-deterministic behavior
    @Test
    void testRandomNumber() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int number = generator.generateNumber();
        assertTrue(number >= 0 && number < 100);
    }

    // Bug 4: Test with shared state
    @Test
    void testCounter() {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        counter1.increment();
        assertEquals(1, counter2.getCount());
    }

    // Bug 5: Test with time-dependent code
    @Test
    void testBusinessHours() {
        TimeBasedService service = new TimeBasedService();
        boolean isBusinessHours = service.isBusinessHours();
        assertTrue(isBusinessHours);
    }

    // Bug 6: Test with too many responsibilities
    @Test
    void testUserCreation() {
        UserManager manager = new UserManager();
        manager.createUser("username", "email@test.com", "password");
        // No assertions, testing multiple things at once
    }

    // Bug 7: Test with hidden dependencies
    @Test
    void testConfiguration() {
        ConfigurationManager manager1 = new ConfigurationManager();
        ConfigurationManager manager2 = new ConfigurationManager();
        manager1.setConfigPath("new/path");
        assertEquals("new/path", manager2.getConfigPath());
    }

    // Bug 8: Test with complex setup
    @Test
    void testComplexService() {
        ComplexService service = new ComplexService();
        service.processData("test");
        // No assertions, complex setup
    }

    // Bug 9: Test with no assertions
    @Test
    void testCalculator() {
        Calculator calculator = new Calculator();
        calculator.add(2, 3);
    }

    // Bug 10: Test with implementation details
    @Test
    void testStringFormatter() {
        StringFormatter formatter = new StringFormatter();
        formatter.addWord("Hello");
        formatter.addWord("World");
        assertEquals("Hello World", formatter.format());
    }

    // Example of correct unit testing
    @Test
    void testBankAccountDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testBankAccountWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    void testBankAccountInvalidDeposit() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }

    @Test
    void testBankAccountInvalidWithdraw() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalStateException.class, () -> account.withdraw(150.0));
    }
} 