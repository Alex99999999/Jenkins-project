package com.cool.application.service;

import com.cool.application.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    void deleteUser();

    User getUserById(long id);

    User getUserByFamilyName(String name);

    void updateUser(User user);

}
