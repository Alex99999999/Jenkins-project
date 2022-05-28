package com.cool.application.operations;

public enum UserOperations {
  UPDATE_USER("update_user"),

  CREATE_USER("create_user");


  private final String query;

  UserOperations(String query) {
    this.query = query;
  }

  public String getOperationName() {
    return query;
  }
}