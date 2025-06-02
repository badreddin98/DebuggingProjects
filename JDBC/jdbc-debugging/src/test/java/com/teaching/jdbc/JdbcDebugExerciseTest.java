package com.teaching.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class JdbcDebugExerciseTest {
    private JdbcDebugExercise exercise;

    @BeforeEach
    void setUp() throws SQLException {
        exercise = new JdbcDebugExercise();
        initializeDatabase();
    }

    private void initializeDatabase() throws SQLException {
        try (Connection conn = exercise.getConnection()) {
            // Create users table
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), age INT, last_login DATE, image BLOB)");
                stmt.execute("INSERT INTO users (name, age) VALUES ('John', 25), ('Jane', 30)");
            }

            // Create accounts table
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE TABLE accounts (id INT PRIMARY KEY AUTO_INCREMENT, balance DOUBLE)");
                stmt.execute("INSERT INTO accounts (balance) VALUES (1000.0), (500.0)");
            }

            // Create stored procedure
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE ALIAS update_user_status AS $$ void updateUserStatus(int userId) { /* implementation */ } $$");
            }
        }
    }

    @Test
    void testGetConnection() throws SQLException {
        try (Connection conn = exercise.getConnection()) {
            assertNotNull(conn);
            assertFalse(conn.isClosed());
        }
    }

    @Test
    void testFindUsersByName() throws SQLException {
        List<String> users = exercise.findUsersByName("John");
        assertEquals(1, users.size());
        assertEquals("John", users.get(0));
    }

    @Test
    void testInsertUser() throws SQLException {
        exercise.insertUser("Alice", 28);
        try (Connection conn = exercise.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE name = 'Alice'")) {
            assertTrue(rs.next());
            assertEquals(28, rs.getInt("age"));
        }
    }

    @Test
    void testTransferMoney() throws SQLException {
        exercise.transferMoney(1, 2, 100.0);
        try (Connection conn = exercise.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT balance FROM accounts WHERE id = 1")) {
            assertTrue(rs.next());
            assertEquals(900.0, rs.getDouble("balance"), 0.001);
        }
    }

    @Test
    void testInsertUsers() throws SQLException {
        List<String> names = Arrays.asList("Bob", "Charlie", "David");
        exercise.insertUsers(names);
        try (Connection conn = exercise.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM users")) {
            assertTrue(rs.next());
            assertEquals(5, rs.getInt(1)); // 2 initial + 3 new users
        }
    }

    @Test
    void testGetAccountBalance() throws SQLException {
        double balance = exercise.getAccountBalance(1);
        assertEquals(1000.0, balance, 0.001);
    }

    @Test
    void testUpdateUserLastLogin() throws SQLException {
        exercise.updateUserLastLogin(1);
        try (Connection conn = exercise.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT last_login FROM users WHERE id = 1")) {
            assertTrue(rs.next());
            assertNotNull(rs.getDate("last_login"));
        }
    }

    @Test
    void testGetAllUsers() throws SQLException {
        List<String> users = exercise.getAllUsers();
        assertEquals(2, users.size());
        assertTrue(users.contains("John"));
        assertTrue(users.contains("Jane"));
    }

    @Test
    void testSaveUserImage() throws SQLException {
        byte[] imageData = new byte[]{1, 2, 3, 4, 5};
        exercise.saveUserImage(1, imageData);
        try (Connection conn = exercise.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT image FROM users WHERE id = 1")) {
            assertTrue(rs.next());
            byte[] savedData = rs.getBytes("image");
            assertArrayEquals(imageData, savedData);
        }
    }

    @Test
    void testCallStoredProcedure() throws SQLException {
        assertDoesNotThrow(() -> exercise.callStoredProcedure(1));
    }
} 