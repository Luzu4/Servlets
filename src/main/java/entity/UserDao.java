package entity;

import org.mindrot.jbcrypt.BCrypt;
import users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UserDao {

    private static final String CREATE_USER_QUERY = "insert into users(userName, email, password) values (?, ?, ?)";
    private static final String READ_USER_QUERY = "select * from users where id=? or email=?";
    private static final String UPDATE_USER = "update users set username=?, email=?, password=? where id=?";
    private static final String DELETE_USER = "delete from users where id=?";

    public void createUser(User user){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getEmail());
            statement.setString(3,hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                long id = resultSet.getLong(1);
                System.out.println("ID of created user:   " + + id);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User read(Object idOrMail){

        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(READ_USER_QUERY);
            statement.setObject(1, idOrMail);
            statement.setObject(2, idOrMail);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                System.out.println("Found: " + "\nID: " + rs.getString("id") + "\nName: " + rs.getString("username") + "\nEmail: " + rs.getString("email"));
                User user = new User(rs.getString("username"), rs.getString("email"),rs.getString("password"));
                user.setId(rs.getInt("id"));
                return user;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void update(User user){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(UPDATE_USER);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getEmail());
            statement.setString(3,hashPassword(user.getPassword()));
            statement.setInt(4,user.getId());
            int result = statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int userId){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(DELETE_USER);
            statement.setInt(1,userId);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public User[] findAll(){
        User[] users= new User[0];
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement("select * from users");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                User nextUser = new User(resultSet.getString("username"),resultSet.getString("email"),resultSet.getString("password"));
                nextUser.setId(resultSet.getInt("id"));
                users=addToArray(nextUser,users);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public User[] addToArray(User u, User[] users){
        User[] tmpUsers = Arrays.copyOf(users,users.length+1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }

}
