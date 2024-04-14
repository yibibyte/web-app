package servlets.users.impl;

import dao.UserDAO;
import entities.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDAO {

    @Override
    public void saveUser(User user) throws SQLException {
        // save User


    }

    @Override
    public User selectUser(long id) throws SQLException {
        //select User



        return null;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        //  select All Users


        return null;
    }


    @Override
    public boolean deleteUser(long id) throws SQLException {
        return true;
    }


    @Override
    public boolean updateUser(User user) throws SQLException {
        return true;
    }
}
