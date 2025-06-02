package com.teaching.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDebugExercise {
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    // Bug 1: Connection not closed properly
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Bug 2: SQL injection vulnerability
    public List<String> findUsersByName(String name) throws SQLException {
        List<String> users = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE name = '" + name + "'")) {
            while (rs.next()) {
                users.add(rs.getString("name"));
            }
        }
        return users;
    }

    // Bug 3: Resources not closed in case of exception
    public void insertUser(String name, int age) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)");
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.executeUpdate();
    }

    // Bug 4: No transaction management
    public void transferMoney(int fromId, int toId, double amount) throws SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement pstmt1 = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            pstmt1.setDouble(1, amount);
            pstmt1.setInt(2, fromId);
            pstmt1.executeUpdate();

            PreparedStatement pstmt2 = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            pstmt2.setDouble(1, amount);
            pstmt2.setInt(2, toId);
            pstmt2.executeUpdate();
        }
    }

    // Bug 5: No batch processing for multiple inserts
    public void insertUsers(List<String> names) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (name) VALUES (?)")) {
            for (String name : names) {
                pstmt.setString(1, name);
                pstmt.executeUpdate();
            }
        }
    }

    // Bug 6: No proper error handling
    public double getAccountBalance(int accountId) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT balance FROM accounts WHERE id = ?")) {
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
            return 0.0;
        }
    }

    // Bug 7: No proper date handling
    public void updateUserLastLogin(int userId) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET last_login = ? WHERE id = ?")) {
            pstmt.setDate(1, new Date(System.currentTimeMillis()));
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
        }
    }

    // Bug 8: No proper handling of large result sets
    public List<String> getAllUsers() throws SQLException {
        List<String> users = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                users.add(rs.getString("name"));
            }
        }
        return users;
    }

    // Bug 9: No proper handling of BLOB data
    public void saveUserImage(int userId, byte[] imageData) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET image = ? WHERE id = ?")) {
            pstmt.setBytes(1, imageData);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
        }
    }

    // Bug 10: No proper handling of stored procedures
    public void callStoredProcedure(int userId) throws SQLException {
        try (Connection conn = getConnection();
             CallableStatement cstmt = conn.prepareCall("{call update_user_status(?)}")) {
            cstmt.setInt(1, userId);
            cstmt.execute();
        }
    }
} 