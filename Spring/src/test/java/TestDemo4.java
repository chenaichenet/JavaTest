import com.alibaba.druid.pool.DruidDataSource;
import com.demo4.dao.ClassmateDao;
import com.demo4.domain.Classmate;
import com.demo4.service.ClassmateService;
import com.demo4.service.impl.ClassmateServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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

    /**
     * 使用JdbcTemplate，这里提供了方法模板，可以不用自定义操作方法
     * 可以把注意力放在sql语句的拼接上
     */
    @Test
    public void testjdbcTemplate(){
        //使用spring中定义的数据源，这样的方法，虽然可行，但是，在多种操作时，会出现反复为 jdbcTemplate.setDataSource(dataSource);
        //可以采用配置文件方式，在spring配置文件中，把数据源作为对象属性，赋值给对象
        DruidDataSource dataSource = (DruidDataSource) app.getBean("dataSource");
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        int num = jdbcTemplate.update("insert into classmate values (?,?,?,?,?,?)", "1002", "Test2", "102", "Address2", "male", "10021002");
        System.out.println(num);
    }

    /**
     * 在spring4.xml中，新建bean
     *     <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
     *         <property name="dataSource" ref="dataSource"/>
     *     </bean>
     */
    @Test
    public void testjdbcTemplate2(){
        //一句话搞定
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        /*查询所有*/
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from classmate");
        List<Classmate> list = jdbcTemplate.query("select * from classmate", new BeanPropertyRowMapper<Classmate>(Classmate.class));
        list.forEach(classmate -> System.out.println(classmate));
        /*条件查询*/
        Classmate classmate = jdbcTemplate.queryForObject("select * from classmate where id=?", new BeanPropertyRowMapper<Classmate>(Classmate.class), "1");
        System.out.println(classmate);
        /*聚合查询*/
        Long aLong = jdbcTemplate.queryForObject("select count(*) from classmate", Long.class);
        System.out.println("总数："+aLong);
    }
}