package users;

import entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/user/list")
public class UserList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        List<User> allUsers = Arrays.asList(userDao.findAll());
        req.setAttribute("allUsers", allUsers);
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(req,resp);
    }
}
