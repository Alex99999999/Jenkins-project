package com.cool.application.db.postgres;

import com.cool.application.db.DbConnectionProvider;
import com.cool.application.exception.db.DbConnectionFailureException;
import com.cool.application.exception.db.DbInitializationFailureException;
import com.cool.application.notifications.warnings.DbWarnings;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PostgresDbConnectionProviderImpl implements DbConnectionProvider {

    private DataSource dataSource;

    @Override
    public Connection getConnection() {
        setupConnectionDetails();
        Connection con;
        try {
            con = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new DbConnectionFailureException(DbWarnings.DB_CONNECTION_FAILED, ex.getCause());
        }
        return con;
    }

    private void setupConnectionDetails() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/coolcatsDB");
        } catch (NamingException e) {
            throw new DbInitializationFailureException(DbWarnings.DATA_BASE_INIT_FAILED, e.getCause());
        }
    }

}
