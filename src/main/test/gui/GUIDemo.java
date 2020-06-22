/**
 * FileName: GUIDemo
 * Author:   嘉平十七
 * Date:     2020/6/14 16:07
 * Description: GUI
 * History:
 * notes：
 */
package main.test.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setLayout(new GridLayout(2,1));
        frame.setVisible(true);
        frame.setBounds(300,200,600,500);
        frame.setBackground(Color.WHITE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2,2));

        /*上部分*/
        p1.add(new Button("East-1"),BorderLayout.EAST);
        p1.add(new Button("West-1"),BorderLayout.WEST);

        p2.add(new Button("Button-1"));
        p2.add(new Button("Button-1"));

        p1.add(p2,BorderLayout.CENTER);
        /*下半部分*/
        p3.add(new Button("East-2"),BorderLayout.EAST);
        p3.add(new Button("West-2"),BorderLayout.WEST);

        for (int i=0;i<4;i++){
            p4.add(new Button("Button-"+i));
        }
        p3.add(p4);
        /**/
        frame.add(p1);
        frame.add(p3);
    }
}