/**
 * FileName: PanelDemo
 * Author:   嘉平十七
 * Date:     2020/6/16 16:21
 * Description: 面板
 * History:
 * notes：Panel可以看成一个空间，但是不能单独存在
 */
package main.test.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PanelDemo {
    public static void main(String[] args) {
        Frame frame=new Frame();
        Panel panel=new Panel();

        frame.setLayout(null);  //设置布局
        frame.setBounds(300,300,500,500);
        frame.setBackground(Color.blue);

        panel.setBounds(50,50,400,400);
        panel.setBackground(Color.red);

        frame.add(panel);//添加面板

        frame.setVisible(true);//可见

        /*监听，窗口关闭*/
        /*适配器模式*/
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}