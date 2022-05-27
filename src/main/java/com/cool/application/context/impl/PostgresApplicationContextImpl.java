package com.cool.application.context.impl;

import com.cool.application.dao.UserDao;
import com.cool.application.dao.postgresimpl.UserDaoImpl;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.service.UserService;
import com.cool.application.service.postgresimpl.UserServiceImpl;
import com.cool.application.context.ApplicationContext;

public class PostgresApplicationContextImpl implements ApplicationContext {

    private final UserDao userDao;
    private final UserService userService;

    public PostgresApplicationContextImpl(DbConnectionProvider connectionProvider) {
        this.userDao = new UserDaoImpl(connectionProvider);
        this.userService = new UserServiceImpl(userDao);
    }

    public UserService getUserService() {
        return userService;
    }
}
