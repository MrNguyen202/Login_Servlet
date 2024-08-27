/*
 * @ (#) UserDAO.java    1.0    8/27/2024
 *
 *
 */

package hero.iuh.edu.vn.nguyenthanhthuan_21080071_loginservlet.daos;
/*
 * @Description:
 * @Author: Nguyen Thanh Thuan
 * @Date: 8/27/2024
 * @Version: 1.0
 *
 */

import hero.iuh.edu.vn.nguyenthanhthuan_21080071_loginservlet.conect.ConectDB;
import hero.iuh.edu.vn.nguyenthanhthuan_21080071_loginservlet.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public boolean checkLogin(String username, String password) {
        try {
            User user = new User();
            String sql = "SELECT * FROM user WHERE user_name = ? AND password = ?";
            connection = new ConectDB().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setUsername(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
            }
            if (user.getUsername() != null && user.getPassword() != null) {
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
