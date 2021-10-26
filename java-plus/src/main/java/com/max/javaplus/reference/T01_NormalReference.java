package com.max.javaplus.reference;

import java.io.IOException;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className T01_NormalReference
 * @date 2021/10/26 19:19
 * @desc 强引用
 **/
public class T01_NormalReference {

    public static void main(String[] args) throws IOException {
        M m = new M();
        // 将对象引用置为null
        m = null;
        // 手动触发GC
        System.gc();
        // 阻塞待GC完成 再结束main函数
        System.in.read();
    }
}
