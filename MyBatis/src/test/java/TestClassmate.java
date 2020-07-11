import com.dao.classmate.ClassmateDao;
import com.dao.classmate.ClassmateDaoImpl;
import com.domain.Classmate;
import com.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * FileName: TestClassmate
 * Author:   嘉平十七
 * Date:     2020/7/10 18:07
 * Description: classmate数据库测试
 * notes：
 */

public class TestClassmate {
    @Test
    public void Test1(){
        //基础
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        String sqlId="com.dao.classmate.ClassmateDao.selectClassmates";

        List<Classmate> classmateList = sqlSession.selectList(sqlId);

        classmateList.forEach(classmate-> System.out.println(classmate));

        sqlSession.close();
    }
    @Test
    public void Test2(){
        //使用传统的Impl实现类
        ClassmateDao classmateDao=new ClassmateDaoImpl();
        List<Classmate> classmateList=classmateDao.selectClassmates();
        classmateList.forEach(classmate -> System.out.println(classmate));
    }
    @Test
    public void Test3(){
        //使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)，能获取dao接口对应的实现类对象
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        ClassmateDao classmateDao=sqlSession.getMapper(ClassmateDao.class); //创建ClassmateDao的实现类对象
        List<Classmate> classmateList = classmateDao.selectClassmates();
        classmateList.forEach(classmate -> System.out.println(classmate));
    }
}