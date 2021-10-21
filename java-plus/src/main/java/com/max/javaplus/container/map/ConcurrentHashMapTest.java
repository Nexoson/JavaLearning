package com.max.javaplus.container.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className CurrentHashMapTest
 * @date 2021/7/6 11:08
 * @desc CurrentHashMap学习
 **/
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap curMap = new ConcurrentHashMap<>();
        ReentrantLock reenLock = new ReentrantLock();
    }
}
