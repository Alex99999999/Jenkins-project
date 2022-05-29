package com.cool.application.context.impl;

import com.cool.application.dao.UserDao;
import com.cool.application.dao.postgresimpl.UserDaoImpl;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.db.Queries;
import com.cool.application.db.postgres.queries.user.PostgresUserQueries;
import com.cool.application.service.UserService;
import com.cool.application.service.postgresimpl.UserServiceImpl;
import com.cool.application.context.ApplicationContext;

public class PostgresApplicationContextImpl implements ApplicationContext {

    private final Queries postgresUserQueries;
    private final UserDao userDao;
    private final UserService userService;

    public PostgresApplicationContextImpl(DbConnectionProvider connectionProvider) {
        this.postgresUserQueries = new PostgresUserQueries();
        this.userDao = new UserDaoImpl(connectionProvider);
        this.userService = new UserServiceImpl(userDao, postgresUserQueries);
    }

    public UserService getUserService() {
        return userService;
    }

}
