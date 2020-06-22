/**
 * FileName: PreparedStatementDemo
 * Author:   嘉平十七
 * Date:     2020/6/11 16:21
 * Description:
 * History:
 * notes：
 */
package main.test.database;

import java.sql.*;

public class PreparedStatementDemo {
    public static boolean login(int userID,String username) throws Exception{
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url="jdbc:sqlserver://localhost:1433;DatabaseName=FrameUtils";
            String name="sa";
            String password="123456";

            Class.forName(driverName);

            connection= DriverManager.getConnection(url,name,password);
            statement=connection.createStatement();
            /*得到PreparedStatement
            * 1.给出sql模板，用？代替
            * 2.调用Connection方法，得到PreparedStatement*/
            String sql="select * from main where id=? and name=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            /*为参数赋值*/
            preparedStatement.setInt(1,userID);
            preparedStatement.setString(2,username);

            System.out.println(sql);
            resultSet=preparedStatement.executeQuery(); //调用查询方法，向数据库发送查询语句
            return resultSet.next();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (connection!=null)
                    connection.close();
                if (statement!=null)
                    statement.close();
                if (resultSet!=null)
                    resultSet.close();
            }catch (Exception e){
                throw e;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception{
        int userID=1;
        String username="陈七";
        boolean bool=login(userID,username);
        System.out.println(bool);
    }
}