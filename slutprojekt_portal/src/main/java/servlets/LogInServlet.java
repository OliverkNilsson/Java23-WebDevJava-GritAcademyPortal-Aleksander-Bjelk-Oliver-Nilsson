package servlets;

import org.example.slutprojekt_portal.models.MySQLConnector;
import org.example.slutprojekt_portal.models.STATE_TYPE;
import org.example.slutprojekt_portal.models.UsersBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name="/login", urlPatterns = "/login")
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
            List data = MySQLConnector.getConnector().selectQuery("studentLogin", username, password);

            if (data.size() > 1) {
                UsersBean usersBean = new UsersBean();
                usersBean.setStateType(STATE_TYPE.confirmed);

                req.getSession().setAttribute("usersBean", usersBean);
                req.getRequestDispatcher("JSPs/Userpage.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Invalid username or password");
                req.getRequestDispatcher("JSPs/LogIn.jsp").forward(req, resp);
            }


        } else if (userType.equals("teacher")) {
            List data = MySQLConnector.getConnector().selectQuery("teacherLogin", username, password);

            if (data.size() > 1) {
                UsersBean usersBean = new UsersBean();
                usersBean.setStateType(STATE_TYPE.confirmed);

                req.getSession().setAttribute("usersBean", usersBean);
                req.getRequestDispatcher("JSPs/Userpage.jsp").forward(req, resp);
            }else{
                req.setAttribute("errorMessage", "Invalid username or password");
                req.getRequestDispatcher("JSPs/LogIn.jsp").forward(req, resp);
            }

            //  resp.getWriter().print(username + " " + password + " " + userType);
        }
    }
}
