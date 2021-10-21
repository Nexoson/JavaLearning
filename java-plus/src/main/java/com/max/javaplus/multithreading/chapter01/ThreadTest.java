package com.max.javaplus.multithreading.chapter01;

import org.junit.Test;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MyThread03
 * @date 2021/10/21 15:19
 * @desc 线程创建测试
 **/
public class ThreadTest {

    @Test
    public void test01(){
        MyThread02 myThread = new MyThread02();
        Thread thread = new Thread(myThread);
        thread.start();
    }
}
