/**
 * FileName: AutoCloseableDemo
 * Author:   嘉平十七
 * Date:     2020/5/16 17:09
 * Description: AutoCloseable接口
 * History:
 * notes：
 */
package main.test.ClassLibrary;

public class AutoCloseableDemo {
    public static void main(String[] args) {
        /*1*/
        NoteMessage note=new NoteMessage("这里是消息");
        System.out.println(note);
        note.send();
        note.close();
        /*2*/
//        INote it=new INote() {
//            @Override
//            public void close() throws Exception {
//
//            }
//
//            @Override
//            public void send() {
//                System.out.println("123");
//            }
//        };
//        System.out.println(it);
//        it.send();
        /*3*/
        INote iNote=new NoteMessage("111");
        System.out.println(iNote);
        iNote.send();
    }
}
interface INote extends AutoCloseable{
    public void send();
}
class NoteMessage implements INote{ //实现消息的处理机制
    private String note;
    public NoteMessage(String note){
        this.note=note;
    }
    public boolean open(){  //获取资源连接
        System.out.println("获取消息发送连接资源");
        return true;
    }
    @Override
    public void send() {
        if (this.open()){
            System.out.println("发送消息："+this.note);
        }
    }
    public void close(){
        System.out.println("关闭消息发送通道");
    }
}