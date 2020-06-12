/**
 * FileName: JdbcUtils
 * Author:   嘉平十七
 * Date:     2020/6/11 16:53
 * Description: JdbcUtils小工具
 * History:
 * notes：
 */
package main.test.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtils {
    private JdbcUtils(){}

    private static Properties pro=null;
    private static Connection con=null;
    //只在JDdbcUtils类被加载时执行一次
    static {
        //为pro进行初始化，即加载配置文件到pro对象中
        try {
            InputStream is=JdbcUtils.class.getClassLoader().getResourceAsStream("main/test/database/dbconfig.properties");
            pro=new Properties();
            pro.load(is);
            con= DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("name"),pro.getProperty("password"));
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            /*加载驱动*/
            Class.forName(pro.getProperty("driverName"));    //通过key得到values
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws Exception{
        /*得到Connection*/
        System.out.println("-----数据库连接成功-----");
        return con;
    }
    public static void close() throws Exception{
        if (con!=null){
            con.close();
        }
    }

    public static void main(String[] args) throws Exception{
        Connection connection=JdbcUtils.getConnection();
        System.out.println(connection);
    }
}