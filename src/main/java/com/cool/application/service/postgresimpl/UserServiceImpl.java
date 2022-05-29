package com.cool.application.service.postgresimpl;

import com.cool.application.dao.UserDao;
import com.cool.application.db.Queries;
import com.cool.application.operations.UserOperations;
import com.cool.application.entity.User;
import com.cool.application.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private String sql;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public void deleteUser() {
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

}
