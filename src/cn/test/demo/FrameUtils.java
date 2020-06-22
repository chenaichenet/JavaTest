/**
 * FileName: FrameUtils
 * Author:   嘉平十七
 * Date:     2020/5/15 16:34
 * Description:
 * History:
 * notes：方案一：使用InputStream将全部要拷贝的内容全部读取到程序中，再拷贝到目标文件。缺点是，当文件过大时，程序运行时间过长，甚至死机。
 *      方案二：采用部分拷贝，读取一部分输出一部分，核心操作为：
 *          InputStream：public int read(byte[] b)throw IOException;
 *          OutputStream:public void write(byte[] b,int off,int len)throw IOException;
 */
package cn.test.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;

public class FrameUtils {
    public static void main(String[] args) {
        /*定义窗口*/
        Frame frame=new Frame("数据库连接");
        frame.setLayout(new GridLayout(2,1));
        frame.setBounds(200,200,400,400);
        frame.setVisible(true);
        frame.setBackground(Color.white);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        /*定义面板*/
        Panel p1=new Panel(new BorderLayout());
        Panel p2=new Panel(new GridLayout(2,1));
        Panel p3=new Panel(new BorderLayout());
        /*定义按钮*/
        Button but1=new Button("Select");
        Button but2=new Button("Update");
        /*定义文本框*/
        TextField text1=new TextField();
        TextField text2=new TextField();

        JLabel jLabel=new JLabel("输入SQL语句");

        p2.add(but1);
        p2.add(but2);

        p1.add(p2,BorderLayout.EAST);
        p1.add(text1,BorderLayout.CENTER);
        p1.add(jLabel,BorderLayout.NORTH);

        p3.add(text2,BorderLayout.CENTER);

        frame.add(p1);
        frame.add(p3);

        /*定义监听*/
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    JdbcUtilsDemo.selectAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        TextListen textListen=new TextListen();
        text1.addActionListener(textListen);

    }
}
class TextListen implements ActionListener{
    private String sql;
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        TextField field= (TextField) actionEvent.getSource();
        sql=field.getText();
    }
}
