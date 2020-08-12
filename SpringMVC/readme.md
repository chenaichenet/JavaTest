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
