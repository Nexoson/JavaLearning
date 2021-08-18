package com.max.javaplus.devLab.generic.chapter03;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className AddList
 * @date 2021/8/18 15:11
 * @desc list中多个相同元素的属性统计
 **/
public class AddList {
    public static void main(String[] args) {
        List<MyData> initList = getInitData();
        System.out.println(JSON.toJSONString(initList));

        Map<String, MyData> myDatas = new HashMap<>();

        // 以组为单位进行统计
        initList.forEach(info -> {
            if (myDatas.keySet().contains(info.getKey())) {
                MyData temp = myDatas.get(info.getKey());
                myDatas.get(info.getKey()).getPerson().setMoney(temp.getPerson().getMoney() + info.getPerson().getMoney());
            } else {
                myDatas.put(info.getKey(), info);
            }
        });

        // 展示数据
        System.out.println(JSON.toJSONString(myDatas));
    }

    private static List<MyData> getInitData() {
        ArrayList<MyData> list = new ArrayList<>(10);
        list.add(new MyData("张三", new Person("张三", 100)));
        list.add(new MyData("李四", new Person("李四", 300)));
        list.add(new MyData("王五", new Person("王五", 600)));
        list.add(new MyData("张三", new Person("张三", 200)));
        list.add(new MyData("李四", new Person("李四", 400)));
        list.add(new MyData("王五", new Person("王五", 600)));
        return list;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class MyData {
        private String key;
        private Person person;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Person {
        private String name;
        private Integer money;
    }
}
