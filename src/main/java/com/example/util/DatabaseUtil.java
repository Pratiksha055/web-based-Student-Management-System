package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class for managing database connections.
 * This class provides a method to establish a connection to the database
 * using JDBC and properties loaded from a configuration file.
 */
public class DatabaseUtil {

    /**
     * Gets a database connection using properties defined in the
     * "database.properties" file.
     * 
     * @return A {@link Connection} object for the database.
     * @throws SQLException If an error occurs while establishing the connection.
     */
    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();

        try {
            // Load database properties from the "database.properties" file
            props.load(DatabaseUtil.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (Exception e) {
            // Throw an SQLException if the properties file cannot be loaded
            throw new SQLException("Cannot load database properties", e);
        }

        // Retrieve database connection details from properties
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        try {
            // Ensure the MySQL JDBC driver is available
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Throw an SQLException if the JDBC driver class is not found
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        // Return a connection to the database using the provided URL, user, and
        // password
        return DriverManager.getConnection(url, user, password);
    }
}
