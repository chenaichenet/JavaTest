import com.domain.Classmate;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
    public static void main(String[] args) throws IOException {

        SqlSession sqlSession=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml")).openSession();

        String sqlId="com.dao.classmate.ClassmateDao"+"."+"selectClassmates";

        List<Classmate> classmateList = sqlSession.selectList(sqlId);

        classmateList.forEach(classmate-> System.out.println(classmate));

        sqlSession.close();
    }
}