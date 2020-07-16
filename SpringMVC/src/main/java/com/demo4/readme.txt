处理器方法的返回值表示请求处理的结果
1、ModelAndView：有数据和视图，对视图执行forward
2、String：表示视图，可以使用逻辑名称，也可以是完整视图路径
3、void：不能表示数据，也不能表示视图。
    应用场景：在处理AJAX的时候，可以使用void返回值。通过HttpSerlvetResponse输出数据，响应AJAX请求。
    AJAX请求，服务器端返回的就是数据，和视图无关。