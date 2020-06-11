/**
 * FileName: caseDemo4
 * Author:   嘉平十七
 * Date:     2020/6/10 17:24
 * Description: JavaIO编程案例
 * History:
 * notes：完成系统登录程序，从命令行输入用户名和密码，如果没有输入用户名和密码，则提示输入用户名和密码；
 * 如果输入了用户名但是没有输入密码，则提示用户输入密码，然后判断用户名是否是123，密码是否是321，如果正确，则提示登录成功；
 * 如果错误，显示登录失败的信息，用户再次输入用户名和密码，连续3次输入错误后系统退出。
 */
package main.test.javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class caseDemo4 {
    public static void main(String[] args) {
        System.out.println(Factory4.getInstance().login("123", "123"));
    }
}
class InputUtil4{
    private static final BufferedReader INPUT=new BufferedReader(new InputStreamReader(System.in));
    private InputUtil4(){}
    public static String getString(String propmt){
        String str=null;
        boolean flag=true;
        while (flag){
            System.out.print(propmt);   //打印提示信息
            try {
                str=INPUT.readLine();   //键盘输入
                if (!"".equals(str)){
                    flag=false;
                }else {
                    System.out.println("输入内容不允许为空");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("输入内容不允许为空！");
            }
        }
        return str;
    }
}
interface IUserService4{    //用户的操作接口
    public boolean isExit();    //是否退出
    public boolean login(String name,String password);  //登录控制
}
class UserServiceImpl4 implements IUserService4{
    private int count=0;    //作为登录统计
    @Override
    public boolean isExit() {
        return this.count>=3;   //执行登录退出的条件
    }

    @Override
    public boolean login(String name, String password) {
        this.count++;
        return "123".equals(name)&&"321".equals(password);
    }
}
class UserServiceProxy4 implements IUserService4{    //用登录失败的检测处理操作，用户的代理操作类
    private IUserService4 userService4;
    public UserServiceProxy4(IUserService4 userService4) {
        this.userService4 = userService4;
    }

    @Override
    public boolean isExit() {
        return this.userService4.isExit();
    }

    @Override
    public boolean login(String name, String password) {
        while (!this.isExit()){     //不进行退出
            String inputData=InputUtil4.getString("请输入登录信息：");
            if (inputData.contains("/")){   //输入了用户名和密码
                String temp[]=inputData.split("/");
                if (this.userService4.login(temp[0],temp[1])){  //登录认证
                    System.out.println("登录成功");
                    return true;    //循环结束
                }else {
                    System.out.println("登录失败");
                }
            }else {     //只输入用户名
                String pwd=InputUtil4.getString("请输入密码");
                if (this.userService4.login(inputData,pwd)){
                    System.out.println("登录成功");
                    return true;
                }else {
                    System.out.println("登录失败");
                }
            }
        }
        System.out.println("登录失败");
        return false;
    }
}
class Factory4{
    private Factory4(){}
    public static IUserService4 getInstance(){
        return new UserServiceProxy4(new UserServiceImpl4());
    }
}