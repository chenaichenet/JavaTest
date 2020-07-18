拦截器

处理器要实现HandlerInterceptor接口。
过滤器是过滤请求参数的，设置编码字符集等工作；拦截器是拦截请求的，做请求做判断处理的。
拦截器是全局的，可以对多个Controller做拦截，一个项目中可以有多个拦截器。常用在用户登录处理，权限检查，记录日志。

使用步骤：
    定义类，实现HandlerInterceptor接口
    在springmvc配置文件中声明拦截器
拦截器的执行时间
    在请求处理之前，即controller类中的方法执行之前先拦截
    在控制器方法执行之后，也会执行拦截器
    在请求处理完成后也会执行拦截器

实现步骤：
1、maven web项目
2、加入依赖
3、创建Controller类
4、创建一个普通类，作为全局异常处理类
    1、实现HandlerInterceptor接口
    2、实现接口中的三个方法
5、创建show.jsp
6、springmvc中配置
    1、组件扫描器，扫描@Controller
    2、声明拦截器，并指定拦截请求的uri地址