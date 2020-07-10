import com.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * FileName: TestStudent
 * Author:   嘉平十七
 * Date:     2020/7/10 16:44
 * Description:
 * notes：
 */

public class TestStudent {
    public static void main(String[] args) throws IOException {
        /*访问mybatis读取student数据*/
        //定义mybatis主配置文件名称，从类路径的根开始（target/classes）
        String config="mybatis.xml";
        //读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=builder.build(in);
        //获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //指定要执行的sql语句，sql映射文件中的namespace+"."+标签id
        String sqlId="com.dao.student.StudentDao"+"."+"selectStudents";
        //指定sql
        List<Student> studentList = sqlSession.selectList(sqlId);
        //输出结果
        studentList.forEach(student -> System.out.println(student));
        //关闭SqlSession对象
        sqlSession.close();
    }
}