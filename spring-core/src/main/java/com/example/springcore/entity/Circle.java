package com.example.springcore.entity;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Circle
 * @date 2021/11/5 18:00
 * @desc
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
