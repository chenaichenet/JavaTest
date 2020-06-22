/**
 * FileName: LayoutDemo
 * Author:   嘉平十七
 * Date:     2020/6/16 16:36
 * Description: 布局管理器
 * History:
 * notes：
 */
package main.test.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setSize(200,200);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        /*1、FlowLayout流布局*/
//        Button button1 = new Button("Button1");
//        Button button2 = new Button("Button2");
//        Button button3 = new Button("Button3");
//        frame.setLayout(new FlowLayout(FlowLayout.LEFT));//设置为流式布局
//        //添加
//        frame.add(button1);
//        frame.add(button2);
//        frame.add(button3);

        /*2、边框布局*/
//        Button east = new Button("East");
//        Button west = new Button("West");
//        Button south = new Button("South");
//        Button north = new Button("North");
//        Button center = new Button("Center");
//        frame.add(east,BorderLayout.EAST);
//        frame.add(west,BorderLayout.WEST);
//        frame.add(south,BorderLayout.SOUTH);
//        frame.add(north,BorderLayout.NORTH);
//        frame.add(center,BorderLayout.CENTER);

        /*表格布局*/
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");
        Button button5 = new Button("Button5");
        Button button6 = new Button("Button6");
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        //frame.pack();//自动布局
        frame.setLayout(new GridLayout(2,3,10,10));
    }
}