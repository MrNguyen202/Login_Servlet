/*
 * @ (#) ConectDB.java    1.0    8/27/2024
 *
 *
 */

package hero.iuh.edu.vn.nguyenthanhthuan_21080071_loginservlet.conect;
/*
 * @Description:
 * @Author: Nguyen Thanh Thuan
 * @Date: 8/27/2024
 * @Version: 1.0
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectDB {
    private Connection connection;

    public ConectDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginservlet", "root", "sapassword");
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}
