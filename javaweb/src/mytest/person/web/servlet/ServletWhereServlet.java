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

@WebServlet(name = "ServletWhereServlet")
public class ServletWhereServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int id= Integer.parseInt(request.getParameter("id"));
        Person person=new Person();
        person.setP_id(id);

        try {
            List<Person>list= PersonDao.selectWhere(person);
            request.setAttribute("list",list);
            request.getRequestDispatcher("/Mytest/show.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
