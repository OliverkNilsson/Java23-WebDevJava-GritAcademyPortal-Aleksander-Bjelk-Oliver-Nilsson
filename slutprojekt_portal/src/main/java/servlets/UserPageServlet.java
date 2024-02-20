package servlets;

import org.example.slutprojekt_portal.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name="/userpage", urlPatterns = "/userpage")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersBean userBean = req.getSession().getAttribute("userBean") != null ? (UsersBean)req.getSession().getAttribute("userBean") : null;

        if (userBean != null && userBean.getUserType() == USER_TYPE.student && userBean.getStateType() == STATE_TYPE.confirmed) {


            LinkedList<String[]> data = null;
            LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("allCoursesForStudent", ((UsersBean) req.getSession().getAttribute("userBean")).getId());

            if(req.getParameter("studentSubmitButton")!=null){
                data = MySQLConnector.getConnector().selectQuery("courseDetails",  req.getParameter("courseId"));

            }else {
                data = courses;
            }
            req.setAttribute("data", data);
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("JSPs/UserPage.jsp").forward(req, resp);

        }else if (userBean != null && userBean.getUserType() == USER_TYPE.teacher && userBean.getPrivilageType()==PRIVILAGE_TYPE.user && userBean.getStateType() == STATE_TYPE.confirmed) {
            req.getRequestDispatcher("JSPs/UserPage.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("JSPs/LogIn.jsp").forward(req, resp);
        }
    }

    }
