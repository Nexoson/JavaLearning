package com.max.javaplus.reference;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className M
 * @date 2021/10/26 19:18
 * @desc
 **/
public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
