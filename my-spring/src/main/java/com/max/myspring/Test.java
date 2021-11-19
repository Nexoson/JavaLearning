package com.max.myspring;

import com.max.myspring.config.AppConfig;
import com.max.myspring.inter.UserService;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Test
 * @date 2021/11/18 15:12
 * @desc
 **/
public class Test {

    public static void main(String[] args) {
/*        // 通过xml的配置文件获取bean
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 通过注解的方式获取bean
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = applicationContext.getBean("userService",UserService.class);

        userService.test();*/
        MaxApplicationContext applicationContext = new MaxApplicationContext(AppConfig.class);
/*        System.out.println(applicationContext.getBean("userService"));
        System.out.println(applicationContext.getBean("userService"));
        System.out.println(applicationContext.getBean("userService"));*/
        UserService UserService = (UserService) applicationContext.getBean("userService");
        UserService.test();
    }

}
