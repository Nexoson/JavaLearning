package com.example.springcore.entity;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Square
 * @date 2021/11/5 17:59
 * @desc
 **/
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
