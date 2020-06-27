/**
 * FileName: TemporaryDemo
 * Author:   嘉平十七
 * Date:     2020/3/23 12:18
 * Description: 临时
 * History:
 * notes：
 */
package com.servlet_filter_listener_demo;

interface IMessagesa{
    public String getContentsa();
}
class MessageImplsa implements IMessagesa{

    @Override
    public String getContentsa() {
        return "Hello,World";
    }
}
class MessageUtilsa{
    private MessageUtilsa(){}
    public static IMessagesa getMessagesa(){
        return new MessageImplsa();
    }
    public static void useMessagesa(IMessagesa msg){
        if(msg!=null){
            System.out.println(msg.getContentsa());
        }
    }
}
public class TemporaryDemo {
       public static void main(String[] args) throws Exception{
           MessageUtilsa.useMessagesa(null);
    }
}
