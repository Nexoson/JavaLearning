package com.max.myspring;

import lombok.Data;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className BeanDefinition
 * @date 2021/11/18 16:58
 * @desc Bean定义
 **/
@Data
public class BeanDefinition {

    private Class clazz;
    private String scope;

}
