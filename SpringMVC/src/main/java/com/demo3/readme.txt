第三个SpringMVC项目：接收请求参数
接收请求参数，使用的处理器方法的形参
    HttpServletRequest
    HttpServletResponse
    HttpSession
    用户提交的参数
接收用户提交的参数
1、逐个接收
2、对象接收

注意：
在提交请求参数是，使用get方式获取是不会出现乱码问题，但是post方式是会出现中文乱码问题。
在Servlet中，doPost(HttpServletRequest request,…)中，是使用request.setCharacterEncoding("utf-8");来设置编码的，但是这样的代码，需要在servlet中重复编写。
于是，可以通过过滤器，在过滤器中设置字符编码。
过滤器可以自定义，也可以使用框架中提供的过滤器CharacterEncodingFilter。