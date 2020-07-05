import com.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FileName: UserDaoTest
 * Author:   嘉平十七
 * Date:     2020/7/5 19:19
 * Description:
 * History:
 * notes：
 */

public class UserDaoTest {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("spring.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.see();
    }
}