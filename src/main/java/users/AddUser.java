package users;

import entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class AddUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("name");
        req.getParameter("email");
        req.getParameter("password");
        User newUser = new User(req.getParameter("name"), req.getParameter("email"), req.getParameter("password"));
        UserDao userDao = new UserDao();
        userDao.createUser(newUser);
        resp.sendRedirect("/user/list");
    }
}
