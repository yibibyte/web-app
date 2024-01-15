/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/jsonServlet2")
// TODO add logic for transfer JSON

public class JSONServlet2 extends HttpServlet {
    /**
     *
     */
    public JSONServlet2() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Получение JSON из тела запроса
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }

        // Преобразование JSON в объект, если необходимо

        ObjectMapper objectMapper = new ObjectMapper();
        User myObject = objectMapper.readValue(jsonBuilder.toString(), User.class);

        // Другие действия с данными...

        // Отправка ответа клиенту
        response.getWriter().write("Hello, " + myObject.getUsername() + "!");
    }

}
