拦截器演示案例——登录访问

实现步骤：
1、maven项目
2、修改web.xml注册中央调度器
3、新建index.jsp发起请求
4、创建MyController处理请求
5、创建结果res.jsp
6、创建login.jsp模拟登录（把信息放到session）
   创建logout.jsp，模拟退出系统（从session中删除）
7、创建拦截器，从session中获取登录数据，验证
8、创建一个验证的jsp，验证失败给出提示
9、创建springmvc配置文件
   声明组件扫描器，拦截器