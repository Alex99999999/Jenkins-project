package com.cool.application.db.postgres.queries.user;

import com.cool.application.db.Queries;
import com.cool.application.operations.UserOperations;

import java.util.HashMap;
import java.util.Map;

public class PostgresUserQueries implements Queries {

  private Map<String, String> queries;

  public PostgresUserQueries() {
    populateQueries();
  }

    private void populateQueries() {
        queries = new HashMap<>();
        queries.put(UserOperations.UPDATE_USER.getOperationName(), "UPDATE user SET family_name = ?,  given_name = ?, phone_number = ?, age = ? WHERE id = ?;");
        queries.put(UserOperations.GET_USER_BY_ID.getOperationName(), "SELECT * from user WHERE id = ?");
        queries.put(UserOperations.GET_USER_BY_NAME.getOperationName(), "SELECT * from user WHERE family_name = ?");
    }
  private void populateQueries() {
    queries = new HashMap<>();
    queries.put(UserOperations.UPDATE_USER.getOperationName(),
        "UPDATE user SET family_name = ?,  given_name = ?, phone_number = ?, age = ? WHERE id = ?;");
    queries.put(UserOperations.CREATE_USER.getOperationName(),
        "INSERT INTO user (id,family_name,given_name,phone_number, age) VALUES (?,?,?,?,?)");
  }

  public String getQuery(String key) {
    return queries.get(key);
  }

}