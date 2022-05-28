package com.cool.application.dao.postgresimpl;

import com.cool.application.dao.UserDao;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.entity.User;
import com.cool.application.exception.user.UserCreateFailureException;
import com.cool.application.exception.user.UserNotFoundException;
import com.cool.application.exception.user.UserUpdateFailureException;
import com.cool.application.notifications.warnings.UserWarnings;
import com.cool.application.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final DbConnectionProvider connectionProvider;

    public UserDaoImpl(DbConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
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
    public void updateUser(User user, String sql) {
        Connection con = connectionProvider.getConnection();
        PreparedStatement stmt = null;
        long id = user.getId();
        isExist(id);
        try {
            stmt = con.prepareStatement(sql);
            int k = 0;
            stmt.setString(++k, DbUtils.escapeForPstmt(user.getFamilyName()));
            stmt.setString(++k, DbUtils.escapeForPstmt(user.getGivenName()));
            stmt.setString(++k, DbUtils.escapeForPstmt(user.getPhoneNumber()));
            stmt.setInt(++k, user.getAge());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new UserUpdateFailureException(String.format(UserWarnings.USER_UPDATE_FAILURE, id));
        } finally {
            DbUtils.close(stmt);
            DbUtils.close(con);
        }

    }

    @Override
    public void createUser(User user, String sql) {
        Connection con = connectionProvider.getConnection();
        PreparedStatement stmt = null;
        long id = user.getId();
        try {
            stmt = con.prepareStatement(sql);
            int k = 0;
            stmt.setLong(++k, user.getId());
            stmt.setString(++k, DbUtils.escapeForPstmt(user.getFamilyName()));
            stmt.setString(++k, DbUtils.escapeForPstmt(user.getGivenName()));
            stmt.setString(++k, DbUtils.escapeForPstmt(user.getPhoneNumber()));
            stmt.setInt(++k, user.getAge());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new UserCreateFailureException(String.format(UserWarnings.USER_CREATE_FAILURE, id));
        } finally {
            DbUtils.close(stmt);
            DbUtils.close(con);
        }

    }


    private void isExist(long id) {
        if (getUserById(id) == null) {
            throw new UserNotFoundException(String.format(UserWarnings.USER_NOT_FOUND, id));
        }
    }

}