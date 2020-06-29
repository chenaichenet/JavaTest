/**
 * FileName: Employee
 * Author:   嘉平十七
 * Date:     2020/6/29 13:49
 * Description: 雇员
 * History:
 * notes：配合EL表达式演示使用
 */
package com.jsp_demo.java;

public class Employee {
    private String name;
    private double salary;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }

    public String getTest(){
        return "测试";
    }
}