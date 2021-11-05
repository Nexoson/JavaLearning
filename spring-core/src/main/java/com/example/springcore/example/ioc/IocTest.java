package com.example.springcore.example.ioc;

import com.example.springcore.entity.Shape;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className IocTest
 * @date 2021/11/5 17:53
 * @desc 使用Spring IOC容器 https://blog.csdn.net/weixin_43907422/article/details/105933374
 **/
public class IocTest {

    public static void main(String[] args) {
        /**
         *  ClassPathXmlApplicationContext 是 ApplicationContext的子类
         *  ApplicationContext是BeanFactory子类 在父类基础上增加上下文
         **/
        // 构造函数参数为配置文件名称
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Shape circle = (Shape) applicationContext.getBean("circle");
        circle.draw();
    }
}
