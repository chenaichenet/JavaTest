# SpringMVC框架
```
SpringMVC是基于Spring的一个框架，实际上就是一个Spring的一个模块，专门做web开发的。
可以理解成一个servlet的升级。而web开发底层是servlet，框架是在servlet基础上添加一些功能，让web开发更加方便。
```
## 笔记
### 第一个实例
```
这里和Spring整合MyBatis中不同点在于，前面使用的依然是Servlet，而在此模块中，使用了Controller。
引入了Dispatcherservlet，前端控制器。
```
```text
@Controller创建控制器对象，对象放在springmvc容器中。
@RequestMapping：请求映射，属性值value，定义请求的url地址。
```
### SpringMVC执行流程
```text
○ 用户发起请求some.do
○ DispatcherServlet接收请求some.do，把请求转交给处理器映射器
    § 处理器映射器：springmvc框架中的一种对象，框架把实现了HandlerMapping接口的类都叫做映射器（可多个）。
    § 作用：根据请求，从springmvc容器对象中获取处理器对象。（MyController controller=()getBean("some.do")）。
    § 框架把找到的处理器对象，放到一个叫处理器执行链的类（HandlerExecutionChain）中保存。
    § HandlerExecutionChain：类中保存了，1、处理器对象，2、项目中所有的拦截器。
○ DispatcherServlet把2中的HandlerExecutionChain中的处理器对象交给处理器适配器对象
    § 处理器适配器：springmvc框架中的一种对象，需要实现HandlerAdapter接口（可多个）。
    § 作用：执行处理器方法（调用MyController中的doSome()方法得到返回的ModelAndView）。
○ DispatcherServlet把3中获取的ModelAndView交给视图解析器对象
    § 视图解析器：springmvc中的对象，需要实现ViewResoler接口（可多个）。
    § 作用：可以组成视图完整路径，使用前缀，后缀。并创建一个View对象。
    § View是一个接口，表示视图，在jsp，html中不是使用String表示，而是使用View和它的实现类来表示视图的。
○ DispatcherServlet把4步骤中创建的View对象获取到，调用View类中的方法，把Model数据放入到request作用域，执行对视图的forward，请求结束。
```
### 方法放回值
```text
处理器方法的返回值表示请求处理的结果
1、ModelAndView：有数据和视图，对视图执行forward。
2、String：表示视图，可以使用逻辑名称，也可以是完整视图路径。
3、void：不能表示数据，也不能表示视图。
    应用场景：在处理AJAX的时候，可以使用void返回值。通过HttpSerlvetResponse输出数据，响应AJAX请求。
    AJAX请求，服务器端返回的就是数据，和视图无关。
4、Object:这个Object可以是Integer，String，自定义对象，Map，List等。但是返回的对象不是作为逻辑视图出现的，而是作为直接显示在页面的数据出现的。
```
### SSM整合开发
```text
整合Spring，SpringmMVC，MyBatis三个框架。
SpringMVC：视图层，界面层，负责接收请求，显示处理结果。
Spring：业务层，管理service，dao，工具类对象。
MyBatis：持久层，访问数据库。
```
### SpringMVC核心技术
#### 请求转发和重定向
```text
注意，对于请求转发的页面，可以是WEB-INF中的页面；而重定向的页面，是不能为WEB-INF中的页面。因为重定向相当于用户再次发出一次请求，而用户是不能直接访问WEB-INF中的资源的。
```
#### 异常处理
```text
SpringMVC中处理异常的常用方式：使用@ExceptionHandler注解处理异常。
其采用的是AOP的设计思想，把异常处理集中在一个地方，把业务逻辑和异常处理代码分开，解耦合。
其中核心：
    @ControllerAdvice注解：控制器增强（为控制器类添加异常处理功能）。
    @ExceptionHandler注解：定义处理异常的方法，value值表示异常类型。
```
#### 拦截器
```text
SpringMVC中的拦截器Interceptor，其主要目的是拦截用户请求，并进行相应的预处理和后处理。
拦截器要实现HandlerInterceptor接口，是全局的，可以对多个Controller进行拦截。
除了实现HandlerInterceptor接口外，拦截器的使用，还需要在配置文件中声明拦截器。

拦截器中提供了三个方法，分别是：
    boolean preHandle：预处理方法，true表示请求通过验证，可以执行处理器方法；false，只执行预处理方法，后面的方法都不执行了
    void postHandle：后处理方法，在处理器方法之后执行，能够获取处理器方法的返回值，可以进行修改，能够影响最终的结果。
    void afterCompletion：最后执行，在请求处理后执行的，一般用于资源回收。
```
