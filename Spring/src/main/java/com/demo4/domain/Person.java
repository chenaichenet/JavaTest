/**
 * FileName: Person
 * Author:   嘉平十七
 * Date:     2020/7/10 8:29
 * Description:
 * notes：
 */
package com.demo4.domain;

public class Person {
    //属性名与列名一致
    private Integer p_id;
    private String p_name;
    private Integer p_age;
    private String p_address;

    public Person() {
    }

    public Person(Integer p_id, String p_name, Integer p_age, String p_address) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_age = p_age;
        this.p_address = p_address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_age=" + p_age +
                ", p_address='" + p_address + '\'' +
                '}';
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Integer getP_age() {
        return p_age;
    }

    public void setP_age(Integer p_age) {
        this.p_age = p_age;
    }

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }
}