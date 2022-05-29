package com.cool.application.operations;

public enum UserOperations {

    UPDATE_USER("update_user"),
    GET_USER_BY_ID("get_user_by_id");

    private final String query;

    UserOperations(String query) {
        this.query = query;
    }

    public String getOperationName() {
        return query;
    }

}
