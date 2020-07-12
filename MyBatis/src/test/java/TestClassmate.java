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
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: TestClassmate
 * Author:   嘉平十七
 * Date:     2020/7/10 18:07
 * Description: classmate数据库测试
 * notes：
 */

public class TestClassmate {
    SqlSession sqlSession=SqlSessionUtils.getSqlSession();//使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)，能获取dao接口对应的实现类对象
    ClassmateDao dao=sqlSession.getMapper(ClassmateDao.class);//创建ClassmateDao的实现类对象
    @Test
    public void Test1(){
        //基础
        String sqlId="com.dao.classmate.ClassmateDao.selectClassmates";

        List<Classmate> classmateList = sqlSession.selectList(sqlId);

        classmateList.forEach(classmate-> System.out.println(classmate));

        sqlSession.close();
    }
    @Test
    public void Test2(){
        //使用传统的Impl实现类
        List<Classmate> classmateList=dao.selectClassmates();
        classmateList.forEach(classmate -> System.out.println(classmate));
    }
    @Test
    public void Test3(){
        List<Classmate> classmateList = dao.selectClassmates();
        classmateList.forEach(classmate -> System.out.println(classmate));
    }

    @Test
    public void Test4(){
        String name="%王%";
        List<Classmate> classmateList = dao.selectLike(name);
        classmateList.forEach(classmate -> System.out.println(classmate));
    }

    @Test
    public void Test6(){
        //动态sql-if
        Classmate classmate=new Classmate();
        classmate.setAge(20);
        List<Classmate> classmateList=dao.selectIf(classmate);
        classmateList.forEach(classmate1 -> System.out.println(classmate1));
    }
    @Test
    public void Test7(){
        //动态sql-where
        Classmate classmate=new Classmate();
        classmate.setName("%王%");
        classmate.setAge(20);
        List<Classmate> classmateList = dao.selectWhere(classmate);
        classmateList.forEach(classmate1 -> System.out.println(classmate1));
    }
    @Test
    public void Test8(){
        //动态sql——foreach
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Classmate> classmateList = dao.selectForeach(list);
        classmateList.forEach(classmate -> System.out.println(classmate));
    }
    @Test
    public void Test9(){
        //动态sql——foreach
        List<Classmate> clslist=new ArrayList<>();
        Classmate classmate=new Classmate();
        classmate.setId(1);
        clslist.add(classmate);

        classmate=new Classmate();
        classmate.setId(2);
        clslist.add(classmate);

        List<Classmate> classmateList = dao.selectForeach2(clslist);
        classmateList.forEach(cla -> System.out.println(cla));
    }
    @Test
    public void Test10(){
        //动态sql，代码块
        List<Classmate> clslist=new ArrayList<>();
        Classmate classmate=new Classmate();
        classmate.setId(2);
        clslist.add(classmate);

        classmate=new Classmate();
        classmate.setId(3);
        clslist.add(classmate);

        List<Classmate> selectsql = dao.selectsql(clslist);
        selectsql.forEach(sel-> System.out.println(sel));
    }
}