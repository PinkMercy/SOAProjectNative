package com.example.e_commerce_soa_project.utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    public static void main(String[] args) {
        try (Connection conn = Singleton.getConnection()) {
            System.out.println("Database connected: " + (conn != null));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/soaproject";
    private static final String USER = "root"; // Default MySQL username
    private static final String PASSWORD = ""; // Default MySQL password (leave empty for XAMPP/WAMP)

    // Static variable to hold the single connection instance
    private static Connection connection;

    /**
     * Private constructor to prevent instantiation
     */
    private Singleton() {
        // Prevent instantiation
    }

    /**
     * Provides a single instance of the database connection
     * @return Connection object
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (Singleton.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(URL, USER, PASSWORD);
                        System.out.println("Database connection established.");
                    } catch (SQLException e) {
                        System.err.println("Failed to connect to the database!");
                        e.printStackTrace();
                        throw new RuntimeException("Error connecting to the database", e);
                    }
                }
            }
        }
        return connection;
    }

    /**
     * Closes the database connection when the application is shutting down
     */
//    public static void closeConnection() {
//        if (connection != null) {
//            try {
//                connection.close();
//                System.out.println("Database connection closed.");
//            } catch (SQLException e) {
//                System.err.println("Error while closing the database connection.");
//                e.printStackTrace();
//            } finally {
//                connection = null;
//            }
//        }
//    }
}
