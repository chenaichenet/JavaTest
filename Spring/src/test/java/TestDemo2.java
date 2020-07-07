import com.demo2.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FileName: TestDemo2
 * Author:   嘉平十七
 * Date:     2020/7/7 10:34
 * Description: 基于注解的DI实现测试
 * History:
 * notes：
 */

public class TestDemo2 {
    ApplicationContext app=new ClassPathXmlApplicationContext("spring2.xml");
    @Test
    public void test(){
        Student student = (Student) app.getBean("student");
        System.out.println(student);
    }
}