package com.max.myspring.service;

import com.max.myspring.annotation.Component;
import com.max.myspring.inter.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
            ((UserServiceImpl) bean).setBeanName("Max");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        // 处理所有bean
        System.out.println("初始化后");
        if (beanName.equals("userService")) {
            Object proxyInstance = Proxy.newProxyInstance(BeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("代理逻辑"); // 找切点
                    return method.invoke(bean, args);
                }
            });
            return proxyInstance;
        }

        return bean;
    }
}
