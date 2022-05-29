package com.cool.application.exception.db;

public class DbConnectionFailureException extends RuntimeException {

    public DbConnectionFailureException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
