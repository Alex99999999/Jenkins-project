package com.cool.application.service.postgresimpl;

import com.cool.application.dao.UserDao;
import com.cool.application.db.postgres.queries.user.UserQueries;
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
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public void updateUser(User user) {
        sql = UserQueries.UPDATE_USER;
        userDao.updateUser(user, sql);
    }

}
