/**
 * FileName: SqlSessionUtils
 * Author:   嘉平十七
 * Date:     2020/7/12 17:57
 * Description: 获取SqlSession
 * notes：
 */
package com.demo4.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
    private static SqlSessionFactory factory=null;
    static {

        try {
            InputStream inputStream= Resources.getResourceAsStream("mybatis.xml");
            factory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建SqlSessionFactory对象失败");
        }
    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if (factory!=null){
            sqlSession=factory.openSession();
        }
        return sqlSession;
    }
}