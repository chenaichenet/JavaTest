/**
 * FileName: CommonUtils
 * Author:   嘉平十七
 * Date:     2020/6/27 20:42
 * Description: UUID工具类——生成32位随机数
 * History:
 * notes：
 */
package com.test;

import java.util.UUID;

public class CommonUtils {
    public static String uuid(){
//        UUID uuid=UUID.randomUUID();
//        String str=uuid.toString();
//        str=str.replace("-","");    //去除横线
//        str=str.toUpperCase();  //大写
//        System.out.println(str);
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
}