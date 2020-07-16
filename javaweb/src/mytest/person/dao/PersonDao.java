/**
 * FileName: PersonDao
 * Author:   嘉平十七
 * Date:     2020/6/29 20:48
 * Description:
 * History:
 * notes：
 */
package mytest.person.dao;


import mytest.person.domain.Person;
import mytest.person.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonDao {
    public static ResultSet resultSet=null;
    public static PreparedStatement preparedStatement=null;
    public static Connection connection=null;
    public static Statement statement=null;

    public static void getConnection() throws Exception{
        connection= JdbcUtils.getConnection();
        statement=connection.createStatement();
    }
    public static List<Person> selectAll() throws Exception {
        getConnection();
        List<Person>list=new ArrayList<Person>();

        System.out.println("查询所有数据：");
        String sql="select * from Person";
        resultSet=statement.executeQuery(sql);
        while (resultSet.next()){
            Person person=new Person();
            person.setP_id(resultSet.getInt(1));
            person.setP_name(resultSet.getString(2));
            person.setP_age(resultSet.getInt(3));
            person.setP_address(resultSet.getString(4));
            list.add(person);
        }
        return list;
    }

    public static List<Person> selectWhere(Person person) throws Exception{
        getConnection();
        List<Person> list=new ArrayList<Person>();

        String sql="select * from Person where p_id=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,person.getP_id());
        resultSet=preparedStatement.executeQuery();
        System.out.println("123");
        while (resultSet.next()){
            person.setP_id(resultSet.getInt(1));
            person.setP_name(resultSet.getString(2));
            person.setP_age(resultSet.getInt(3));
            person.setP_address(resultSet.getString(4));
            list.add(person);
        }
        return list;
    }

    public static void Insret(Person person) throws Exception{
        getConnection();

        String sql="insert into Person values(?,?,?,?)";

        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,person.getP_id());
        preparedStatement.setString(2,person.getP_name());
        preparedStatement.setInt(3,person.getP_age());
        preparedStatement.setString(4,person.getP_address());

        System.out.println("影响"+preparedStatement.executeUpdate()+"行数据");
    }

    public static void Updata() throws Exception{
        getConnection();

        System.out.print("ID：");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        String sql="update Person set p_id=?,p_name=?,p_age=?,p_address=? where p_id=?";

        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(5,id);

    }

    public static void Delete() throws Exception{
        getConnection();
        System.out.print("数据删除：");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String sql="delete from Person where p_id=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,n);
        System.out.println("影响"+preparedStatement.executeUpdate()+"行数据");
    }
    //事务
    public void Business() throws Exception{
        getConnection();
        String sql_1="insert into Person values(8,'张三',90,'长沙')";
        String sql_2="insert into main values(9,'李四',100,'长沙')";
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