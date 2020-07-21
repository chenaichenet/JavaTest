/**
 * FileName: LiseDemo
 * Author:   嘉平十七
 * Date:     2020/3/26 8:22
 * Description: 链表
 * History:
 * notes：单向链表的基本功能
 */
package com.test;
interface ILink<E>{     //设置泛型避免安全隐患
    public void add(E e);//增加数据
    public int size();//获取数据的个数
    public boolean isEmpty();//判断是否为空集合
    public Object[] toArray();//返回集合数据
    public E get(int index);//获取指定索引的值
    public void set(int index,E data);//修改指定索引数据
    public boolean contains(E data);//判断数据是否存在
    public void remove(E data);//删除指定数据
    public void clean();//清空链表
}
class LinkImpl<E> implements ILink<E>{

    private class Node{     //保存节点的数据关系
        private E data;     //保存的数据
        private Node next;  //保存下一个引用
        public Node(E data){        //有数据的情况下才有意义
            this.data=data;
        }
        //Node类只用于LinkImpl类，内部类不用setter、getter方法

        //第一次调用：LinkImpl.root.addNode(),this=LinkImpl.root;
        //第二次调用：this=LinkImpl.root.next;
        //第三次调用：this=LinkImpl.root.next.next;
        public void addNode(Node newNode){//保存新的Node数据
            if(this.next==null){    //当前节点的下一个节点为null
                this.next=newNode;  //保存当前节点
            }else{
                this.next.addNode(newNode);
            }
        }
        //第一次调用：this=LinkImpl.root;
        //第二次调用：this=LinkImpl.root.next;
        //第三次调用：this=LinkImpl.root.next.next;
        public void toArrayNode(){
            LinkImpl.this.returnData[LinkImpl.this.foot ++]=this.data;
            if(this.next!=null){    //还有下一个数据
                this.next.toArrayNode();
            }
        }
        public E getNode(int index){
            if(LinkImpl.this.foot++==index){  //索引相同
                return this.data;   //返回当前数据
            }else {
                return this.next.getNode(index);
            }
        }
        public void setNode(int index,E data){
            if(LinkImpl.this.foot++==index){  //索引相同
                this.data=data;   //返回当前数据
            }else {
                this.next.setNode(index, data);
            }
        }
        public boolean containsNode(E data){
            if(data.equals(this.data)){
                return true;
            }else {
                if(this.next==null){
                    return false;
                }else {
                    return this.next.containsNode(data);
                }
            }
        }
        public void removeNode(Node previous,E data){
            if(this.data.equals(data)){
                previous.next=this.next;    //上一个next指向这一个next,空出当前节点
            }else{
                if(this.next!=null){    //有后续节点
                    this.next.removeNode(this,data);//向后继续删除
                }
            }
        }
    }
    //——————————以下为Link类中定义的成员——————————
    private Node root;      //保存根元素
    private int count;      //保存数据个数
    private int foot;       //描述的是操作数组的脚标
    private Object [] returnData;//返回的数据保存
    //——————————以下为Link类中定义的方法——————————
    @Override
    public void add(E e) {
        if(e==null){    //保存的数据为null
            return;     //方法调用直接结束
        }
        //数据本身是没有关联属性的，只有Node类有，那么要实现关联处理就必须将数据包装在Node类之中
        Node newNode=new Node(e);   //创建一个新的节点
        if(this.root==null){        //现在没有根节点
            this.root=newNode;      //第一个节点作为根节点
        }else {                     //根节点存在
            this.root.addNode(newNode);//将新节点保存在合适的位置
        }
        this.count++;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
//        return this.root==null;//一样的
        return this.count==0;
    }

    @Override
    public Object[] toArray() {
        if(this.isEmpty()){ //空集合
            return null;    //现在没有数据
        }
        this.foot=0;    //脚标清零
        this.returnData=new Object[this.count];     //根据已有的长度开辟数组
        this.root.toArrayNode();    //利用Node类进行递归数据获取
        return this.returnData;
    }

    @Override
    public E get(int index) {
        if(index>this.count){//索引应该在指定范围内
            return null;
        }
        //索引数据的获取应该有Node类完成
        this.foot=0;    //重置索引下标
        return this.root.getNode(index);
    }

    @Override
    public void set(int index, E data) {
        if(index>this.count){//索引应该在指定范围内
            return;
        }
        //索引数据的获取应该有Node类完成
        this.foot=0;    //重置索引下标
        this.root.setNode(index, data);
    }

    @Override
    public boolean contains(E data) {
        if(data==null){
            return false;
        }
        return this.root.containsNode(data);
    }

    @Override
    public void remove(E data) {    //在子类中判断根节点的删除，在Node类中判断后续节点
        if(this.contains(data)){    //判断数据是否存在
            if(this.root.data.equals(data)){    //根节点为要删除节点
                this.root=this.root.next;   //根节点移位
            }else {     //交由Node类负责删除
                this.root.next.removeNode(this.root,data);
            }
            this.count--;
        }
    }

    @Override
    public void clean() {
        this.root=null; //后续节点都没了
        this.count=0;   //个数清零
    }
}
//实战——超市购物车
interface IGoods{   //定义商品标准
    public String getName();
    public double getPrice();
}
interface IShopCar{ //购物车标准
    public void add(IGoods goods);
    public void delete(IGoods goods);
    public Object[] getAll();   //获得购物车中的全部商品信息
}
class ShopCarImpl implements IShopCar{  //购物车
    private ILink<IGoods> allGoodses=new LinkImpl<IGoods>();
    @Override
    public void add(IGoods goods) {
        this.allGoodses.add(goods);
    }

    @Override
    public void delete(IGoods goods) {
        this.allGoodses.remove(goods);
    }

    @Override
    public Object[] getAll() {
        return this.allGoodses.toArray();
    }
}
class Cashier{  //收银台
    private IShopCar shopcar;
    public Cashier(IShopCar shopcar){
        this.shopcar=shopcar;
    }
    public double allPrice(){   //计算总价
        double all=0.0;
        Object result [] =this.shopcar.getAll();
        for(Object obj:result){
            IGoods goods=(IGoods) obj;
            all+=goods.getPrice();
        }
        return all;
    }
    public int allCount(){
        return this.shopcar.getAll().length;
    }
}
class Book implements IGoods{   //书本
    private String name;
    private double price;
    public Book(String name,double price){
        this.name=name;
        this.price=price;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Book)){
            return false;
        }
        Book book=(Book) obj;
        return this.name.equals(book.name)&&this.price==book.price;
    }
    public String toString(){
        return "图书信息\n"+"Name:"+this.name+"、价格："+this.price;
    }
}

public class ListDemo {
    public static void main(String[] args){
        ILink<String> all=new LinkImpl<String>();
        System.out.println("增加之前——数据个数："+all.size()+"、是否为空集合："+all.isEmpty());
        all.add("Hello");
        all.add("World");
        all.add("Java");
        all.set(1,"世界");
        all.remove("Hello");
        all.remove("Java");
//        all.clean();
        System.out.println("增加之后——数据个数："+all.size()+"、是否为空集合："+all.isEmpty());
        System.out.println("——————————数据显示——————————");
        Object result[] =all.toArray();
        if(result!=null){
            for(Object obj:result){
                System.out.println(obj);
            }
        }
        System.out.println("——————————查询判断功能——————————");
        System.out.println("获取索引为0的数据："+all.get(0));
        System.out.println("获取索引为4 的数据："+all.get(4));
        System.out.println("判断“Hello”是否存在："+all.contains("Hello"));
        System.out.println("判断“ReflectionTest2”是否存在："+all.contains("ReflectionTest2"));

        /*实战——超市购物*/
//        IShopCar car=new ShopCarImpl();
//        car.add(new Book("Java开发",100.0));
//        car.add(new Book("python开发",98.8));
//        Cashier cas=new Cashier(car);
//        System.out.println("总价格："+cas.allPrice()+"、购买数量"+cas.allCount());
    }
}