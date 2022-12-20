package users;

import entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class ShowUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User userToShow = userDao.read(req.getParameter("id"));
        req.setAttribute("userToShow", userToShow);
        getServletContext().getRequestDispatcher("/users/show.jsp").forward(req,resp);
    }
}
