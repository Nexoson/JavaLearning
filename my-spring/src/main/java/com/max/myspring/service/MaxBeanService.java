package com.max.myspring.service;

import com.max.myspring.annotation.Component;
import com.max.myspring.inter.BeanPostProcessor;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MaxBeanService
 * @date 2021/11/19 11:10
 * @desc Bean服务
 **/

@Component("maxBeanService")
public class MaxBeanService implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        // 处理所有bean
        System.out.println("初始化前");
        // 可以针对特定的bean进行处理
        if (beanName.equals("userService")) {
            ((UserService) bean).setBeanName("Max");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        // 处理所有bean
        System.out.println("初始化后");
        return bean;
    }
}
