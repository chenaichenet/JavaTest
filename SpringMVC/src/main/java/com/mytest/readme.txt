自编项目SSM
整合的SpringMVC，Spring，MyBatis
通过网页对数据库进行操作
这里可以对比另一个项目JavaWeb中的mytest（通过传统的Servlet对数据库进行处理）

处理流程
mytest.jsp——MyTestController——Classma teService——ClassmateServiceImpl——ClassmateDao——ClassmateDao.xml——database——result.jsp
其中有：
SpringMVC的中央控制器，处理器方法，请求参数的获取，处理方法的返回值，组件扫描器，视图解析器，注解驱动，静态资源访问
Spring的Ioc控制反转，自动注入，加载配置文件，数据源，SqlSessionFactoryBean对象创建，mybatis扫描器——自动创建dao对象
MyBatis的mapper映射文件，动态SQL，定义别名


=======================================================================
SSM整合开发
SpringMVC+Spring+MyBatis

SpringMVC：视图层，界面层，负责接收请求，显示处理结果。
Spring：业务层，管理service，dao，工具类对象。
MyBatis：持久层，访问数据库。

用户发起请求——SpringMVC接收——Spring中的Service对象——MyBatis处理数据

SSM整合也叫做SSI（IBatis是MyBatis前身）
1、第一个容器叫SpringMVC容器，管理Controller控制器对象的。
2、第二个容器叫Spring容器，管理Service，Dao，工具类对象的。
我们要做的把使用的对象交给格式的容器创建，管理。
把Controller还有web开发相关对象交给SpringMVC容器，这些web用的对象写在spingmvc配置文件中。

service，dao对象，定义在spring配置文件中，让spring管理这些对象。

springmvc容器和spring容器是有关系的，springmvc容器是spring容器的子容器，类似Java中的继承，子容器可以访问父容器中的。
子容器中的Controller可以访问父容器中的Service对象。

实现步骤：
0、数据库
1、加入依赖，springmvc，spring，mybatis三个框架的依赖，jackson依赖，数据库驱动，druid连接池，jsp，servlet依赖。
2、写web.xml文件
    注册DispatcherServlet，创建springmvc容器对象，才能创建Controller对象；创建Servlet，能接收用户的请求。
    注册spring监听器，ContextLoaderListener，创建spring的容器对象，才能创建service，dao等对象。
    注册字符集过滤器，解决post请求乱码的问题。
4、创建包，controller，service，dao，实体类包
5、写springmvc,spring，mybatis配置文件
    springmvc
    spring
    mybatis
    数据库属性配置文件
6、代码，dao接口和mapper文件，service和实现类，controller，实体类
7、jsp页面