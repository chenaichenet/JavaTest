import com.demo3.aspectj.Person;
import com.demo3.aspectj.SomeService;
import com.demo3.aspectj.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FileName: TestDemo3
 * Author:   嘉平十七
 * Date:     2020/7/8 16:32
 * Description: 测试Spring中的AspectJ框架实现AOP，对应demo3包下的文件
 * notes：
 */

public class TestDemo3 {
    @Test
    public void test(){
        ApplicationContext app=new ClassPathXmlApplicationContext("spring3.xml");
        /*流程：读取配置文件，创建对象，首先创建了对象someService，然后创建了切面对象myAsepct。
        然后在声明自动代理生成器时，会扫描容器中对象，然后扫描对象类中的注解，然后找到切面类，通过通知注解，找到目标类，然后找到容器中的目标对象，改造成代理对象。
        此时的someService就成了代理对象了*/

        //获取目标对象
        SomeService someService = (SomeService) app.getBean("someService");
        //直接通过实现类创建对象，这里应该是因为，不是通过spring容器创建的对象，所以容器中没有办法通过类对象，创建对应的代理对象。
//        SomeService someService=new SomeServiceImpl();


        //有接口，所以使用的是jdk的动态代理，输出结果为：com.sun.proxy.$Proxy15
//        //没有接口，使用的是spring框架提供的CGLIB动态代理
//        System.out.println(someService.getClass().getName());
//
//        //通过代理的对象执行方法，实现目标方法的增强
//        someService.doSome("test",20);
//
//        someService.doOther(20);
//        /*环绕通知修改值*/
//        int s=someService.doOther(20);
//        //等同于int s=someService.myRound(20);
//        System.out.println(s);
//
//        /*后置通知修改值*/
//        Person str=someService.doPerson("chen",20);
//        System.out.println(str);


        /*异常通知和@Pointcut使用*/
        someService.doException();

        /*直接调用*/
        SomeServiceImpl some=new SomeServiceImpl();
        some.doSome("sss",20);
    }
}