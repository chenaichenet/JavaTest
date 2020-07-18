异常处理

步骤
1、maven web项目
2、加入依赖
3、新建一个自定义异常类，MyException，再定义它的子类，NameException，AgeException
4、在Controller中抛出异常NameException，AgeException
5、创建一个普通类，作为全局异常处理类
    1、在类的上面接入注解@ControllerAdvice
    2、在类中定义方法，方法上面加入@ExceptionHandler注解
6、创建处理异常的视图页面
7、springmvc中配置
    1、组件扫描器，扫描@Controller
    2、组件扫描器，扫描@ControllerAdvice
    3、声明注解驱动