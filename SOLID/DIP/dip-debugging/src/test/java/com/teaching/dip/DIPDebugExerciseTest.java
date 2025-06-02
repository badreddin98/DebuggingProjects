package com.teaching.dip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DIPDebugExerciseTest {
    @Test
    public void testUserService() {
        DIPDebugExercise.UserService userService = new DIPDebugExercise.UserService();
        assertDoesNotThrow(() -> userService.saveUser("testUser"));
    }

    @Test
    public void testOrderProcessor() {
        DIPDebugExercise.OrderProcessor orderProcessor = new DIPDebugExercise.OrderProcessor();
        assertDoesNotThrow(() -> orderProcessor.processOrder("testOrder"));
    }

    @Test
    public void testShoppingCart() {
        DIPDebugExercise.ShoppingCart shoppingCart = new DIPDebugExercise.ShoppingCart();
        assertDoesNotThrow(() -> shoppingCart.checkout(100.0));
    }

    @Test
    public void testUserManager() {
        DIPDebugExercise.UserManager userManager = new DIPDebugExercise.UserManager();
        assertDoesNotThrow(() -> userManager.createUser("testUser"));
    }

    @Test
    public void testDocumentManager() {
        DIPDebugExercise.DocumentManager documentManager = new DIPDebugExercise.DocumentManager();
        assertDoesNotThrow(() -> documentManager.saveDocument("testDocument"));
    }

    @Test
    public void testProductService() {
        DIPDebugExercise.ProductService productService = new DIPDebugExercise.ProductService();
        String product = productService.getProduct("123");
        assertNotNull(product);
        assertTrue(product.startsWith("Product"));
    }

    @Test
    public void testOrderService() {
        DIPDebugExercise.OrderService orderService = new DIPDebugExercise.OrderService();
        assertDoesNotThrow(() -> orderService.placeOrder("testOrder"));
    }

    @Test
    public void testSearchService() {
        DIPDebugExercise.SearchService searchService = new DIPDebugExercise.SearchService();
        assertDoesNotThrow(() -> searchService.search("testQuery"));
    }

    @Test
    public void testSecurityManager() {
        DIPDebugExercise.SecurityManager securityManager = new DIPDebugExercise.SecurityManager();
        boolean result = securityManager.authenticate("testUser", "password");
        assertTrue(result);
    }

    @Test
    public void testReportService() {
        DIPDebugExercise.ReportService reportService = new DIPDebugExercise.ReportService();
        assertDoesNotThrow(() -> reportService.generateReport("testData"));
    }
} 