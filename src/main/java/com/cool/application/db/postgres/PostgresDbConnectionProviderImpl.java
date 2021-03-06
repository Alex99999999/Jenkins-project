package com.cool.application.db.postgres;

import com.cool.application.db.DbConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDbConnectionProviderImpl implements DbConnectionProvider {

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.163:5432/coolcatsdb", "postgres", "postgres");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}