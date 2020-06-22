/**
 * FileName: StuDemo
 * Author:   嘉平十七
 * Date:     2020/6/20 12:14
 * Description: 主类
 * History:
 * notes：
 */
package main.test.xml;

public class StuDemo {
    public static void main(String[] args) throws Exception{
//        testAdd();
//        testDel();
        testSel();
    }
    //查询
    public static void testSel() throws Exception{
        Student student=StuService.getStu("001");
        System.out.println(student.toString());
    }
    //添加
    public static void testAdd() throws Exception{
        Student student=new Student();
        student.setId("003");
        student.setName("王五");
        student.setAge("40");
        StuService.addStu(student);
    }
    //删除
    public static void testDel() throws Exception{
        StuService.delStu("003");
    }
}