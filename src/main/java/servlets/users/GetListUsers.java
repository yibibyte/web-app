/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package servlets.users;

import dao.UserDAO;
import entities.User;
import servlets.users.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("user/getListUsers")
public class GetListUsers extends HttpServlet{
        private UserDAO userDAO;
        @Override
        public void init() throws ServletException {
            userDAO = new UserDaoImpl();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //List<User> userList = userDAO.getUsersList();
            //String userList = userDAO.getUsersList("all user");

            // Получение списка пользователей
//            userDAO.deleteUserdeleteUser(username);
            try {
                List<User> userList = userDAO.selectAllUsers();
//                resp.send
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
