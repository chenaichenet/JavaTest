/**
 * FileName: Demo
 * Author:   嘉平十七
 * Date:     2020/6/16 11:01
 * Description:
 * History:
 * notes：
 */
package main.test.gui;
import java.awt.*;
import java.awt.event.*;
public class FrameDemo1 {
    public static void main(String[] args) {
        /*1*/
//        Frame frame=new Frame("测试");
//        frame.setVisible(true);     //设置可见性
//        frame.setSize(400,400); //窗口大小
//        frame.setBackground(Color.BLACK);   //设置背景色
//        frame.setLocation(400,200); //初始位置
//        frame.setResizable(false);  //设置固定大小
//        frame.setBounds(400,200,400,400);//初始位置窗口大小

        new MyFrame(100,100,200,200,Color.blue);
        new MyFrame(300,100,200,200,Color.yellow);
        new MyFrame(100,300,200,200,Color.green);
        new MyFrame(300,300,200,200,Color.red);
    }
}
class MyFrame extends Frame{
    static int id=0;
    public MyFrame(int x,int y,int w,int h,Color c){
        super("MyFrame"+(++id));
        setVisible(true);
        setBounds(x,y,w,h);
        setBackground(c);

        /*监听，窗口关闭*/
        /*适配器模式*/
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}