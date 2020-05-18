/**
 * FileName: ReflectionDemo3
 * Author:   嘉平十七
 * Date:     2020/5/14 15:50
 * Description:
 * History:
 * notes：
 */
package cn.test.Reflection;

public class ReflectionTest3 {
    private String name;
    private int age;
    public ReflectionTest3(){}
    public ReflectionTest3(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+"、年龄："+this.age;
    }
}