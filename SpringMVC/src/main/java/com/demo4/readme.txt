处理器方法的返回值表示请求处理的结果
1、ModelAndView：有数据和视图，对视图执行forward。
2、String：表示视图，可以使用逻辑名称，也可以是完整视图路径。
3、void：不能表示数据，也不能表示视图。
    应用场景：在处理AJAX的时候，可以使用void返回值。通过HttpSerlvetResponse输出数据，响应AJAX请求。
    AJAX请求，服务器端返回的就是数据，和视图无关。
4、Object:这个Object可以是Integer，String，自定义对象，Map，List等。但是返回的对象不是作为逻辑视图出现的，而是作为直接显示在页面的数据出现的。
    对象有属性，属性就是数据。所以返回的是Objcet表示数据，和视图无关。
    返回对象，需要使用@ResponseBody注解，将转换后的JSON数据放入到响应体中。

编写Ajax，主要使用json的数据格式。实现步骤：
1、加入处理json的工具库依赖，springmvc默认使用jackson。
2、在springmvc配置文件中加入<mvc:annotation-driven>，注解驱动。
    完成的是json=objectMapper.writeValueAsString(param);这一步的功能。
3、在处理器方法上面加上@ResponseBody注解，功能对应，做输出的。
    response.setContentType("application/json;charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.println(json);

springmvc处理器返回Object，可以转为json输出到浏览器，响应Ajax的内部原理：
1、<mvc:annotation-driven>，注解驱动。
    注解驱动实现的功能是：完成Java对象到json，xml，text，二进制等数据格式的转换。
    注解驱动在加入到springmvc配置文件之后，会自定创建消息转换器接口的7个实现类对象。
    包括MappingJackson2HttpMessageConverter(使用jackson工具库中的ObjectMapper实现Java对象转为json字符串)

    HttpMessageConverter接口：消息转换器，定义了Java对象转换格式的方法。有很多实现类，这些实现类完成了这些方法。

    下面两个方法是控制器类把结果输出给浏览器使用的：
    boolean canWrite(Class<?> var1, @Nullable MediaType var2);
    void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3)

    例子：处理器方法
    @RequestMapping(value = {"/returnString-view2.do"})
    public Param doRetrunView2(HttpServletRequest request, String name, int age){
        Param param=new Param();
        param.setName("李四");
        param.setAge(20);
        return param;
    }
    canWriter：检查处理器方法的返回值，能否转换为var2表示的数据格式。
        检查param(张三,20)能不能转换为var2表示的数据格式。能转换就返回true。
    write：把处理器方法的返回值对象，调用jackson中的ObjectMapper转为json字符串。
        json=objectMapper.writeValueAsString(param);

2、@ResponseBody注解
    放在处理器方法的上面，通过HttpServletResponse输出数据，响应Ajax请求的。
    response.setContentType("application/json;charset=utf-8");
    PrintWriter writer = response.getWriter();
    writer.println(json);


没有加入注解驱动标签时的状态
ort.springframework.http.converter.ByteArrayHttpMessageConverter
ort.springframework.http.converter.StringHttpMessageConverter
ort.springframework.http.converter.xml.SourceHttpMessageConverter
ort.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter
加入注解驱动标签后
ort.springframework.http.converter.ByteArrayHttpMessageConverter
ort.springframework.http.converter.StringHttpMessageConverter
ort.springframework.http.converter.ResourceHttpMessageConverter
ort.springframework.http.converter.ResourceRegionHttpMessageConverter
ort.springframework.http.converter.xml.SourceHttpMessageConverter
ort.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter
ort.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter
ort.springframework.http.converter.json.MappingJackson2HttpMessageConverter