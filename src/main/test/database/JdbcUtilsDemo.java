/**
 * FileName: JdbcUtilsDemo
 * Author:   嘉平十七
 * Date:     2020/6/11 17:40
 * Description: JdbcUtils的使用
 * History:
 * notes：
 */
package main.test.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcUtilsDemo {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        switch (n){
            case 1:
                System.out.println("查询所有数据");
                selectAll();
                break;
            case 2:
                System.out.println("按条件查询");
                select();
                break;
            default:
                System.out.println("请输入1或2");
                break;
        }
    }
    public static void selectAll() throws Exception{
        String sql_1="select * from main";
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        Connection connection=null;
        Statement statement=null;

        connection=JdbcUtils.getConnection();
        statement=connection.createStatement();
        resultSet=statement.executeQuery(sql_1);

        while (resultSet.next()) {
            //光标向下移动一行，判断是否存在
            int rid=resultSet.getInt(1);
            String rname=resultSet.getString(2);
            int rage=resultSet.getInt(3);
            String raddress=resultSet.getString(4);
            String rsex=resultSet.getString(5);
            int rphone=resultSet.getInt(6);
            System.out.println("ID："+rid+"、姓名："+rname+"、年龄："+rage+"、地址："+raddress+"、性别："+rsex+"、手机号："+rphone);
        }
    }
    public static void select() throws Exception{
        String sql_2="select * from main where id=? or id=?";
        Connection con=null;
        Statement ste=null;
        PreparedStatement pre=null;
        ResultSet res=null;

        con=JdbcUtils.getConnection();
        ste=con.createStatement();
        pre=con.prepareStatement(sql_2);
        pre.setInt(1,1);
        pre.setInt(2,2);
        res=pre.executeQuery();

        while (res.next()){
            int rid=res.getInt(1);
            String rname=res.getString(2);
            int rage=res.getInt(3);
            String raddress=res.getString(4);
            String rsex=res.getString(5);
            int rphone=res.getInt(6);
            System.out.println("ID："+rid+"、姓名："+rname+"、年龄："+rage+"、地址："+raddress+"、性别："+rsex+"、手机号："+rphone);
        }
    }
}