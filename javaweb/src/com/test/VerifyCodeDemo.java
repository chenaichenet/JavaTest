/**
 * FileName: VerifyCodeDemo
 * Author:   嘉平十七
 * Date:     2020/6/28 8:26
 * Description: 动态生成图片
 * History:
 * notes：
 */
package com.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class VerifyCodeDemo {
    public static void main(String[] args) throws Exception {
        /*1、*/
        /*1.创建图片缓存区
        * 2.设置大小
        * 3.得到图片的绘制环境（画笔）
        * 4.保存*/
//        BufferedImage bufferedImage=new BufferedImage(70,35,BufferedImage.TYPE_INT_RGB);
//        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();    //得到绘制环境，这里强转成2D
//        graphics.setColor(Color.white);   //把环境设置为白色
//        graphics.fillRect(0,0,70,35);   //填充矩形，左上角坐标（0，0），宽70，高35。
//        graphics.setColor(Color.red);
//        graphics.drawString("Hello",2,35-2);   //向图片上写入字符串，设置字符串在图片的位置，
//
//        ImageIO.write(bufferedImage,"JPEG",new FileOutputStream("E:/xxx.jpg"));

        /*2、通过VerifyCode实现*/
        VerifyCode vc=new VerifyCode();
        BufferedImage image = vc.getImage();
        VerifyCode.output(image,new FileOutputStream("E:/aaa.jpg"));

        System.out.println(vc.getText());   //获取验证码
    }
}