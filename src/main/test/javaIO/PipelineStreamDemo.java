/**
 * FileName: pipelineStreamDemo
 * Author:   嘉平十七
 * Date:     2020/6/9 10:54
 * Description: 管道流
 * History:
 * notes：
 */
package main.test.javaIO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipelineStreamDemo {
    public static void main(String[] args) throws Exception {
        SendThread send=new SendThread();
        ReceiveThread receive=new ReceiveThread();
        send.getOutput().connect(receive.getInput());//进行管道连接
        new Thread(send,"消息发送线程").start();
        new Thread(receive,"消息接收线程").start();
    }
}
class SendThread implements Runnable{
    private PipedOutputStream output;    //管道的输出流
    public SendThread(){
        this.output =new PipedOutputStream(); //实例化管道输出流
    }
    @Override
    public void run() {
        for (int x=0;x<10;x++){
            try {
                this.output.write(
                        ("【第"+(x+1)+"次信息发送——"+Thread.currentThread().getName()+"】这是信息\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PipedOutputStream getOutput(){
        return output;
    }
}
class ReceiveThread implements Runnable{
    private PipedInputStream input;
    public ReceiveThread(){
        this.input =new PipedInputStream();
    }
    @Override
    public void run() {
        byte data[]=new byte[1024];
        int len=0;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();    //所有的数据都保存到内存输出流
        try {
            while ((len=this.input.read(data))!=-1){
                bos.write(data,0,len);    //所有数据保存到内存流
            }
            System.out.println("{"+Thread.currentThread().getName()+"--接收消息}\n"+new String(bos.toByteArray()));
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PipedInputStream getInput(){
        return input;
    }
}