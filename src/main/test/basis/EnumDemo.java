/**
 * FileName: enumDemo
 * Author:   嘉平十七
 * Date:     2020/6/8 10:33
 * Description: 枚举
 * History:
 * notes：
 */
package main.test.basis;
/*6*/
interface IGetColor{
    public String getColor();
}

enum Color1 { //枚举类
    红色,绿色,蓝色;
}
/*5*/
enum Color2 implements IGetColor{ //枚举类
    Red("红色"),Green("绿色"),Bule("蓝色");   //枚举对象需要写在首行
    private String title;   //定义属性
    private Color2(String title){
        this.title=title;
    }
    public String toString(){
        return this.title;
    }

    @Override
    public String getColor() {
        return this.title;
    }
}
/*7*/
enum Color3 {
    Red("红色"){
        public String getColor(){
            return this.toString();
        }
    },Green("绿色"){
        public String getColor(){
            return this.toString();
        }
    },Blue("蓝色"){
        public String getColor(){
            return this.toString();
        }
    };
    private String title;
    private Color3(String title){
        this.title=title;
    }

    @Override
    public String toString() {
        return "Color3{" +
                "title='" + title + '\'' +
                '}';
    }

    public abstract String getColor();
}
public class EnumDemo {
    public static void main(String[] args) {
        /*1*/
//        Color1 color=Color1.红色;
//        System.out.println(color);
        /*2*/
//        for (Color1 color:Color1.values()){
//            System.out.println(color);
//        }
        /*3、枚举类支持switch*/
//        Color1 c1=Color1.红色;
//        switch (c1){    //直接支持枚举
//            case 红色:
//                System.out.println("Red");
//                break;
//            case 绿色:
//                System.out.println("Green");
//                break;
//            case 蓝色:
//                System.out.println("Bule");
//                break;
//        }
        /*4、枚举类可以直接使用增强for循环*/
//        for (Color1 color:Color1.values()){
//            System.out.println(color.ordinal()+"--"+color.name());
//        }
        /*5、可以为枚举对象设置title*/
//        for (Color2 color2:Color2.values()){
//            System.out.println(color2.ordinal()+"--"+color2.name()+"--"+color2);
//        }
        /*6、枚举类可以实现接口*/
//        IGetColor getColor=Color2.Red;
//        System.out.println(getColor.getColor());
        /*7*/
        System.out.println(Color3.Red.getColor());
    }
}