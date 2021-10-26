package com.max.javaplus.reference;

import java.lang.ref.SoftReference;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className T02_SoftReference
 * @date 2021/10/26 19:20
 * @desc 软引用  内存不够时才会被回收，适用于当缓存使用
 **/
public class T02_SoftReference {

    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        // m = null;
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());

        // 再分配一个数据，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用回收掉。
        byte[] b = new byte[1024*1024*15];
        System.out.println(b);

        // 堆内存溢出了，并未达到回收软引用的效果
    }

}
