package com.cool.application.db.postgres;

import com.cool.application.db.DbConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDbConnectionProviderImpl2 implements DbConnectionProvider {

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;

        connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.193:5432/coolcatsDB", "postgres", "postgres");


//            System.out.println("Java JDBC PostgreSQL Example");
        // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within
        // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver");


//        catch (ClassNotFoundException e) {
//            System.out.println("PostgreSQL JDBC driver not found.");
//            e.printStackTrace();
//            System.out.println("Connection failure.");
//            e.printStackTrace();
//        }
        return connection;
    }

}