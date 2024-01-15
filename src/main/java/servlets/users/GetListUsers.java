/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package servlets.users;

import dao.UserDAO;
import entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("user/getListUsers")
public class GetListUsers extends HttpServlet{
        private UserDAO userDAO;
        @Override
        public void init() throws ServletException {
            userDAO = new UserDAO();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //List<User> userList = userDAO.getUsersList();
            //String userList = userDAO.getUsersList("all user");

            // Удаление пользователя
//            userDAO.deleteUserdeleteUser(username);
            userDAO.getUsersList(username);
            List<User> userList = userDAO.getUsersList();

        }
}
