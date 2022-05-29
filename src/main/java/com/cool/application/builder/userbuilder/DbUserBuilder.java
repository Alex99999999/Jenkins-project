package com.cool.application.builder.userbuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUserBuilder extends AbstractUserBuilder {

  private ResultSet resultSet;

  public DbUserBuilder(ResultSet resultSet) throws SQLException {
    this.resultSet = resultSet;
    while (resultSet.next()) {
      id = resultSet.getLong("id");
      familyName = resultSet.getString("family_name");
      givenName = resultSet.getString("given_name");
      phoneNumber = resultSet.getString("phone_number");
      age = resultSet.getInt("age");
    }
  }

}
