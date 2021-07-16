package com.max.javaplus.convert_data.beanUtils.demo01;

import com.max.javaplus.convert_data.beanUtils.demo01.father.UpData;
import com.max.javaplus.convert_data.beanUtils.demo01.father.UpInfo;
import com.max.javaplus.convert_data.beanUtils.demo01.son.MyData;
import com.max.javaplus.convert_data.beanUtils.demo01.son.MyInfo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MainTest
 * @date 2021/4/20 20:24
 * @desc
 **/
public class MainTest {
    public static void main(String[] args) {
        // 获取公共入参
        LinkedList<UpData> upData = getUpData();
        LinkedList<MyData> myData = new LinkedList<>();
        // 转换成 myData
        if (upData.size() > 0) {
            upData.forEach(info -> {
                MyData temp = new MyData();
                BeanUtils.copyProperties(info, temp);
                myData.add(temp);
            });
        }

        int size = myData.size();
        myData.forEach(info -> {
            System.out.println(info.toString());
        });


    }

    public static LinkedList<UpData> getUpData() {
        LinkedList<UpData> upData = new LinkedList<>();
        ArrayList<UpInfo> infos = new ArrayList<>();
        infos.add(new UpInfo("A", 90));
        infos.add(new UpInfo("B", 80));
        upData.add(new UpData("1", infos));

        infos = new ArrayList<>();
        infos.add(new UpInfo("C", 70));
        infos.add(new UpInfo("D", 60));
        upData.add(new UpData("2", infos));
        return upData;
    }

    public static LinkedList<MyData> getMyData() {
        LinkedList<MyData> myData = new LinkedList<>();
        ArrayList<MyInfo> myInfos = new ArrayList<>();
        myInfos.add(new MyInfo("C", 90));
        myInfos.add(new MyInfo("D", 80));
        myData.add(new MyData("1", myInfos));

        return myData;
    }

}
