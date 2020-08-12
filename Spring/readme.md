# Spring框架 
## 文件夹说明
```text
main：主文件夹
    java：源文件夹
        demo1：spring的IoC，基于XML的DI实现，对应spring1.xml和TestDemo1。
        demo2：spring的IoC，基于注解的DI实现，对应spring2.xml和TestDemo2。
        demo3：spring的AOP，使用AspectJ实现的动态代理，对应spring3.xml和TestDemo3。
            aspectj：使用AspectJ框架。
            javaProxy：jdk的动态代理。
        demo4：spring整合mybatis框架，附带web项目。
    resource：资源文件夹
    webapp：web文件夹
test：测试源文件夹
pom.xml为依赖文件
```
## 笔记
### Spring框架概述
```text
Spring是分层的JavaSE/EE应用full-stack轻量级开源框架。
以IoC（Inverse Of Control：反转控制）和AOP（Aspect Oriented Programming：面向切面编程）为内核。
提供了展现层Spring MVC和持久层Spring JDBC以及业务层事务管理等的众多企业应用技术，还能整合开源众多的第三方框架和类库。
```
### IoC控制反转
```text
IoC的实现是通过依赖注入（DI），程序代码不做定位查询，交由框架自动完成。
DI的实现有两种方式，通过xml文件或使用注解。
```
#### 基于xml的DI
```text
<beans>：根标签，Spring把java对象分为bean。
<bean>：声明bean，id是对象自定义的唯一名称，class是类的全限定名称（不能是接口，因为Spring是反射机制，必须使用类）
<property>：set注入，name是属性名称，value是属性值。

创建容器对象：ApplicationContext app=new ClassPathXmlApplicationContext("spring.xml");
获取对象：getBean();
容器中定义的对象数量：getBeanDefinitionCount();
容器中定义的对象名称：getBeanDefinittionNames();
```
```text
注入：set注入、构造注入、引用类型注入（byName、byType）。
```
#### 基于注解的DI
```text
对于DI使用注解，将不再需要再Spring配置文件中声明bean实例。需要在Spring配置文件中配置组件扫描器，用于在指定的基本包中扫描注解。
```
```text
<context:component-scan base-package=""/>：指定注解的包名。
工作方式：spring会扫描遍历base-package指定的包，把包中和子包中所有的类，找到类中的注解，按照注解的功能创建对象或给属性赋值。
```
```text
@Component等同于<bean>标签，用于创建对象。
    属性：value，定义id，省略就是类名首字母小写。
与@Component同级的、用于分层的还有
    @Repository（持久层注解）：放在Dao的实现类上面，表示创建Dao对象，Dao对象是能访问数据库的。
    @Service（业务层）：放在service的实现类上面，表示创建service对象，用于业务处理的，可以有事物功能的。
    @Controller（控制器层）：放在控制器（处理器）类的上面，创建控制器对象，控制器对象能接收用户提供的参数，显示请求的处理结果（servlet也属于Controller）。
```
```text
引用类型的注入
@Autowired
```
### AOP面向切面编程
```text
面向切面编程，重要的是一种思想，项目中很少使用Spring的AOP实现，因为其较为笨重。可以使用AspectJ来完成AOP。
```
```text
AspectJ的通知类型
    ○ @Before：前置通知
    ○ @AfterReturning：后置通知
    ○ @Around：环绕通知
    ○ @AfterThrowing：异常通知
    ○ @After：最终通知
```

### Spring整合MyBatis
```text
略
```
