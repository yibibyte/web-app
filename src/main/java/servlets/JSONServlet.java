/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsonServlet")
// TODO add logic for transfer JSON

public class JSONServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Получение параметра из формы
        String username = request.getParameter("username");

        // Действия с данными...

        // Отправка ответа клиенту
        response.getWriter().write("Hello, " + username + "!");

    }
}
