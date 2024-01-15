/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package dao;

import entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void saveUser(User user) throws SQLException;

    User selectUser(int id) throws SQLException;

    List<User> selectAllUsers() throws SQLException;

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
}
