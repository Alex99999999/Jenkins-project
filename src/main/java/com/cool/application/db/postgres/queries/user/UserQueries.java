package com.cool.application.db.postgres.queries.user;

public class UserQueries {

    private UserQueries(){};

    public static final String UPDATE_USER = "UPDATE user SET family_name = ?,  given_name = ?, phone_number = ?, age = ? WHERE id = ?;";

}
