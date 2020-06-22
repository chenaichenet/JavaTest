/**
 * FileName: JDBCDemo
 * Author:   嘉平十七
 * Date:     2020/6/11 9:41
 * Description: 最基础的数据库连接模板
 * History:
 * notes：
 */
package main.test.database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo {
    public static void main(String[] args) throws Exception{
        update();
    }
    public static void update() {
        Connection connection=null;
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=FrameUtils";//数据源  ！！！注意若出现加载或者连接数据库失败一般是这里出现问题
        String Name="sa";
        String Pwd="123456";
        try{
            Class.forName(driverName);
            connection=DriverManager.getConnection(dbURL,Name,Pwd);
            System.out.println("连接数据库成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("连接失败");
        }
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库关闭失败");
            connection=null;
        }
    }
}