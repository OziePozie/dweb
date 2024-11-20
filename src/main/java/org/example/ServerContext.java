package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerContext {
    private static final String URL = "jdbc:postgresql://pg:5432/studs";
    private static final String USER = "s409429";
    private static final String PASSWORD = "1Q5LX1xLE6GFC41Y";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
