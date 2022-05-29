package com.cool.application.dao.postgresimpl;

import com.cool.application.builder.userbuilder.DbUserBuilder;
import com.cool.application.builder.userbuilder.UserBuilder;
import com.cool.application.dao.UserDao;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.db.Queries;
import com.cool.application.db.postgres.queries.user.PostgresUserQueries;
import com.cool.application.entity.User;
import com.cool.application.exception.user.UserNotFoundException;
import com.cool.application.exception.user.UserRetrieveFailureException;
import com.cool.application.exception.user.UserUpdateFailureException;
import com.cool.application.notifications.warnings.UserWarnings;
import com.cool.application.operations.UserOperations;
import com.cool.application.utils.DbUtils;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final DbConnectionProvider connectionProvider;
    private final Queries queries;

    public UserDaoImpl(DbConnectionProvider connectionProvider, Queries queries) {
        this.connectionProvider = connectionProvider;
        this.queries = queries;
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
        Connection con = connectionProvider.getConnection();
        User user;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        isExist(id);
        try {
            String sql = queries.getQuery(UserOperations.GET_USER_BY_ID.getOperationName());
            pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            user = new DbUserBuilder(rs).buildUserWithAllFields();
        } catch (SQLException e) {
            throw new UserRetrieveFailureException(String.format(UserWarnings.USER_RETRIEVE_FAILURE, id));
        } finally {
            DbUtils.close(rs);
            DbUtils.close(pstmt);
            DbUtils.close(con);
        }
        return user;
    }

    @Override
    public User getUserByFamilyName(String name) {
        Connection con = connectionProvider.getConnection();
        User user;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = queries.getQuery(UserOperations.GET_USER_BY_NAME.getOperationName());
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs == null) {
                throw new UserNotFoundException(String.format(UserWarnings.USER_BY_NAME_NOT_FOUND, name));
            }
            user = new DbUserBuilder(rs).buildUserWithAllFields();
        } catch (SQLException e) {
            throw new UserRetrieveFailureException(String.format(UserWarnings.USER_BY_NAME_NOT_FOUND, name));
        } finally {
            DbUtils.close(rs);
            DbUtils.close(pstmt);
            DbUtils.close(con);
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        Connection con = connectionProvider.getConnection();
        PreparedStatement pstmt = null;
        long id = user.getId();
        isExist(id);
        try {
            String sql = queries.getQuery(UserOperations.UPDATE_USER.getOperationName());
            pstmt = con.prepareStatement(sql);
            int k = 0;
            pstmt.setString(++k, DbUtils.escapeForPstmt(user.getFamilyName()));
            pstmt.setString(++k, DbUtils.escapeForPstmt(user.getGivenName()));
            pstmt.setString(++k, DbUtils.escapeForPstmt(user.getPhoneNumber()));
            pstmt.setInt(++k, user.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new UserUpdateFailureException(String.format(UserWarnings.USER_UPDATE_FAILURE, id));
        } finally {
            DbUtils.close(pstmt);
            DbUtils.close(con);
        }
    }

    private void isExist(long id) {
        if (getUserById(id) == null) {
            throw new UserNotFoundException(String.format(UserWarnings.USER_NOT_FOUND, id));
        }
    }
}
