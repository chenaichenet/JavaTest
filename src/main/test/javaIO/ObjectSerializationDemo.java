/**
 * FileName: objectSerializationDemo
 * Author:   嘉平十七
 * Date:     2020/6/10 9:39
 * Description: 对象序列化
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.*;

public class ObjectSerializationDemo {
    private static final File SAVE_FILE=new File("e:"+File.separator+"1234.person");
    public static void main(String[] args) throws Exception{
        saveObject(new Person("绪花",16));
        System.out.println(loadObject());
    }
    public static void saveObject(Object obj) throws Exception{
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);   //序列化
        oos.close();
    }
    public static Object loadObject() throws Exception{
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj=ois.readObject();    //反序列化
        ois.close();
        return obj;
    }
}
class  Person implements Serializable{  //Person类可以被序列化
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}