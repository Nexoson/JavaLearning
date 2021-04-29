package com.max.java8.date_api.chapter01;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className DateTest01
 * @date 2021/4/29 14:49
 * @desc Java8时间类 学习 参考https://mp.weixin.qq.com/s/CPi5FoKkRWhndlPi6xpBTw
 **/
public class DateTest {


    /**
     * 获取今天的日期
     **/
    @Test
    public void getCurrentDate() {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);

        //这个是作为对比
        Date date = new Date();
        System.out.println("old: " + date);
    }


    /**
     * 获取年、月、日信息
     **/
    @Test
    public void getDetailDate() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.printf("Year : %d  Month : %d  day : %d t %n", year, month, day);
    }

    /**
     * 处理特定日期
     **/
    @Test
    public void handleSpecialDate() {
        LocalDate dateOfBirth = LocalDate.of(2022, 01, 22);
        System.out.println("The special date is : " + dateOfBirth);
    }

    /**
     * 判断两个日期是否相等
     **/
    @Test
    public void compareDate() {
        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2021, 04, 30);
        if (now.equals(of)) {
            System.out.printf("now %s and of %s are same date %n", now, of);
        }
    }


    /**
     * 处理周期性的日期
     **/
    @Test
    public void cycleDate() {
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(1998, 04, 29);

        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);

        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }
    }


    /**
     * 获取当前时间
     **/
    @Test
    public void getCurrentTime() {

        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);
    }


    /**
     * 增加小时
     **/
    @Test
    public void plusHours() {
        LocalTime time = LocalTime.now();
        // 增加两小时
        LocalTime newTime = time.plusHours(2);
        System.out.println("Time after 2 hours : " + newTime);
    }

    /**
     * 计算一周后的时间
     **/
    @Test
    public void nextWeek() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);
    }

    /**
     * 计算一年前或一年后的日期
     **/
    @Test
    public void minusDate() {

        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);

        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Date after 1 year : " + nextYear);

    }

    /**
     * 使用Java 8的Clock时钟类
     **/
    @Test
    public void clock() {
        // 根据系统时间返回当前时间并设置为UFC
        Clock clock = Clock.systemUTC();
        System.out.println("clock : " + clock);

        // 根据系统时钟区域返回时间
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("defaultClock : " + defaultClock);


    }


    /**
     * 如何用Java判断日期是早于还是晚于另一个日期
     **/
    @Test
    public void isBeforeOrIsAfter() {

        LocalDate now = LocalDate.now();
        LocalDate yesterday = LocalDate.of(2021, 04, 28);

        if (yesterday.isBefore(now)) {
            System.out.println("Yesterday is day before today");
        }

        // 加上一天
        LocalDate tomorrow = now.minus(-1, ChronoUnit.DAYS);
        if (tomorrow.isAfter(now)) {
            System.out.println("Tomorrow comes after today");
        }

    }

    /**
     * 处理时区 获取特定时区下面的时间
     **/
    @Test
    public void getZoneTime() {
        // todo 待验证
        // 设置时区
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateNow = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localDateNow, america);
        System.out.println("现在的日期和时间在特定的时区 : " + dateAndTimeInNewYork);
    }
}
