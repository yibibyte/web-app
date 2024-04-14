/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package servlets.users;

import dao.UserDAO;
import servlets.users.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@WebServlet("user/delete")
public class DeleteUser extends HttpServlet {
    private UserDAO userDAO;
    @Override
    public void init() {
        userDAO = new UserDaoImpl();
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        long id = 0;
        // Удаление пользователя
        boolean isDelete = false;
        try {
            isDelete = userDAO.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (isDelete) {
            resp.setStatus(SC_OK);
            // PrintWriter Ok
        } else {
            resp.setStatus(SC_NOT_FOUND);
            // PrintWriter No such user
        }
    }

}
