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

@WebServlet("/user/add")
public class AddUserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDaoImpl();
    }           

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Получение данных из запроса
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("first Name");
        String lastName = req.getParameter("last Name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAge(age);
        newUser.setEmail(email);
        
    }
}