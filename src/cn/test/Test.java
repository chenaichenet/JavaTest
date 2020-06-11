/**
 * FileName: Test
 * Author:   嘉平十七
 * Date:     2020/5/15 16:34
 * Description:
 * History:
 * notes：方案一：使用InputStream将全部要拷贝的内容全部读取到程序中，再拷贝到目标文件。缺点是，当文件过大时，程序运行时间过长，甚至死机。
 *      方案二：采用部分拷贝，读取一部分输出一部分，核心操作为：
 *          InputStream：public int read(byte[] b)throw IOException;
 *          OutputStream:public void write(byte[] b,int off,int len)throw IOException;
 */
package cn.test;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {

    }
}
