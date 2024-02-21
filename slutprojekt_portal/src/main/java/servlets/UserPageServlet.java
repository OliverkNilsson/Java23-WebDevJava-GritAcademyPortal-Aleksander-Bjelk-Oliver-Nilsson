package servlets;

import org.example.slutprojekt_portal.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "/userpage", urlPatterns = "/userpage")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersBean usersBean = req.getSession().getAttribute("usersBean") != null ? (UsersBean) req.getSession().getAttribute("usersBean") : null;

        if (usersBean != null && usersBean.getUserType() == USER_TYPE.student && usersBean.getStateType() == STATE_TYPE.confirmed) {


            LinkedList<String[]> data = null;
            LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("allCoursesForStudent", ((UsersBean) req.getSession().getAttribute("usersBean")).getId());

            if (req.getParameter("studentSubmitButton") != null) {
                data = MySQLConnector.getConnector().selectQuery("courseDetails", req.getParameter("courseId"));
            } else {
                data = courses;
            }
            req.setAttribute("data", data);
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("JSPs/Userpage.jsp").forward(req, resp);


        } else if (usersBean != null && usersBean.getUserType() == USER_TYPE.teacher && usersBean.getPrivilageType() == PRIVILAGE_TYPE.user && usersBean.getStateType() == STATE_TYPE.confirmed) {
            LinkedList<String[]> data = null;
            LinkedList<String[]> data2 = null;
            LinkedList<String[]> students = MySQLConnector.getConnector().selectQuery("showAllFromStudents");
            LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("allCourses");


            if (req.getParameter("showCoursesForStudent") != null) {
                data = MySQLConnector.getConnector().selectQuery("allCoursesForStudentName", req.getParameter("studentName"));
            } else if (req.getParameter("studentSubmitButton") != null) {
                data2 = MySQLConnector.getConnector().selectQuery("courseDetails", req.getParameter("courseId"));
            } else {
                data = students;
                data2 = courses;
            }

            req.setAttribute("data", data);
            req.setAttribute("data2", data2);
            req.setAttribute("students", students);
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("JSPs/Userpage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("JSPs/LogIn.jsp").forward(req, resp);
        }
    }

}
