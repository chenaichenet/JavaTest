/**
 * FileName: ReflectionAndJavaDemo
 * Author:   嘉平十七
 * Date:     2020/5/5 8:38
 * Description: 反射与简单Java类
 * History:
 * notes：反射与简单Java类，属性自动赋值实现
 */
package main.test.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReflectionAndJavaDemo {
    public static void main(String[] args) throws Exception{
        Scanner scanner=new Scanner(System.in);
        String value="empno:"+scanner.next()+"|ename:"+scanner.next()+"|job:"+scanner.next()+"|salary:"+scanner.next()+"|hiredate:"+scanner.next();
        //String value="empno:1111|ename:Seventeen|job:King|salary:345.00|hiredate:1999-12-12";
        Emp emp=ClassInstanceFactory.create(Emp.class,value);
        System.out.println("编号："+emp.getEmpno()+"\n姓名："+emp.getEname()+"\n职位："+emp.getJob()+"\n薪资："+emp.getSalary()+"\n日期："+emp.getHiredate());
    }
}
class  ClassInstanceFactory{
    private ClassInstanceFactory(){}
    /**
     * 实例化对象的创建方法，该对象可以根据传入的字符串结构“属性:内容|属性:内容”
     * clazz 要进行反射实例化的Class类对象，有Class就可以反射实例化对象
     * value 要设置的属性内容
     * return 一个已经配置好属性内容的Java类对象
     */
    public static <T> T create(Class<?> clazz,String value) throws Exception{
        try{	//如果要采用反射进行简单Java类的对象处理，类中必须要有无参构造
            Object obj=clazz.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(obj,value);  //通过反射设置属性
            return (T) obj;
        }catch(Exception e){
            e.printStackTrace();	//如果出现错误，本质上抛出异常也没有，可以将其返回空处理。
            return null;
        }
    }
}
class StringUtils{
    public static String initcap(String str){
        if(str==null||"".equals(str)){
            return str;
        }
        if(str.length()==1){
            return str.toUpperCase();
        }else{
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
    }
}
class BeanUtils{
    private BeanUtils(){}
    /**
     * 实现指定对象的属性设置
     * boj 要进行反射操作的实例化对象
     * value 包含指定内容的字符串，格式：“属性:内容|属性:内容”
     * return
     */
    public static void setValue(Object obj,String value){
        String results[]=value.split("\\|");//按照“|”进行拆分
        for(int x=0;x<results.length;x++){	//循环设置属性内容
            //attval[0]保存的是属性名称，attval[1]保存的是属性内容
            String attval []=results[x].split(":");//获取属性名称与内容
            try{
                Field field=obj.getClass().getDeclaredField(attval[0]);//获取成员
                Method setMethod=obj.getClass().getDeclaredMethod("set"+StringUtils.initcap(attval[0]),field.getType());
                Object convertValue=BeanUtils.ConvertAttributeValue(field.getType().getName(),attval[1]);
                setMethod.invoke(obj,convertValue);
                //setMethod.invoke(obj,attval[1]);//调用setter方法设置内容
            }catch(Exception e){}
        }
    }
    /*实现属性类型转换处理
     * type 属性类型，通过Field获取
     * value 属性的内容，传入的都是字符串，需要将其变为指定类型
     * return 转换后的数据*/
    public static Object ConvertAttributeValue(String type,String value){
        if ("long".equals(type)||"java.lang.Long".equals(type)){    //长整型
            return Long.parseLong(value);
        }else if ("int".equals(type)||"java.long.int".equals(type)){
            return Integer.parseInt(value);
        }else if ("double".equals(type)||"java.long.double".equals(type)){
            return Double.parseDouble(value);
        }else if ("java.util.Date".equals(type)) {
            SimpleDateFormat sdf = null;
            if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                return new Date();//当前日期
            }
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();//当前日期
            }
        }else{
            return value;
        }
    }
}
class Emp{
    private Long empno;
    private String ename;
    private String job;
    private double salary;
    private Date hiredate;

    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}