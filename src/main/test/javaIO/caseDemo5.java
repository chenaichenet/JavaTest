/**
 * FileName: caseDemo5
 * Author:   嘉平十七
 * Date:     2020/6/11 7:43
 * Description: JavaIO编程案例
 * History:
 * notes：编写一个投票程序，具体如下。
 * （1）功能描述
 * 有一个班采用民主投票方法推选班长，班长候选人共4位，每个人姓名及代号分别为“张三  1；李四  2；王五  3；赵六  4”。程序操作员将每张选票上所填的代号（1、2、3或4）循环输入电脑，输入数字0结束输入，然后将所有候选人的得票情况显示出来，并显示最终当选者的信息。
 * （2）具体要求
 * ① 要求用面向对象方法，编写学生类Student，将候选人姓名、代号和票数保存到类Student中，并实现相应的getXXX 和 setXXX方法。
 * ② 输入数据前，显示出各位候选人的代号及姓名（提示，建立一个候选人类型数组）。
 * ③ 循环执行接收键盘输入的班长候选人代号，直到输入的数字为0，结束选票的输入工作。
 * ④ 在接收每次输入的选票后要求验证该选票是否有效，即如果输入的数不是0、1、2、3、4这5个数字之一，或者输入的是一串字母，应显示出错误提示信息“此选票无效，请输入正确的候选人代号！”，并继续等待输入。
 * ⑤ 输入结束后显示所有候选人的得票情况，如参考样例所示。
 * ⑥ 输出最终当选者的相关信息，如参考样例所示。
 * （3）参考样例
 * 1：张三【0票】
 * 2：李四【0票】
 * 3：王五【0票】
 * 4：赵六【0票】
 * 请输入班长候选人代号（数字0结束）：1
 * 请输入班长候选人代号（数字0结束）：1
 * 请输入班长候选人代号（数字0结束）：1
 * 请输入班长候选人代号（数字0结束）：2
 * 请输入班长候选人代号（数字0结束）：3
 * 请输入班长候选人代号（数字0结束）：4
 * 请输入班长候选人代号（数字0结束）：5
 * 此选票无效，请输入正确的候选人代号！
 * 请输入班长候选人代号（数字0结束）：hello
 * 此选票无效，请输入正确的候选人代号！
 * 请输入班长候选人代号（数字0结束）：0
 * 1：张三【4票】
 * 2：李四【1票】
 * 3：王五【1票】
 * 4：赵六【1票】
 * 投票最终结果：张三同学，最后以4票当选班长！
 */
package main.test.javaIO;

import java.util.Arrays;

public class caseDemo5 {
    public static void main(String[] args) {
        new Menu5();
    }
}
class Student5 implements Comparable<Student5>{ //定义学生类以及排序规则
    private long sid;
    private String name;
    private int vote;

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public Student5(long sid, String name, int vote) {
        this.sid = sid;
        this.name = name;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "【"+this.sid+"】姓名："+this.name+"、票数："+this.vote;
    }

    @Override
    public int compareTo(Student5 student5) {
        return student5.vote-this.vote;
    }

}
interface IVoteServiece5{
    public boolean inc(long sid);   //根据编号增长
    public Student5[] result();     //获取投票结果
    public Student5[] getData();    //获取全部数据
}
class VoteServiceImpl5 implements IVoteServiece5{
    private Student5[] student5s=new Student5[]{
            new Student5(1,"张三",0),
            new Student5(2,"李四",0),
            new Student5(3,"王五",0),
            new Student5(4,"赵六",0),
    };
    @Override
    public boolean inc(long sid) {
        for (int x=0;x<student5s.length;x++){
            if (this.student5s[x].getSid()==sid){   //获取指定编号
                this.student5s[x].setVote(this.student5s[x].getVote()+1);   //票数增长
                return true;
            }
        }
        return false;
    }

    @Override
    public Student5[] result() {
        return this.student5s;
    }

    @Override
    public Student5[] getData() {
        Arrays.sort(this.student5s);
        return this.student5s;
    }
}
class Factory5{
    private Factory5(){}
    public static IVoteServiece5 getInstance(){
        return new VoteServiceImpl5();
    }
}
class Menu5{
    private IVoteServiece5 voteServiece5;
    public Menu5(){
        this.voteServiece5=Factory5.getInstance();
        this.vote();
    }
    public void vote(){     //投票处理
        Student5 stu[]=this.voteServiece5.getData();
        for (Student5 temp:stu){
            System.out.println(temp.getSid()+"："+temp.getName()+"【"+temp.getVote()+"】");
        }
        int num=10;
        while (num!=0){
            num=InputUtil1.getInt("请输入班长候选人代号（数字0结束）：");
            if (num!=0){
                if (!this.voteServiece5.inc(num)){
                    System.err.print("此选票无效，请输入正确的候选人代号！");
                }
            }
        }
        System.out.print("投票最终结果：");
        stu=this.voteServiece5.result();
        System.out.println(stu[0].getName()+"同学，以"+stu[0].getVote()+"票数当选班长");
    }
}