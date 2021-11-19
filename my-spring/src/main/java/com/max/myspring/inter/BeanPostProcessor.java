package com.max.myspring.inter;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className BeanPostProcessor
 * @date 2021/11/19 10:50
 * @desc Bean环绕解析
 **/
public interface BeanPostProcessor {

    /**
     *
     **/
    Object postProcessBeforeInitialization(Object bean, String beanName);
    /**
     *
     **/
    Object postProcessAfterInitialization(Object bean, String beanName);

}
