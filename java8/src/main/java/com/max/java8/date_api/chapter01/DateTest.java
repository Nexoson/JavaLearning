package com.max.java8.date_api.chapter01;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.zone.ZoneRules;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

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
     * ZonedDateTime 带时区的时间
     * Java 8不仅分离了日期和时间，也把时区分离出来了。现在有一系列单独的类如 ZoneId 来处理特定时区，ZoneDateTime 类来表示某时区下的时间
     **/
    @Test
    public void getZoneTime() {
        // 默认时区
        ZonedDateTime zbj = ZonedDateTime.now();
        // 用指定时区获取当前时间
        ZoneId of = ZoneId.of("America/New_York");
        ZonedDateTime zny = ZonedDateTime.now(of);
        System.out.println(zbj);
        System.out.println(zny);


        LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        ZonedDateTime defaultZone = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime newZone = ldt.atZone(ZoneId.of("America/New_York"));
        System.out.println(defaultZone);
        System.out.println(newZone);
    }


    /**
     * 使用 YearMonth类处理特定的日期
     * <p>
     * 表示信用卡到期这类固定日期。与 MonthDay 检查重复事件的例子相似，YearMonth 是另一个组合类，
     * 用于表示信用卡到期日、FD到期日、期货期权到期日等。还可以用这个类得到 当月共有多少天，
     * YearMonth 实例的 lengthOfMonth() 方法可以返回当月的天数，在判断2月有28天还是29天时非常有用
     **/
    @Test
    public void checkCardExpiry() {

        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2021, Month.MAY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }


    /**
     * 检查闰年
     * <p>
     * LocalDate类有一个很实用的方法 isLeapYear() 判断该实例是否是一个闰年，
     * 如果你还是想重新发明轮子，这有一个代码示例，纯Java逻辑编写的判断闰年的程序
     **/
    @Test
    public void isLeapYear() {

        LocalDate now = LocalDate.now();
        if (now.isLeapYear()) {
            System.out.println("This year is Leap year");
        } else {
            System.out.println(LocalDate.now().getYear() + " is not a Leap year");
        }
    }


    /**
     * 计算两个日期之间的天数和月数
     * <p>
     * 有一个常见日期操作是计算两个日期之间的天数、周数或月数。
     * 在Java 8中可以用java.time.Period类来做计算。下面这个例子中，
     * 我们计算了当天和将来某一天之间的月数。下面的例子：现在是一月份，距离到五月份，中间相隔3月
     **/
    @Test
    public void calcDateDays() {
        LocalDate today = LocalDate.now();
        LocalDate define = LocalDate.of(2020, Month.AUGUST, 9);
        Period between = Period.between(define, today);
        System.out.println(" years " + between.getYears() + " months " + between.getMonths() + " days " + between.getDays());
    }


    /**
     * 包含时差信息的日期和时间
     * <p>
     * ZoneOffset类用来表示时区，举例来说印度与GMT或UTC标准时区相差+05:30，
     * 可以通过ZoneOffset.of()静态方法来 获取对应的时区。
     * 一旦得到了时差就可以通过传入LocalDateTime和ZoneOffset来创建一个OffSetDateTime对象
     **/
    @Test
    public void zoneOffset() {

        // LocalDateTime datetime = LocalDateTime.of(2021, Month.FEBRUARY, 14, 19, 30);
        LocalDateTime datetime = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }


    /**
     * 获取当前的时间戳
     * <p>
     * Instant类有一个静态工厂方法now()会返回当前的时间戳，如下所示:
     **/
    @Test
    public void getTimestamp() {
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
    }


    /**
     * 使用预定义的格式化工具去解析或格式化日期
     * <p>
     * Java 8引入了全新的日期时间格式工具，线程安全而且使用方便。
     * 它自带了一些常用的内置格式化工具。下面这个例子使用了BASIC_ISO_DATE格式化工具将2018年2月10日格式化成20180210
     **/
    @Test
    public void formatDate() {
        String dayAfterTomorrow = "20210507";
        LocalDate formatted = LocalDate.parse(dayAfterTomorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTomorrow, formatted);
    }


    /**
     * 处理夏令时(todo 待验证)
     **/
    @Test
    public void summerDate() {
        //预计不在夏令时 2021-03-13 01:59:59
        LocalDateTime time4 = LocalDateTime.of(2020, 1, 8, 14, 59, 59);
        getZongTime2(time4, ZoneId.of("America/New_York"));

        //预计在夏令时 2021-03-13 03:00:00
        LocalDateTime time1 = LocalDateTime.of(2020, 1, 8, 15, 00, 00);
        getZongTime2(time1, ZoneId.of("America/New_York"));

        //预计在夏令时 2021-11-06 02:59:59
        LocalDateTime time2 = LocalDateTime.of(2020, 11, 6, 14, 59, 59);
        getZongTime2(time2, ZoneId.of("America/New_York"));

        //预计不在夏令时2021-11-06 02:00:00
        LocalDateTime time3 = LocalDateTime.of(2020, 11, 6, 15, 00, 00);
        getZongTime2(time3, ZoneId.of("America/New_York"));
    }

    public void getZongTime2(LocalDateTime time, ZoneId dest) {
        Objects.requireNonNull(dest);
        getZongTime2(time, null, dest);
    }

    public void getZongTime2(LocalDateTime time, ZoneId src, ZoneId dest) {
        //难点就是如何求偏移量
        //这里使用默认时区,在中国的就是中国,在美国的就是美国,这样估计更合适
        Objects.requireNonNull(dest);
        ZonedDateTime z1 = null;
        if (src == null) {
            z1 = time.atZone(ZoneId.systemDefault());
        } else {
            z1 = time.atZone(src);
        }
//
        ZonedDateTime z2 = z1.withZoneSameInstant(dest);
        //处理重叠问题
        long hours = Duration.between(z2.withEarlierOffsetAtOverlap(), z2.withLaterOffsetAtOverlap()).toHours();
        z2 = z2.plusHours(hours);

        System.out.println(dest.getId() + " 对应的标准时区:" + getZoneDesc(TimeZone.getTimeZone(dest)));
        System.out.println("标准时区时间: " + time);
        System.out.println("目标时区" + dest + "的时间" + z2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println();
    }

    /**
     * 获取标准时区,方式1
     * 在jdk8之前的方法,利用TimeZone
     **/
    private static String getZoneDesc(TimeZone destzone) {
        Objects.requireNonNull(destzone);
        int Offset = destzone.getRawOffset() / (1000 * 60 * 60);
        if (Offset <= 0) {
            return "GMT" + String.valueOf(Offset);
        } else {
            return "GMT+" + String.valueOf(Offset);
        }
    }

    /**
     * 方式2:ZoneRules.getOffset
     **/
    private String getZoneDesc2(ZoneId dest) {
        Objects.requireNonNull(dest);
        ZoneRules rule = dest.getRules();
        //获取时区的标准偏移量
        String standardOffset = rule.getStandardOffset(ZonedDateTime.now(dest).toInstant()).getId();
        String s = standardOffset.split(":")[0];
        int Offset = Integer.parseInt(s);
        //返回方式1:带小时分钟
//	    	return "GMT"+standardOffset;
        //返回方式2:只带小时数
        if (Offset > 0) {
            return "GMT+" + Offset;
        } else {
            return "GMT" + Offset;
        }
    }
}