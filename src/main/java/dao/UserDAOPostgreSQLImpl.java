/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package dao;

import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOPostgreSQLImpl implements UserDAO{
    private Connection connection;

    public UserDAOPostgreSQLImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            User user = new User();
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setAge(resultSet.getInt("age"));
            user.setPassword(resultSet.getString("password"));

            users.add(user);
        }

        return users;
    }

    @Override
    public User selectUser(long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            User user = new User();
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setAge(resultSet.getInt("age"));
            user.setPassword(resultSet.getString("password"));
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void saveUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, email, first_name, last_name, age, password) VALUES (?, ?, ?, ?, ?, ?)");
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getFirstName());
        statement.setString(4, user.getLastName());
        statement.setInt(5, user.getAge());
        statement.setString(6, user.getPassword());
        statement.executeUpdate();
    }


    @Override
    public boolean deleteUser(long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
        statement.setLong(1, id);
        int affectedRows = statement.executeUpdate();
        return affectedRows > 0;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE users SET username = ?, email = ?, first_name = ?, last_name = ?, age = ?, password = ? WHERE id = ?");
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getFirstName());
        statement.setString(4, user.getLastName());
        statement.setInt(5, user.getAge());
        statement.setString(6, user.getPassword());
        statement.setLong(7, user.getId());         ////////////////////////// ????????
        int affectedRows = statement.executeUpdate();
        return affectedRows > 0;
    }

}
