# Spring Boot + React Debugging Exercise

This exercise contains a Todo application with various bugs that need to be fixed. The application is built using Spring Boot 3.2.3 and React.js.

## Exercise Structure

The project contains several bugs across different layers:

### Backend Bugs

1. **Controller Layer**
   - Missing validation in the create endpoint
   - Incorrect response status codes
   - Missing error handling
   - CORS configuration issues

2. **Service Layer**
   - Transaction management issues
   - Missing null checks
   - Incorrect business logic in update operation
   - Memory leak in list operations

3. **Repository Layer**
   - Missing index on frequently queried fields
   - Incorrect query methods
   - Missing pagination support
   - N+1 query problem

4. **Model Layer**
   - Missing validation annotations
   - Incorrect JPA annotations
   - Missing audit fields
   - Incorrect relationship mappings

### Frontend Bugs

1. **React Components**
   - Memory leaks in useEffect hooks
   - Missing error boundaries
   - Incorrect state management
   - Missing loading states

2. **API Integration**
   - Missing error handling
   - Incorrect API endpoint URLs
   - Missing request headers
   - Race conditions in concurrent requests

3. **UI/UX**
   - Missing loading indicators
   - Incorrect form validation
   - Missing error messages
   - Accessibility issues

4. **Performance**
   - Unnecessary re-renders
   - Missing memoization
   - Large bundle size
   - Missing code splitting

## How to Run

1. Clone the repository
2. Run the backend:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Run the frontend:
   ```bash
   cd src/main/frontend
   npm install
   npm start
   ```

## Debugging Hints

1. Check the browser console for frontend errors
2. Monitor the Spring Boot logs for backend issues
3. Use the browser's network tab to inspect API calls
4. Use React Developer Tools to debug component issues
5. Use Spring Boot Actuator endpoints to monitor the application

## Learning Objectives

1. Understand common issues in Spring Boot applications
2. Learn to debug React applications effectively
3. Practice fixing full-stack application issues
4. Understand the importance of proper error handling
5. Learn about performance optimization techniques

## Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [React Documentation](https://reactjs.org/docs/getting-started.html)
- [Spring Data JPA Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [React Testing Library Documentation](https://testing-library.com/docs/react-testing-library/intro/) 