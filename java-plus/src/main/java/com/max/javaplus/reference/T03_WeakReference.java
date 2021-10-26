package com.max.javaplus.reference;

import java.lang.ref.WeakReference;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className WeakReference
 * @date 2021/10/26 19:20
 * @desc 弱引用 只要执行GC就会被回收
 **/
public class T03_WeakReference {

    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> tl = new ThreadLocal<>();
        // 里面是弱引用可以规避 内存泄露问题
        tl.set(new M());
        // 删除map中的entry
        tl.remove();
    }

}
