package mytest.person.web.servlet;

import mytest.person.dao.PersonDao;
import mytest.person.domain.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllServlet")
public class SelectAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        List<Person> list= null;
        try {
            list = PersonDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        request.getRequestDispatcher("/Mytest/show.jsp").forward(request,response);
    }
}
