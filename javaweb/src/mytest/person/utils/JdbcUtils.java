/**
 * FileName: JdbcUtils
 * Author:   嘉平十七
 * Date:     2020/6/29 17:58
 * Description: JDBC工具类
 * History:
 * notes：
 */
package mytest.person.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    public static Connection getConnection() throws Exception{
        Connection con=null;
        Properties properties=null;

        InputStream is= JdbcUtils.class.getClassLoader().getResourceAsStream("mytest/person/utils/dbconfig.properties");
        properties =new Properties();
        properties.load(is);

        Class.forName(properties.getProperty("driverName"));
        con= DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("name"), properties.getProperty("password"));
        System.out.println("数据库连接成功");
        return con;
    }

    public static void close(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement preparedStatement){
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}