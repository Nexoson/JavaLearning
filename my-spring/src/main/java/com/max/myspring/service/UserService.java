package com.max.myspring.service;

import com.max.myspring.annotation.Autowired;
import com.max.myspring.annotation.Component;
import com.max.myspring.annotation.Scope;
import com.max.myspring.inter.BeanNameAware;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className UserService
 * @date 2021/11/18 15:32
 * @desc 用户服务层
 **/

@Component("userService")
@Scope("prototype")
public class UserService implements BeanNameAware {

    @Autowired
    private OrderService orderService;

    private String beanName;

    public void test() {
        System.out.println(orderService);
        System.out.println(beanName);
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
        //...
    }
}
