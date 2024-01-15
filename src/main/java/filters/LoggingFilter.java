/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package filters;

import entities.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoggingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Инициализация фильтра
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Логика фильтра перед обработкой запроса

        // Получаем информацию о пользователе из заголовков запроса
        User currentUser = getUserFromHeaders(request);

        // Логируем информацию о запросе
        logRequestInfo(request, currentUser);

        // Вызываем doFilter(), чтобы передать управление следующему фильтру или сервлету
        chain.doFilter(request, response);

        // Логируем информацию о ответе
        logResponseInfo(response, currentUser);

        // Логика фильтра после обработки запроса
    }

    public void destroy() {
        // Очистка ресурсов фильтра
    }

    private User getUserFromHeaders(HttpServletRequest request) {
        // Логика извлечения информации о пользователе из заголовков запроса
        // В этом примере просто создадим фиктивного пользователя
        return new User("JohnDoe", "john.doe@example.com");
    }

    private void logRequestInfo(HttpServletRequest request, User user) {
        // Логика логирования информации о запросе
        System.out.println("Received request:");
        System.out.println("URL: " + request.getRequestURL());
        System.out.println("Method: " + request.getMethod());
        System.out.println("User: " + user.getUsername() + " (" + user.getEmail() + ")");
        // Добавьте другие необходимые логи
    }

    private void logResponseInfo(HttpServletResponse response, User user) {
        // Логика логирования информации о ответе
        System.out.println("Sent response:");
        System.out.println("Status: " + response.getStatus());
        System.out.println("User: " + user.getUsername() + " (" + user.getEmail() + ")");
        // Добавьте другие необходимые логи
    }
}

