import com.demo4.dao.ClassmateDao;
import com.demo4.domain.Classmate;
import com.demo4.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
    @Test
    public void TestSelectAll() throws IOException {
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        ClassmateDao dao=sqlSession.getMapper(ClassmateDao.class);
        List<Classmate> classmates = dao.selectAll();
        classmates.forEach(classmate -> System.out.println(classmate));
    }
}