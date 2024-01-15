/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package servlets;

import entities.User;
import services.message.MessageManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Класс, содержащий логику использования MessageManager
 */
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MessageManager messageManager = new MessageManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String user = request.getParameter("user");
        String message = request.getParameter("message");

        if (action != null && user != null && message != null) {
            User currentUser = new User(user);

            if (action.equals("add")) {
                messageManager.executeOperation(currentUser, message, (u, msg) -> {
                    messageManager.addMessage(msg);
                });
            } else if (action.equals("edit")) {
                messageManager.executeOperation(currentUser, message, (u, msg) -> {
                    if (messageManager.containsMessage(msg)) {
                        messageManager.addMessage(msg + " (edited)");
                    }
                });
            } else if (action.equals("delete")) {
                messageManager.executeOperation(currentUser, message, (u, msg) -> {
                    messageManager.deleteMessage(msg);
                });
            }
        }

        displayMessages(response.getWriter());
    }

    private void displayMessages(PrintWriter writer) {
        List<String> messages = messageManager.getMessages();
        writer.println("<html><body>");
        writer.println("<h2>All Messages:</h2>");
        writer.println("<ul>");
        for (String msg : messages) {
            writer.println("<li>" + msg + "</li>");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }
}
