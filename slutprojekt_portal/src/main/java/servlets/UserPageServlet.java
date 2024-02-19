package servlets;

import org.example.slutprojekt_portal.models.PRIVILAGE_TYPE;

import org.example.slutprojekt_portal.models.MySQLConnector;

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

        String username = (String) req.getSession().getAttribute("username");


        System.out.println("Användarnamn: " + username);

        LinkedList<String[]> studentCourses = MySQLConnector.getConnector().selectQuery("allCoursesForStudentAndStudentsAndTeachers", username);

        req.setAttribute("studentCourses", studentCourses);
        req.getRequestDispatcher("JSPs/Userpage.jsp").forward(req, resp);
    }
}
