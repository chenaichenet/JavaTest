import com.demo1.dao.UserDao;
import com.demo1.impl.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FileName: TestDemo1
 * Author:   嘉平十七
 * Date:     2020/7/5 19:19
 * Description: 对应demo1包下的文件
 * History:
 * notes：
 */

public class TestDemo1 {
    ApplicationContext app=new ClassPathXmlApplicationContext("spring1.xml");
    @Test
    public void Test(){
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.see();
    }
    @Test
    /*set注入*/
    public void Test1(){
        Student student1 = (Student) app.getBean("student1");
        System.out.println(student1);
    }
    @Test
    /*构造注入*/
    public void Test2(){
        Student student2=(Student) app.getBean("student2");
        System.out.println(student2);
    }
    @Test
    /*byNmae自动注入*/
    public void Test3(){
//        Student student3 = (Student) app.getBean("student3");   //byName
//        System.out.println(student3);
        Student student4 = (Student) app.getBean("student4");   //byType
        System.out.println(student4);
    }

}