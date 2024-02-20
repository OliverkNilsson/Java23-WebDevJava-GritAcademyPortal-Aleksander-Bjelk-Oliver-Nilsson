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

        UsersBean usersBean = req.getSession().getAttribute("usersBean") != null ? (UsersBean)req.getSession().getAttribute("usersBean") : null;

        System.out.println(usersBean);
        if (usersBean != null && usersBean.getUserType() == USER_TYPE.student && usersBean.getStateType() == STATE_TYPE.confirmed) {


            LinkedList<String[]> data = null;
            LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("allCoursesForStudent", ((UsersBean) req.getSession().getAttribute("usersBean")).getId());

            System.out.println(courses.size());
            if(req.getParameter("studentSubmitButton")!=null){
                data = MySQLConnector.getConnector().selectQuery("courseDetails",  req.getParameter("courseId"));
                System.out.println(data.size());
            }else {
                data = courses;
            }
            req.setAttribute("data", data);
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("JSPs/Userpage.jsp").forward(req, resp);

        }else if (usersBean != null && usersBean.getUserType() == USER_TYPE.teacher && usersBean.getPrivilageType()==PRIVILAGE_TYPE.user && usersBean.getStateType() == STATE_TYPE.confirmed) {
            LinkedList<String[]> data = null;
            LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("allCourses");

            System.out.println(courses.size());
            if(req.getParameter("studentSubmitButton")!=null){
                data = MySQLConnector.getConnector().selectQuery("courseDetails",  req.getParameter("courseId"));
                System.out.println(data.size());
            }else {
                data = courses;
            }

            req.setAttribute("data", data);
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("JSPs/Userpage.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("JSPs/LogIn.jsp").forward(req, resp);
        }
    }

    }
