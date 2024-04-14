/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package dao;

import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOMysqlImpl implements UserDAO{
    private Connection connection;

    public UserDAOMysqlImpl(Connection connection) {
        this.connection = connection;
    }
    private String jdbcURL = "jdbc:post://localhost:3306/user_manager?useUnicode=yes&characterEncoding=UTF-8";
//    private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

//    private String jdbcDriver = "com.mysql.jdbc.Driver";
//
//    private static final String INSERT_USER_SQL = "INSERT INTO users (name, email) VALUES (?, ?, ?);";
//    private static final String SELECT_USER_BY_ID = "select id,name,email from users where id=?";
//    private static final String SELECT_ALL_USERS = "select * from users";
//    private static final String DELETE_USERS_SQL = "delete from users  where id=?";
//    private static final String UPDATE_USERS_SQL = "update users set username=?, email=?, where id=?";


    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email) VALUES " +
            " (?, ?, ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


//    public void insertUser(User user) throws SQLException {
//        System.out.println(INSERT_USERS_SQL);
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getEmail());
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//    }


    /**
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public User selectUser(long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        statement.setLong(1, id);
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

    /**
     * @param user
     * @throws SQLException
     */
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
    public List<User> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query

            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getInt("id");
                String username = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int age = Integer.parseInt(rs.getString("age"));
                String password = rs.getString("password");


                users.add(new User(username, firstName, lastName, age, password, email, country, id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(long id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
