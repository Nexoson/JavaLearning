package com.example.springcore;

import com.example.springcore.service.TestServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Test
 * @date 2021/11/2 16:21
 * @desc 测试类
 **/
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.example.springcore")
public class TestApplication {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestApplication.class);
        // 接口 通过Cglib代理
/*        TestService testService = context.getBean(TestService.class);
        testService.getInfo("1");*/

        TestServiceImpl bean = (TestServiceImpl)context.getBean("testService");
        bean.getInfo("2");
    }

}
