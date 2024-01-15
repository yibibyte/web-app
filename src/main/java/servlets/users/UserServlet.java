/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package servlets.users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Просто отправим ответ обратно клиенту
        response.getWriter().println("Данные пользователя");
    }
}
