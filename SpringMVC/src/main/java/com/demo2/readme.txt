第二个SpringMVC项目：@RequestMapping注解的使用

实现步骤：
1、新建web maven工程
2、加入依赖
    spring-webmvc，间接把spring的依赖都加入到项目
    jsp，servlet依赖
3、重点：在web.xml中注册springmvc框架的核心对象DispatcherServlet
    1）DispatcherServlet叫做中央调度器，是一个servlet，它的父类是基础HttpServlet
    2）DispatcherServlet也叫做前端控制器（Front Controller），负责接收用户提交的请求，调用其他的控制器对象，并把请求处理的结果显示给用户
4、创建一个发起请求的页面：index.jsp
5、创建控制器类
    1）在类的上面加入@Controller注解，创建对象，并放入到springmvc容器中
    2）在类中的方法上面接入@RequestMapping注解
6、创建一个作为结果的jsp，显示请求的处理结果
7、创建springmvc配置文件（与spring的配置文件一样）
    1）声明组件扫描器，指定@Controller注解所在的包名
    2）声明视图解析器，帮助处理视图