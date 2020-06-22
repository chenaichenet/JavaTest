/**
 * FileName: AllTestDemo
 * Author:   嘉平十七
 * Date:     2020/6/12 8:10
 * Description: 测试总和
 * History:
 * notes：
 */
package cn.test.demo;

import main.test.database.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AllTestDemo {
    public static void main(String[] args) throws Exception{
        Menus menus=new Menus();
        menus.choose();
    }
}

class Menus{
    private void Menu(){}

    public ResultSet resultSet=null;
    public PreparedStatement preparedStatement=null;
    public Connection connection=null;
    public Statement statement=null;
    public void getConnection() throws Exception{
        connection=JdbcUtils.getConnection();
        statement=connection.createStatement();
    }

    public void choose() throws Exception {
        Scanner sc=new Scanner(System.in);
        SelectDatabase select=new SelectDatabase();
        UpdataDatabase updata=new UpdataDatabase();
        System.out.println("功能选择：");
        System.out.println("1.查询所有");
        System.out.println("2.按条件查询");
        System.out.println("3.插入数据");
        System.out.println("4.更新数据");
        System.out.println("5.删除数据");
        System.out.println("6.事务处理");
        System.out.println("0.结束程序");
        System.out.print("请输入选择：");

        int n=sc.nextInt();
        switch (n){
            case 1:
                select.selectAll();
                choose();
                break;
            case 2:
                select.selectWhere();
                choose();
                break;
            case 3:
                updata.Intsert();
                choose();
                break;
            case 4:
                updata.Updata();
                choose();
                break;
            case 5:
                updata.Delete();
                choose();
                break;
            case 6:
                updata.Business();
                choose();
                break;
            case 0:
                break;
            default:
                System.out.println("输入错误，请重新输入");
                choose();
                break;
        }
    }
}

class SelectDatabase extends Menus {
    public void selectAll() throws Exception{
        getConnection();
        System.out.println("查询所有数据如下：");
        String sql_1="select * from main";
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
    public void selectWhere() throws Exception{
        getConnection();
        Scanner sc=new Scanner(System.in);
        System.out.print("按ID查询，请输入ID：");
        int n=sc.nextInt();
        /*此处不适用prepareStatement的原因是，两者执行的方式不同。
        * 一个是使用：statement.executeQuery(sql)
        * 一个是使用：preparedStatement.executeQuery()*/
        String sql="select * from main where id='"+n+"'";
        selectResultSet(sql);
    }
    public void selectResultSet(String sql) throws Exception{
        resultSet=statement.executeQuery(sql);
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
}

class UpdataDatabase extends Menus {
    public void Intsert() throws Exception{
        getConnection();
        System.out.print("数据插入：");
        String sql="insert into main values(8,'张三',100,'长沙','男',119)";
        System.out.println("影响"+statement.executeUpdate(sql)+"行数据");
    }
    public void Updata() throws Exception{
        getConnection();
        System.out.print("数据更新：");
        String sql="update main set name='李四' where id = 8";
        System.out.println("影响"+statement.executeUpdate(sql)+"行数据");
    }
    public void Delete() throws Exception{
        getConnection();
        System.out.print("数据删除：");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String sql="delete from main where id=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,n);
        System.out.println("影响"+preparedStatement.executeUpdate()+"行数据");
    }
    //事务
    public void Business() throws Exception{
        getConnection();
        String sql_1="insert into main values(8,'张三',90,'长沙','男',119)";
        String sql_2="insert into main values(9,'李四',100,'长沙','男',119)";
        try {
            connection.setAutoCommit(false);    //开启事务
            statement.executeUpdate(sql_1);
            statement.executeUpdate(sql_2);
            connection.commit();    //提交事务
            System.out.println("提交事务成功");
        }catch (Exception e){
            connection.rollback();
            System.out.println("提交事务失败");
        }
    }
}