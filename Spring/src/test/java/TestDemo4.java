import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * FileName: TestDemo4
 * Author:   嘉平十七
 * Date:     2020/7/12 17:55
 * Description: spring集成mybatis
 * notes：
 */

public class TestDemo4 {
    public static SqlSession getSqlSession(){
        try {
            InputStream inputStream= Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(inputStream);
            SqlSession sqlSession=factory.openSession();
            System.out.println("创建SqlSession对象成功");
            return sqlSession;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建SqlSession对象失败");
            return null;
        }
    }

    public static void main(String[] args) {
        getSqlSession();
    }
}