package com.max.java8.stream.common.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Person
 * @Auther huangX
 * @Date 2021/4/10 21:24
 * @Version 1.0
 * @Descripition 员工类
 **/
@Data
public class Person {

    private String name; // 姓名
    private int salary; // 薪资
    private int age;   //年龄
    private String sex; // 性别
    private String area; //区域

    public Person(String name, int salary, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.area = area;
    }

    public static List<Person> getPersonList() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));
        return personList;
    }
}
