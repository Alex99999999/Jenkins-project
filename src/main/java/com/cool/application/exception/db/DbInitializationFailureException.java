package com.cool.application.exception.db;

public class DbInitializationFailureException extends RuntimeException {

    public DbInitializationFailureException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
