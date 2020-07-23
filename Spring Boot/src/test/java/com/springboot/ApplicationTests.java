package com.springboot;

import com.springboot.domain.Classmate;
import com.springboot.domain.Testbean;
import com.springboot.service.ClassmateService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.util.List;


@SpringBootTest
class ApplicationTests {
    @Autowired
    Testbean testbean;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    DataSource dataSource;

    @Autowired
    ClassmateService service;

    //记录器
    Logger logger= LoggerFactory.getLogger(getClass());

    //测试配置文件赋值
    @Test
    public void testTestbean() {
        System.out.println(testbean);
    }

    //测试spring.xml文件
    @Test
    public void testTestService(){
        boolean testService = ioc.containsBean("testService");
        System.out.println(testService);
    }

    //日志
    @Test
    public void testLog(){
        //日志的级别，由低到高，可以调整输出的日志级别，日志之后在这个级别以后的高级别生效
        logger.trace("===trace日志===");
        logger.debug("===debug日志===");
        //SpirngBoot默认使用的是info级别
        logger.info("===info日志===");
        logger.warn("===warn日志===");
        logger.error("===error日志");
    }

    //测试数据源
    @Test
    public void testDataSource(){
        System.out.println(dataSource);
    }

    //测试通用mapper
    @Test
    public void testSelectAll(){
        List<Classmate> classmateList = service.queryAll();
        classmateList.forEach(classmate -> System.out.println(classmate));
    }

}
