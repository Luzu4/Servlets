package users;

import entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/edit")
public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User userToEdit = userDao.read(req.getParameter("id"));
        req.setAttribute("userToEdit", userToEdit);
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User userToEdit = userDao.read(req.getParameter("email"));
        userToEdit.setUserName(req.getParameter("name"));
        userToEdit.setEmail(req.getParameter("email"));
        userToEdit.setPassword(req.getParameter("password"));
        userDao.update(userToEdit);
        resp.sendRedirect("/user/list");
    }
}
