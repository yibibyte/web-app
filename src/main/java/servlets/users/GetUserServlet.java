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

@WebServlet("user/get")
public class GetUserServlet extends HttpServlet {
    private UserDAO userDAO;
    @Override
    public void init() throws ServletException {
        userDAO = new UserDaoImpl();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        // Поиск по username, чтобы найти id вытащить его все данные о нем, то есть со всеми полями

        long id = 0;
        // Удаление пользователя
        try {
            userDAO.selectUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
