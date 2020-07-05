/**
 * FileName: StuService
 * Author:   嘉平十七
 * Date:     2020/6/20 11:47
 * Description:
 * History:
 * notes：
 */
package main.test.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.List;

public class StuService {
    //查询，根据id查询信息
    public static Student getStu(String id) throws Exception {
        /*1.创建解析器
         * 2.得到document
         * 3.获取所有id
         * 4.返回list结合，遍历list集合
         * 5.得到每一个id的节点
         * 6.id节点的值
         * 7.判断id的值和传递的id值是否相同
         * 8.相同，获得id的父节点stu
         * 9.通过stu获取name,age值*/
        SAXReader saxReader=new SAXReader();    //创建解析器
        Document document=saxReader.read("src/main/test/xml/student.xml");    //得到document

        List<Node> list=document.selectNodes("//id");
        Student student=new Student();
        for (Node node:list){
            String idv=node.getText();
            if (idv.equals(id)){
                Element stu=node.getParent();
                String name=stu.element("name").getText();
                String age=stu.element("age").getText();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
            }
        }
        return student;
    }

    //增加
    public static void addStu(Student student) throws Exception {
        SAXReader saxReader=new SAXReader();    //创建解析器
        Document document=saxReader.read("src/main/test/xml/student.xml");    //得到document
        Element root=document.getRootElement(); //得到根节点
        Element stu=root.addElement("stu");     //在根节点上添加stu
        //在stu上依次添加id、name、age标签
        Element id=stu.addElement("id");
        Element name=stu.addElement("name");
        Element age=stu.addElement("age");
        //在id、name、age上依次添加值
        id.setText(student.getId());
        name.setText(student.getName());
        age.setText(student.getAge());
        //回写xml
        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/main/test/xml/student.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
    //删除，根据学生id删除
    public static void delStu(String id) throws Exception {
        SAXReader saxReader=new SAXReader();    //创建解析器
        Document document=saxReader.read("src/main/test/xml/student.xml");    //得到document
        List<Node> list=document.selectNodes("//id");   //获取所有的id 利用xpath://id
        for (Node node:list){   //遍历list集合，node是每一个id元素
            String idv=node.getText();  //得到id
            if (idv.equals(id)){
                Element stu=node.getParent();   //得到stu节点
                Element student=stu.getParent();//得到stu父节点student
                student.remove(stu);    //删除
            }
        }
        //回写
        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/main/test/xml/student.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}