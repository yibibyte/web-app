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

@WebServlet("user/update")
public class UpdateUser extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Получение данных из запроса

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("first Name");
        String lastName = req.getParameter("last Name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");

        User updatedUser = new User();
        updatedUser.setUsername(username);
        updatedUser.setPassword(password);
        updatedUser.setFirstName(firstName);
        updatedUser.setLastName(lastName);
        updatedUser.setAge(age);
        updatedUser.setEmail(email);

        // Обновление пользователя
        userDAO.updateUser(updatedUser);

    }
}

