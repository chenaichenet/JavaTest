/**
 * FileName: MapDemo
 * Author:   嘉平十七
 * Date:     2020/3/12 16:17
 * Description: Map以及dictionary
 * History:
 */
package com.servlet_filter_listener_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapDemo {
    public static void main(String args[]){
        Map map=new HashMap();
        Map map1=new HashMap();
        for(int i=1;i<4;i++){
            Scanner sr=new Scanner(System.in);
            String a=sr.next();
            map.put(i,a);//加引号即表示是字符，而非变量，不同与网上的单个输入，此处应该要使用变量
        }
        System.out.println("显示map："+map);
        map1.putAll(map);//map.clear();删除map集合中的所有元素
        System.out.println("将map添加到map1中,查看map1："+map1);
        boolean a=map.containsKey("1");
        System.out.println("map中是否有key值为'1'的元素："+a);
        boolean b=map.containsKey("5");//boolean containsKey(Object key)查看map集合中有没有包含Key为key的元素，有为true
        System.out.println("map中是否有key值为'5'的元素："+b);
        System.out.println("map中是否有key值为1的元素："+map.containsKey(1));//"1"与"5"结果均为false，是因为在循环中我的key是没有引号的i
        System.out.println("map中是否有value值为'chen'的值："+map.containsValue("chen"));
        System.out.println("map与map1所包含的元素是否相同："+map.equals(map1));
        System.out.println("通过key值为'1'查询value："+map.get(1));
        System.out.println("map集合的hash码值："+map.hashCode());
        System.out.println("map集合是否为空："+map.isEmpty());//空为true
        System.out.println("返回map中所有Key："+map.keySet());
        /*remove(key),删除Key值为key的元素
        size（），返回map中的元素个数
        */
    }
}