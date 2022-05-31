package com.cool.application.dao.impl;

import com.cool.application.builder.userbuilder.DbUserBuilder;
import com.cool.application.dao.UserDao;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.db.Queries;
import com.cool.application.entity.User;
import com.cool.application.exception.db.DbException;
import com.cool.application.exception.user.*;
import com.cool.application.notifications.warnings.DbWarnings;
import com.cool.application.notifications.warnings.UserWarnings;
import com.cool.application.operations.UserOperations;
import com.cool.application.utils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
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
        Connection con;
        try {
            con = connectionProvider.getConnection();
        } catch (SQLException e) {
            throw new DbException(DbWarnings.NULLABLE_RESULT_SET);
        }

        if (con == null) {
            throw new DbException(DbWarnings.NULLABLE_RESULT_SET);
        }

        List<User> users = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = queries.getQuery(UserOperations.GET_ALL_USERS.getOperationName());
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs == null) {
                throw new DbException(DbWarnings.NULLABLE_RESULT_SET);
            }
            while (rs.next()) {
                User user = new DbUserBuilder(rs).buildUserWithAllFields();
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DbException(DbWarnings.NULLABLE_RESULT_SET);
        } finally {
            DbUtils.close(rs);
            DbUtils.close(stmt);
            DbUtils.close(con);
        }
        return users;
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByFamilyName(String name) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void createUser(User user) {

    }

//  @Override
//  public void deleteUser(long id) {
//    Connection con = connectionProvider.getConnection();
//    PreparedStatement pstmt = null;
//    isExist(id);
//    try {
//      String sql = queries.getQuery(UserOperations.DELETE_USER.getOperationName());
//      pstmt = con.prepareStatement(sql);
//      pstmt.setLong(1, id);
//      pstmt.executeUpdate();
//    } catch (SQLException e) {
//      throw new UserException(String.format(UserWarnings.USER_DELETE_FAILURE, id));
//    } finally {
//      DbUtils.close(pstmt);
//      DbUtils.close(con);
//    }
//  }
//
//  @Override
//  public User getUserById(long id) {
//    Connection con = connectionProvider.getConnection();
//    User user;
//    PreparedStatement pstmt = null;
//    ResultSet rs = null;
//    isExist(id);
//    try {
//      String sql = queries.getQuery(UserOperations.GET_USER_BY_ID.getOperationName());
//      pstmt = con.prepareStatement(sql);
//      pstmt.setLong(1, id);
//      rs = pstmt.executeQuery();
//      user = new DbUserBuilder(rs).buildUserWithAllFields();
//    } catch (SQLException e) {
//      throw new UserException(String.format(UserWarnings.USER_RETRIEVE_FAILURE, id));
//    } finally {
//      DbUtils.close(rs);
//      DbUtils.close(pstmt);
//      DbUtils.close(con);
//    }
//    return user;
//  }
//
//  @Override
//  public User getUserByFamilyName(String name) {
//    Connection con = connectionProvider.getConnection();
//    User user;
//    PreparedStatement pstmt = null;
//    ResultSet rs = null;
//    try {
//      String sql = queries.getQuery(UserOperations.GET_USER_BY_NAME.getOperationName());
//      pstmt = con.prepareStatement(sql);
//      pstmt.setString(1, name);
//      rs = pstmt.executeQuery();
//      if (rs == null) {
//        throw new UserException(String.format(UserWarnings.USER_BY_NAME_NOT_FOUND, name));
//      }
//      user = new DbUserBuilder(rs).buildUserWithAllFields();
//    } catch (SQLException e) {
//      throw new UserException(String.format(UserWarnings.USER_BY_NAME_NOT_FOUND, name));
//    } finally {
//      DbUtils.close(rs);
//      DbUtils.close(pstmt);
//      DbUtils.close(con);
//    }
//    return user;
//  }
//
//  @Override
//  public void updateUser(User user) {
//    Connection con = connectionProvider.getConnection();
//    PreparedStatement pstmt = null;
//    long id = user.getId();
//    isExist(id);
//    try {
//      String sql = queries.getQuery(UserOperations.UPDATE_USER.getOperationName());
//      pstmt = con.prepareStatement(sql);
//      int k = 0;
//      pstmt.setString(++k, DbUtils.escapeForPstmt(user.getFamilyName()));
//      pstmt.setString(++k, DbUtils.escapeForPstmt(user.getGivenName()));
//      pstmt.setString(++k, DbUtils.escapeForPstmt(user.getPhoneNumber()));
//      pstmt.setInt(++k, user.getAge());
//      pstmt.executeUpdate();
//    } catch (SQLException e) {
//      throw new UserException(String.format(UserWarnings.USER_UPDATE_FAILURE, id));
//    } finally {
//      DbUtils.close(pstmt);
//      DbUtils.close(con);
//    }
//  }
//
//  @Override
//  public void createUser(User user) {
//    Connection con = connectionProvider.getConnection();
//    PreparedStatement stmt = null;
//    try {
//      String sql = queries.getQuery(UserOperations.CREATE_USER.getOperationName());
//      stmt = con.prepareStatement(sql);
//      int k = 0;
//      stmt.setString(++k, DbUtils.escapeForPstmt(user.getFamilyName()));
//      stmt.setString(++k, DbUtils.escapeForPstmt(user.getGivenName()));
//      stmt.setString(++k, DbUtils.escapeForPstmt(user.getPhoneNumber()));
//      stmt.setInt(++k, user.getAge());
//      stmt.executeQuery();
//    } catch (SQLException e) {
//      throw new UserException(String.format(UserWarnings.USER_CREATE_FAILURE));
//    } finally {
//      DbUtils.close(stmt);
//      DbUtils.close(con);
//    }
//  }

    private void isExist(long id) {
        if (getUserById(id) == null) {
            throw new UserException(String.format(UserWarnings.USER_NOT_FOUND, id));
        }
    }

}
