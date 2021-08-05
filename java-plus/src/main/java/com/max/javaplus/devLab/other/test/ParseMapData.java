package com.max.javaplus.devLab.other.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.max.javaplus.devLab.stream.StreamTest01;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className ParseMapData
 * @date 2021/7/18 14:12
 * @desc 处理响应map数据
 **/
public class ParseMapData {


    @Test
    public void test01() {

//        String testStr = "[{itemId=22146, locationRefId=3835, locationName=MDL-YCT-MX-横岗仓-HKXC, quantity=1, locationId=3456789, storeRefId=121,232,234, locationType=5, storeName=AMZ-CKW-CA,AMZ-CKW-US,AMZ-EGM-CA, platform=美卡多}, {itemId=22146, locationRefId=3705, locationName=MDL-YCT-MX海外仓-HKXC, quantity=3213, locationId=, storeRefId=121,176, locationType=2, storeName=AMZ-EGM-CA,AMZ-ETD-CA, platform=美卡多}]";
        List<Map<String, Object>> maps = test03();
        String jsonArr = JSON.toJSONString(maps);
        List<User> users = JSONArray.parseArray(jsonArr, User.class);
        System.out.println(users.size());
    }


    @Test
    public void test02() {
        StreamTest01.User user = new StreamTest01.User();
        user.setAge(18);
        user.setName("张三");


        List<StreamTest01.User> list = new ArrayList<>();
        list.add(user);
        user = new StreamTest01.User();
        user.setName("李四");
        user.setAge(25);
        list.add(user);

        System.out.println(list.toString());
    }


    public List<Map<String, Object>> test03() {
        // [{name=张三, age=19}, {name=李四, age=23}]

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> entity = new HashMap<>();
        entity.put("name", "张三");
        entity.put("age", 19);
        list.add(entity);

        entity = new HashMap<>();
        entity.put("name", "李四");
        entity.put("age", 23);
        list.add(entity);

        return list;
//        System.out.println(JSON.toJSON(list));
//        System.out.println(JSON.toJSON(list.toString()));

//        System.out.println(hashMaps.size());
    }

    @Test
    public void test04(){
        String aaa = null;
        String bbb = "";
//        System.out.println(Integer.parseInt(aaa));
//        System.out.println(Integer.parseInt(bbb));

        System.out.println(StringUtils.isBlank(""));


    }


    @Data
    public static class User {
        public String name;
        public int age;
    }


}
