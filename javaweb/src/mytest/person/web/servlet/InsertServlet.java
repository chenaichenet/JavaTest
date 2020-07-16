package mytest.person.web.servlet;

import mytest.person.dao.PersonDao;
import mytest.person.domain.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int age= Integer.parseInt(request.getParameter("age"));
        String address=request.getParameter("address");

        Person person=new Person();
        person.setP_id(id);
        person.setP_name(name);
        person.setP_age(age);
        person.setP_address(address);

        try {
            PersonDao.Insret(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
