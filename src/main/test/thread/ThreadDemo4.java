/**
 * FileName: ThreadDemo4
 * Author:   嘉平十七
 * Date:     2020/5/16 10:51
 * Description: 生产者与消费者
 * History:
 * notes：
 */
package main.test.thread;

public class ThreadDemo4 {
    public static void main(String[] args) {
        Goods goods=new Goods();
        new Thread(new Producer(goods)).start();
        new Thread(new Consumer(goods)).start();
    }
}
class Goods {
    private String title;
    private String content;
    private boolean flag=true;  //表示生产或消费形式
    /*flag=true：允许生产，不允许消费
    * flag=false：允许消费，不允许生产*/
    public synchronized void set(String title,String content){
        if (this.flag==false){  // 无法进行生产，应该等待被消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title=title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content=content;
        this.flag = false ; // 已经生产过了
        super.notify(); // 唤醒等待的线程
    }
    public synchronized String get(){
        if (this.flag==true){   //还未生产，需要等待
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return this.title+"="+this.content;
        }finally {
            this.flag = true ; // 继续生产
            super.notify(); // 唤醒等待线程
        }

    }

}
class Producer implements Runnable{ //生产者
    private Goods goods;
    public Producer(Goods goods){
        this.goods=goods;
    }
    @Override
    public void run() {
        for (int x=0;x<10;x++){
            if (x%2==0){
                this.goods.set("0","0");
            }else {
                this.goods.set("1","1");
            }

        }
    }
}
class Consumer implements Runnable{ //消费者
    private Goods goods;
    public Consumer(Goods goods){
        this.goods=goods;
    }
    @Override
    public void run() {
        for (int x=0;x<10;x++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.goods.get());
        }
    }
}