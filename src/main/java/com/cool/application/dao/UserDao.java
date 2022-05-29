package com.cool.application.dao;

import com.cool.application.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUsers();

    void deleteUser();

    User getUserById(long id);

    User getUserByName(String name);

    void updateUser(User user);

    void createUser(User user);
}
