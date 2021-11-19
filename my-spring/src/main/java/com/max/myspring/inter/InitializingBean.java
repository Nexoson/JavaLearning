package com.max.myspring.inter;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className InitializingBean
 * @date 2021/11/19 10:36
 * @desc 初始化bean接口
 **/
public interface InitializingBean {

    /**
     * xxx
     **/
    void afterPropertiesSet() throws Exception;
}
