/**
 * FileName: Test
 * Author:   嘉平十七
 * Date:     2020/6/16 21:06
 * Description:
 * History:
 * notes：
 */
package cn.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {
    public static void main(String[] args) {
      Frame frame=new Frame("测试");
      frame.setBounds(200,200,200,200);
      frame.setVisible(true);
      frame.addWindowListener(new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
      });
      Panel panel=new Panel();
      JLabel jLabel=new JLabel("JLabel");
      panel.add(jLabel);
      frame.add(panel);
    }
}