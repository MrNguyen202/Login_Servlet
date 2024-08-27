/*
 * @ (#) Login.java    1.0    8/27/2024
 *
 *
 */

package hero.iuh.edu.vn.nguyenthanhthuan_21080071_loginservlet.controlls;
/*
 * @Description:
 * @Author: Nguyen Thanh Thuan
 * @Date: 8/27/2024
 * @Version: 1.0
 *
 */

import hero.iuh.edu.vn.nguyenthanhthuan_21080071_loginservlet.daos.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginservlet", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();

        PrintWriter out = resp.getWriter();

        if (userDAO.checkLogin(username, password)) {
            out.println("<h1>Login success</h1>");
        } else {
            out.println("<h1>Login fail</h1>");
        }
    }
}
