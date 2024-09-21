package com.hei.absencemanagement.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String DB_URL = System.getenv("DB_URL");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        if (DB_URL == null || DB_USER == null || DB_PASSWORD == null) {
            throw new IllegalStateException("Les variables d'environnement pour la base de données ne sont pas définies.");
        }

        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
