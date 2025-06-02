# Unit Testing Debugging Exercise

This exercise contains 10 broken unit testing scenarios that violate testing best practices. Students are required to identify and fix these issues.

## Exercise Structure

The exercise consists of two main files:
1. `UnitTestingDebugExercise.java`: Contains the classes with issues
2. `UnitTestingDebugExerciseTest.java`: Contains the broken test cases

## Broken Scenarios

1. **Multiple Assertions in One Test**
   - Test: `testUserValidation`
   - Issue: Multiple assertions testing different behaviors in a single test
   - Fix: Split into separate tests for each validation case

2. **External Dependencies**
   - Test: `testOrderProcessing`
   - Issue: Test depends on real database and email service
   - Fix: Use mocking to isolate the test

3. **Non-deterministic Behavior**
   - Test: `testRandomNumber`
   - Issue: Test depends on random number generation
   - Fix: Use a seeded random number generator or mock

4. **Shared State**
   - Test: `testCounter`
   - Issue: Tests share static state
   - Fix: Remove static state or reset between tests

5. **Time-dependent Code**
   - Test: `testBusinessHours`
   - Issue: Test depends on current time
   - Fix: Use a time provider that can be controlled in tests

6. **Too Many Responsibilities**
   - Test: `testUserCreation`
   - Issue: Test verifies multiple behaviors
   - Fix: Split into separate tests for each responsibility

7. **Hidden Dependencies**
   - Test: `testConfiguration`
   - Issue: Static configuration affects all tests
   - Fix: Use instance-based configuration

8. **Complex Setup**
   - Test: `testComplexService`
   - Issue: Test requires complex initialization
   - Fix: Use test fixtures and builders

9. **No Assertions**
   - Test: `testCalculator`
   - Issue: Test has no assertions
   - Fix: Add appropriate assertions

10. **Implementation Details**
    - Test: `testStringFormatter`
    - Issue: Test depends on internal implementation
    - Fix: Test behavior, not implementation

## Example of Correct Testing

The `BankAccount` class demonstrates proper unit testing practices:
- Single responsibility
- Clear assertions
- Proper error handling
- Isolated tests
- No external dependencies

## How to Run the Exercise

1. Clone the repository
2. Open the project in your IDE
3. Run the tests to see them fail
4. Fix each issue one at a time
5. Verify your fixes by running the tests

## Learning Objectives

- Understand unit testing best practices
- Learn to identify and fix common testing issues
- Practice writing maintainable and reliable tests
- Understand the importance of test isolation
- Learn to use mocking effectively

## Resources

- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [Unit Testing Best Practices](https://martinfowler.com/bliki/UnitTest.html)
- [Test-Driven Development](https://martinfowler.com/bliki/TestDrivenDevelopment.html) 