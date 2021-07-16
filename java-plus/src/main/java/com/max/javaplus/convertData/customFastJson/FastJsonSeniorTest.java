package com.max.javaplus.convertData.customFastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className FastJsonSeniorJunit
 * @date 2021/4/29 10:03
 * @desc fastjson 定制过滤 PropertyFilter
 **/
@Slf4j
public class FastJsonSeniorTest {

    /**
     * PropertyFilter
     * 指定字段符合条件才序列化
     **/
    @Test
    public void test01() {
        List<Person> basicJsonData = getBasicJsonData();

        PropertyFilter filter2 = new PropertyFilter() {
            @Override
            public boolean apply(Object object, String name, Object value) {
                if ("age".equals(name)) {
                    return ((Integer) value).intValue() < 18;
                } else if ("name".equals(name)) {
                    return true;
                }
                return false;
            }
        };

        // 序列化的时候传入filter
        log.info(JSON.toJSONString(basicJsonData, filter2));

    }


    /**
     * SimplePropertyPreFilter 指定序列化字段
     **/
    @Test
    public void test02() {
        List<Person> basicJsonData = getBasicJsonData();
        PropertyPreFilter[] filters = new PropertyPreFilter[6];
        SimplePropertyPreFilter filter1 = new SimplePropertyPreFilter(Person.class, new String[]{"name", "age"});
        filters[0] = filter1;
        // 也可以传入数组
        log.info(JSON.toJSONString(basicJsonData, filters));

    }


    /**
     * NameFilter 序列化时修改Key
     **/
    @Test
    public void test03() {
        List<Person> basicJsonData = getBasicJsonData();
        NameFilter nameFilter = new NameFilter() {
            @Override
            public String process(Object object, String name, Object value) {
                if ("age".equals(name) && ((Integer) value).intValue() > 18) {
                    return name.toUpperCase();
                }
                return name;
            }
        };
        log.info(JSON.toJSONString(basicJsonData, nameFilter));
    }


    /**
     * ValueFilter序列化时修改Value
     **/
    @Test
    public void test04() {
        List<Person> basicJsonData = getBasicJsonData();
        ValueFilter valueFilter = new ValueFilter() {
            @Override
            public Object process(Object object, String name, Object value) {

                if ("age".equals(name)) {
                    return ((Integer) value).intValue() + 2;
                }
                return value;
            }
        };
        log.info(JSON.toJSONString(basicJsonData, valueFilter));
    }


    /**
     * BeforeFilter 序列化时在最前添加内容
     **/
    @Test
    public void test05() {
        List<Person> basicJsonData = getBasicJsonData();
        log.info("之前: " + JSON.toJSONString(basicJsonData));
        BeforeFilter beforeFilter = new BeforeFilter() {
            @Override
            public void writeBefore(Object object) {
                writeKeyValue("city", "深圳");
            }
        };

        log.info("之后: " + JSON.toJSONString(basicJsonData, beforeFilter));
    }

    /**
     * AfterFilter 序列化时在最后添加内容
     **/
    @Test
    public void test06() {
        List<Person> basicJsonData = getBasicJsonData();
        log.info("之前: " + JSON.toJSONString(basicJsonData));
        AfterFilter afterFilter = new AfterFilter() {
            @Override
            public void writeAfter(Object object) {
                writeKeyValue("country", "中国");
            }
        };
        log.info("之后: " + JSON.toJSONString(basicJsonData, afterFilter));
    }


    public List<Person> getBasicJsonData() {
        List<Person> data = new ArrayList<>(8);
        Person.Pet pet = new Person().new Pet("喵喵", "爬树");
        Person.Pet pet1 = new Person().new Pet("旺财", "旺旺旺");
        Person.Pet pet2 = new Person().new Pet("哈士奇", "拆迁");

        List<Person.Pet> pets = new ArrayList<>(8);
        pets.add(pet);
        data.add(new Person("张三", 15, pets));
        pets.add(pet1);
        data.add(new Person("李四", 16, pets));
        pets.add(pet2);
        data.add(new Person("王五", 19, pets));
        return data;
    }

    @Data
    @NoArgsConstructor
    class Person {
        private String name;
        private int age;
        private List<Pet> pets;

        private Person(String name, int age, List<Pet> pets) {
            this.name = name;
            this.age = age;
            this.pets = pets;
        }

        @Data
        private class Pet {
            private String petName;
            private String Skill;

            private Pet(String petName, String Skill) {
                this.petName = petName;
                this.Skill = Skill;
            }
        }
    }
}
