/**
 * FileName: ActionEventDemo
 * Author:   嘉平十七
 * Date:     2020/6/16 17:22
 * Description: 事件监听
 * History:
 * notes：
 */
package main.test.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class ActionEventDemo {
    public static void main(String[] args) {
        Frame frame=new Frame();
        frame.setVisible(true);
        frame.setBounds(200,200,200,200);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        /*按键监听*/
        Button button1=new Button("Button1");
        Button button2=new Button("Button2");
        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.SOUTH);
        /*1、按键监听*/
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("窗口已关闭");
//                for (int i=0;i<5;i++){
//                    System.exit(0);
//                }
//            }
//        });
        /*2、按键监听*/
        MyMoitor myMoitor=new MyMoitor();
        button1.addActionListener(myMoitor);
        button2.addActionListener(myMoitor);

        /*输入框监听*/
        TextField textField=new TextField();
        frame.add(textField);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent.getSource());//获取资源
                TextField field=(TextField) actionEvent.getSource();//Object型强转
//                field.setText("");//清空
                System.out.println(field.getText());
                System.out.println("-----");

                File file=new File("e:"+File.separator+"123.txt");
                OutputStream outputStream= null;
                try {
                    outputStream = new FileOutputStream(file);
                    outputStream.write(field.getText().getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        textField.setEchoChar('*');//设置替换编码
    }
}
/*2、按键监听*/
class MyMoitor implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("按钮被点击："+actionEvent.getActionCommand());//获取按钮上信息
    }
}