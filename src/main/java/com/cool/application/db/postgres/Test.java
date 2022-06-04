package com.cool.application.db.postgres;

import com.cool.application.db.DbConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test implements DbConnectionProvider {

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.163:5432/coolcatsdb", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}