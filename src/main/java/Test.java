import users.User;
import entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/kljlkjkl")
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try(Connection conn = DbUtil.getConnection()){
//            String query = "SELECT * FROM emails";
//            PreparedStatement statement = conn.prepareStatement(query);
//            ResultSet rs = statement.executeQuery();
//            while(rs.next()){
//                System.out.println(rs.getString("name"));
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }

            UserDao userDao = new UserDao();
            userDao.createUser(new User("Joanna","Joanna@gmail.com","kdifai4"));


    }
}