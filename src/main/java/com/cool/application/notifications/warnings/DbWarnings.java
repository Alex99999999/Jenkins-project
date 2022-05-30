package com.cool.application.notifications.warnings;

public final class DbWarnings {

    private DbWarnings(){}

    public static final String NAME_IS_NULL_OR_EMPTY = "Family name and given name may not be null or empty";
    public static final String AGE_MUST_BE_ZERO_OR_GREATER = "User age should be and greater";
    public static final String USER_NOT_FOUND = "User not found. ID = %d";
    public static final String USER_UPDATE_FAILURE = "User update failed. ID = %d";
    public static final String USER_CREATE_FAILURE = "User create failed. ID = %d";
    public static final String USER_RETRIEVE_FAILURE = "Failed to retrieve user from DB. ID = %d";
    public static final String USER_BY_NAME_NOT_FOUND = "User not found. Name = %s";
    public static final String NULLABLE_RESULT_SET = "Result Set is Nullable.";
    public static final String FAILED_TO_CLOSE_RESOURCE = "Failed to close resource %s";
    public static final String DATA_BASE_INIT_FAILED = "Data base failed to startup";
    public static final String DB_CONNECTION_FAILED = "Failed to connect to DB";
    public static final String INITIAL_CONTEXT_IS_NULL = "Initial context is null";
}
