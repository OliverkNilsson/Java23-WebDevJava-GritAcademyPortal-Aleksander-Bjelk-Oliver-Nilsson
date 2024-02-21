package servlets;

import com.google.protobuf.StringValue;
import org.example.slutprojekt_portal.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "/login", urlPatterns = "/login")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("JSPs/LogIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/HTML");


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("user_type");

        if (userType.equals("student")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("studentLogin", username, password);

            if (data.size() > 1) {
                UsersBean usersBean = new UsersBean();
                usersBean.setId(data.get(1)[0]);
                usersBean.setStateType(STATE_TYPE.confirmed);
                usersBean.setUserType(USER_TYPE.student);

                req.getSession().setAttribute("usersBean", usersBean);
                req.getRequestDispatcher("/userpage").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Invalid username or password");
                req.getRequestDispatcher("JSPs/LogIn.jsp").forward(req, resp);
            }


        } else if (userType.equals("teacher")) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("teacherLogin", username, password);
            if (data.size() > 1) {
                UsersBean usersBean = new UsersBean();
                usersBean.setId(data.get(1)[0]);
                usersBean.setUserPrivilage(PRIVILAGE_TYPE.valueOf(data.get(1)[8]));
                usersBean.setStateType(STATE_TYPE.confirmed);
                usersBean.setUserType(USER_TYPE.teacher);

                req.getSession().setAttribute("usersBean", usersBean);
                req.getRequestDispatcher("/userpage").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Invalid username or password");
                req.getRequestDispatcher("JSPs/LogIn.jsp").forward(req, resp);
            }

            //  resp.getWriter().print(username + " " + password + " " + userType);
        }
    }
}
