import com.demo4.dao.ClassmateDao;
import com.demo4.domain.Classmate;
import com.demo4.service.ClassmateService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * FileName: TestDemo4
 * Author:   嘉平十七
 * Date:     2020/7/12 17:55
 * Description: spring集成mybatis
 * notes：
 */

public class TestDemo4 {
    ApplicationContext app=new ClassPathXmlApplicationContext("spring4.xml");
    @Test
    public void Test(){
        //获取容器中对象的名称
        String names[]=app.getBeanDefinitionNames();
        for (String name:names){
            System.out.println("容器中的对象名称："+name+"，对象本体："+app.getBean(name).getClass().getName());
        }
    }
    /*测试spring容器创建的dao对象
    * 其创建过程：首先创建dataSource，通过连接池创建连接信息
    * 然后通过SqlSessionFactoryBean类创建sqlSessionFactory对象，把连接信息和mybatis配置文件也使用set注入方式注入
    * 然后创建dao对象，指定sqlSessionFactory对象和包名
    * 至此，接口对象完成，这里相当于完成了MyBatis中的，ClassmateDao dao=sqlSession.getMapper(ClassmateDao.class);*/
    @Test
    public void TestSelectAll() throws IOException {
        ClassmateDao dao = (ClassmateDao) app.getBean("classmateDao");
        List<Classmate> classmateList = dao.selectAll();
        classmateList.forEach(classmate -> System.out.println(classmate));
    }
    @Test
    public void TestSelectWhere(){
        ClassmateDao dao = (ClassmateDao) app.getBean("classmateDao");
        Classmate classmate = (Classmate) app.getBean("classmate");
        List<Classmate> classmateList = dao.selectWhere(classmate);
        classmateList.forEach(classmate1 -> System.out.println(classmate1));
    }
    /*在上面的基础上创建service对象，指定dao对象为属性*/
    @Test
    public void TestSqueryAll(){
        ClassmateService classmateService = (ClassmateService) app.getBean("classmateService");
        List<Classmate> classmateList = classmateService.squeryAll();
        classmateList.forEach(classmate1 -> System.out.println(classmate1));
    }
    //@Transactional  //事务注解全默认值
    @Test
    public void TestSqueryWhere(){
        ClassmateService classmateService = (ClassmateService) app.getBean("classmateService");
        Classmate classmate=(Classmate) app.getBean("classmate");
        List<Classmate> classmateList = classmateService.squeryWhere(classmate);
        classmateList.forEach(classmate1 -> System.out.println(classmate1));
    }
    @Test
    public void TestInsert(){
        ClassmateService classmateService = (ClassmateService) app.getBean("classmateService");
        Classmate classmate=new Classmate(100,"测试",100,"地址","性别",1100);
        int num = classmateService.insert(classmate);
        System.out.println(num);
    }
}