package com.max.javaplus.convertData.customFastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className FastJsonFeatureJunit
 * @date 2021/4/29 9:22
 * @desc FastJson   SerializerFeature枚举类  官方自定义常用序列化场景
 **/
@Slf4j
public class FastJsonFeatureJunit {


    /**
     * UseSingleQuotes 使用单引号而不是双引号,默认为false
     **/
    @Test
    public void test01() {
        List<Person> basicJsonData = getBasicJsonData();
        log.info("初始数据: " + JSON.toJSONString(basicJsonData));
        log.info("定制数据: " + JSON.toJSONString(basicJsonData, SerializerFeature.UseSingleQuotes));
    }

    /**
     * WriteMapNullValue 是否输出值为null的字段,默认为false
     **/
    @Test
    public void test02() {
        List<Person> basicJsonData = getBasicJsonData();
        log.info("初始数据: " + JSON.toJSONString(basicJsonData));
        log.info("定制数据: " + JSON.toJSONString(basicJsonData, SerializerFeature.WriteMapNullValue));
    }

    /**
     * PrettyFormat 格式化输出
     **/
    @Test
    public void test03() {
        List<Person> basicJsonData = getBasicJsonData();
        log.info("初始数据: " + JSON.toJSONString(basicJsonData));
        log.info("定制数据: " + JSON.toJSONString(basicJsonData, SerializerFeature.PrettyFormat));
    }

    /**
     * WriteNullStringAsEmpty 将为String为null的字段值显示为""
     **/
    @Test
    public void test04() {
        List<Person> basicJsonData = getBasicJsonData();
        basicJsonData.get(0).setName(null);
        log.info("初始数据: " + JSON.toJSONString(basicJsonData));
        log.info("定制数据: " + JSON.toJSONString(basicJsonData, SerializerFeature.WriteNullStringAsEmpty));
    }

    /**
     * WriteNullBooleanAsFalse： Boolean字段如果为null,输出为false,而非null
     **/
    @Test
    public void test05() {
        List<Person> basicJsonData = getBasicJsonData();
        log.info("初始数据: " + JSON.toJSONString(basicJsonData));
        log.info("定制数据: " + JSON.toJSONString(basicJsonData, SerializerFeature.WriteNullStringAsEmpty));
    }


    /**
     * WriteNullNumberAsZero 数值字段如果为null,输出为0,而非null
     **/
    @Test
    public void test06() {
        List<Person> basicJsonData = getBasicJsonData();
        log.info("初始数据: " + JSON.toJSONString(basicJsonData));
        log.info("定制数据: " + JSON.toJSONString(basicJsonData,SerializerFeature.WriteNullNumberAsZero));
    }


    /**
     * SkipTransientField 如果是true，类中的Get方法对应的Field是transient，序列化时将会被忽略。默认为true
     **/
    @Test
    public void test07() {
        List<Person> basicJsonData = getBasicJsonData();
        log.info("定制数据: " + JSON.toJSONString(basicJsonData, SerializerFeature.SkipTransientField));
    }

    /**
     * BeanToArray 将对象转为array输出
     **/
    @Test
    public void test08() {
        Person basicJsonData = getBasicJsonData().get(0);
        log.info("初始数据: " + JSON.toJSONString(basicJsonData));
        log.info("定制数据: " + JSON.toJSONString(basicJsonData, SerializerFeature.BeanToArray));

    }


    public List<Person> getBasicJsonData() {
        List<Person> data = new ArrayList<>(8);
        data.add(new Person("张三", null, new Person().new Pet("喵喵", "爬树"), true));
        data.add(new Person("李四", 16, new Person().new Pet("旺财", "旺旺旺"), null));
        data.add(new Person("王五", 19, new Person().new Pet("哈士奇", "拆迁"), null));
        return data;
    }

    @Data
    @NoArgsConstructor
    class Person {
        private Pet pet;
        private String Name;
        private Integer age;
        //        private transient Boolean isStudent;
        private Boolean isStudent;
        private Date birthday;

        private Person(String Name, Integer age, Pet pet, Boolean isStudent) {
            this.pet = pet;
            this.Name = Name;
            this.age = age;
            this.isStudent = isStudent;
        }


        @Data
        private class Pet {
            private String petName;
            private String skill;

            private Pet(String petName, String skill) {
                this.petName = petName;
                this.skill = skill;
            }
        }
    }

}
