import com.dao.UserDao;
import com.impl.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FileName: TestDemo
 * Author:   嘉平十七
 * Date:     2020/7/5 19:19
 * Description:
 * History:
 * notes：
 */

public class TestDemo {
    @Test
    public void Test1(){
        ApplicationContext app=new ClassPathXmlApplicationContext("spring.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.see();
    }
    @Test
    /*set注入*/
    public void Test2(){
        ApplicationContext app=new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) app.getBean("student1");
        System.out.println(student);
    }
    @Test
    /*构造注入*/
    public void Test3(){
        ApplicationContext app=new ClassPathXmlApplicationContext("spring.xml");
        Student student=(Student) app.getBean("student2");
        System.out.println(student);
    }
}