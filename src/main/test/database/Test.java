/**
 * FileName: Test
 * Author:   嘉平十七
 * Date:     2020/6/11 14:38
 * Description:
 * History:
 * notes：
 */
package main.test.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Menu.choose();
    }

}
class Menu{
    public static void choose() throws Exception{
        System.out.println("请选择：");
        System.out.println("1.数据更新");
        System.out.println("2.数据查询");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        switch (n){
            case 1:
                System.out.println("数据更新操作");
                updata();
                break;
            case 2:
                System.out.println("数据查询操作");
                select();
                break;
            default:
                break;
        }
    }
    public static void updata() throws Exception {
        //准备连接参数
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=Test";
        String name="sa";
        String password="123456";

        Connection connection=null;
        Statement statement=null;

        try {
            //加载驱动类
            Class.forName(driverName);
            //通过三个参数调用DriverManger的getConnection()方法，得到连接
            connection= DriverManager.getConnection(url,name,password);
            System.out.println("数据库连接成功");
            //通过createStatement()方法，得到Statement，执行sql语句
            statement=connection.createStatement();

//            String sql="delete from main where id=7 or id=9";
            String sql="insert into main values(8,'张三',100,'长沙','男',119)";
            System.out.println(statement.executeUpdate(sql));
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("数据库连接失败");
        }finally {
            try {
                if (statement!=null)
                    statement.close();
                if (connection!=null)
                    connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void select() throws Exception {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            /*得到连接*/
            String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url="jdbc:sqlserver://localhost:1433;DatabaseName=Test";
            String name="sa";
            String password="123456";
            Class.forName(driverName);
            connection= DriverManager.getConnection(url,name,password);
            /*创建Statement*/
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from main");
            System.out.println("数据库连接成功");
            /*循环遍历resultSet，打印其中数据*/
            //解析ResultSet
            while (resultSet.next()){
                //光标向下移动一行，判断是否存在
                int rid=resultSet.getInt(1);
                String rname=resultSet.getString(2);
                System.out.println("ID："+rid+"、姓名："+rname);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("数据库连接失败");
        }finally {
            try {
                if (resultSet!=null)
                    resultSet.close();
                if (statement!=null)
                    statement.close();
                if (connection!=null)
                    connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}