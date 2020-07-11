/**
 * FileName: SqlSessionUtils
 * Author:   嘉平十七
 * Date:     2020/7/11 8:28
 * Description: 获取SqlSession对象
 * notes：
 */
package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
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
}