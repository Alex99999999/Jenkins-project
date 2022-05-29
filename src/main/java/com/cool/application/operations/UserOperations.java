package com.cool.application.operations;

public enum UserOperations {
    UPDATE_USER("update_user"),
    GET_USER_BY_ID("get_user_by_id"),
    GET_USER_BY_NAME("get_user_by_name"),
    CREATE_USER("create_user");

  private final String query;

  UserOperations(String query) {
    this.query = query;
  }

  public String getOperationName() {
    return query;
  }

}