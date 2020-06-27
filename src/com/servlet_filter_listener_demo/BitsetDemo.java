/**
 * FileName: BitsetDemo
 * Author:   嘉平十七
 * Date:     2020/3/12 11:44
 * Description: Bitset类,一个Bitset类创建一种特殊类型的数组来保存位值
 * History:
 */
package com.servlet_filter_listener_demo;

import java.util.BitSet;

public class BitsetDemo {
    public static void main(String args[]){
        BitSet bits1=new BitSet(8);
        BitSet bits2=new BitSet(8);
        for(int i=0;i<8;i++){
//            Scanner sr=new Scanner(System.in);
//            int n=sr.nextInt();
            if ((i%2)==0)bits1.set(i);
            if ((i%5)!=0)bits2.set(i);
        }
        System.out.println("输出bits1"+bits1);
        System.out.println("输出bits2"+bits2);

        bits1.and(bits2);
        System.out.println("bits1 AND bits2\n"+bits1);

        bits2.and(bits1);
        System.out.println("bits2 AND bits1\n"+bits2);

        bits1.or(bits2);
        System.out.println("bits1 OR bits2\n"+bits1);

        bits1.xor(bits2);
        System.out.println("bits1 XOR bits2\n"+bits1);
    }
}