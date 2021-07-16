package com.max.javaplus.devLab.generic.chapter01;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className Box
 * @date 2021/6/7 15:40
 * @desc
 **/
public class Box<T> {
    private T data;

    public Box() {
    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
