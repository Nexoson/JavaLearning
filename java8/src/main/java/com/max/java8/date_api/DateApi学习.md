## 简介

伴随 `lambda表达式`、`streams` 以及一系列小优化，Java 8 推出了全新的日期时间API。

Java处理日期、日历和时间的不足之处：将 java.util.Date 设定为可变类型，以及 SimpleDateFormat 的非线程安全使其应用非常受限。然后就在 java8 上面增加新的特性。

全新API的众多好处之一就是，明确了日期时间概念，例如：`瞬时（instant）`、 `长短（duration）`、`日期`、`时间`、`时区`和`周期`。

同时继承了Joda 库按人类语言和计算机各自解析的时间处理方式。不同于老版本，新API基于ISO标准日历系统，java.time包下的所有类都是不可变类型而且线程安全。

## 关键类

- Instant：瞬时实例。
- LocalDate：本地日期，不包含具体时间 例如：2014-01-14 可以用来记录生日、纪念日、加盟日等。
- LocalTime：本地时间，不包含日期。
- LocalDateTime：组合了日期和时间，但不包含时差和时区信息。
- ZonedDateTime：最完整的日期时间，包含时区和相对UTC或格林威治的时差。

新API还引入了 ZoneOffSet 和 ZoneId 类，使得解决时区问题更为简便。解析、格式化时间的 DateTimeFormatter 类也全部重新设计。

## 实战

在教程中我们将通过一些简单的实例来学习如何使用新API，因为只有在实际的项目中用到，才是学习新知识以及新技术最快的方式。

### 1. 获取当前的日期

Java 8 中的 `LocalDate` 用于表示当天日期。和 java.util.Date不同，它只有日期，不包含时间。当你仅需要表示日期时就用这个类。

```
//获取今天的日期
public void getCurrentDate(){
    LocalDate today = LocalDate.now();
    System.out.println("Today's Local date : " + today);

    //这个是作为对比
    Date date = new Date();
    System.out.println(date);
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tFzlIJ2O4WH6RRdLlFRPicBlU7iaHfIZWul12ZvJtBlE87b8Q85Nt2ibVg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

上面的代码创建了当天的日期，不含时间信息。打印出的日期格式非常友好，不像 Date类 打印出一堆没有格式化的信息。

### 2. 获取年、月、日信息

`LocalDate` 提供了获取年、月、日的快捷方法，其实例还包含很多其它的日期属性。通过调用这些方法就可以很方便的得到需要的日期信息，不用像以前一样需要依赖java.util.Calendar类了。

```
//获取年、月、日信息
public void getDetailDate(){
    LocalDate today = LocalDate.now();
    int year = today.getYear();
    int month = today.getMonthValue();
    int day = today.getDayOfMonth();

    System.out.printf("Year : %d  Month : %d  day : %d t %n", year, month, day);
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tZ4IBiaCXw5nDON6U1GukMF6OzJzFTf3WX5tTqXBjqPuB4oKZkHa7ibeQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 3.处理特定日期

在第一个例子里，我们通过静态工厂方法now()非常容易地创建了当天日期。我们还可以调用另一个有用的工厂方法 `LocalDate.of()` 创建任意日期， 该方法需要传入年、月、日做参数，返回对应的LocalDate实例。这个方法的好处是没再犯老API的设计错误，比如年度起始于1900，月份是从 `0` 开始等等。日期所见即所得，就像下面这个例子表示了1月21日，直接明了。

```
//处理特定日期
public void handleSpecilDate(){
    LocalDate dateOfBirth = LocalDate.of(2018, 01, 21);
    System.out.println("The specil date is : " + dateOfBirth);
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tWrfN1LN97CVv97Ms97EkdeMwXAiacNZ8JTgKEYaA33IKa3WWA3qz5vw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 4.判断两个日期是否相等

现实生活中有一类时间处理就是判断两个日期是否相等。在项目开发的时候总会遇到这样子的问题。下面这个例子会帮助你用Java 8的方式去解决，`LocalDate` 重载了equal方法。注意，如果比较的日期是字符型的，需要先解析成日期对象再作判断。

请看下面的例子：

```
//判断两个日期是否相等
public void compareDate(){
    LocalDate today = LocalDate.now();
    LocalDate date1 = LocalDate.of(2018, 01, 21);

    if(date1.equals(today)){
           System.out.printf("TODAY %s and DATE1 %s are same date %n", today, date1);
    }
}
```


![图片](https://mmbiz.qpic.cn/sz_mmbiz_png/knmrNHnmCLETkShoD4ZD0kJlX9yo279bUm8VzjypLbeQLz0ibSkPGxG9ibzDSUKnvYa6iauE7NoMKeQhib6Q3oJ5Hw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 5.检查像生日这种周期性事件

Java 中另一个日期时间的处理就是检查类似生日、纪念日、法定假日（国庆以及春节）、或者每个月固定时间发送邮件给客户 这些周期性事件。Java中如何检查这些节日或其它周期性事件呢？答案就是`MonthDay`类。这个类组合了月份和日，去掉了年，这意味着你可以用它判断每年都会发生事件。和这个类相似的还有一个`YearMonth`类。这些类也都是不可变并且线程安全的值类型。下面我们通过 `MonthDay`来检查周期性事件：

```
//处理周期性的日期
public void cycleDate(){
    LocalDate today = LocalDate.now();
    LocalDate dateOfBirth = LocalDate.of(2018, 01, 21);

    MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
    MonthDay currentMonthDay = MonthDay.from(today);

    if(currentMonthDay.equals(birthday)){
       System.out.println("Many Many happy returns of the day !!");
    }else{
       System.out.println("Sorry, today is not your birthday");
    }
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tDPiaiae2KaRdeOptXKhaDpSzDVQv0uXYVMsguXYRSCFdd4aOV5dKgJmQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 6.获取当前时间

与 获取日期 例子很像，获取时间使用的是 `LocalTime` 类，一个只有时间没有日期的LocalDate近亲。可以调用静态工厂方法now()来获取当前时间。默认的格式是`hh:mm:ss:nnn`。

```
//获取当前时间
public void getCurrentTime(){
    LocalTime time = LocalTime.now();
    System.out.println("local time now : " + time);
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tMRq0QB8YdamzOywxgc4OWNLphktg2vTC02lT53Wd9QHyDpDOVF4LOA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 7.在现有的时间上增加小时

Java 8 提供了更好的 plusHours() 方法替换 add() ，并且是兼容的。注意，这些方法返回一个全新的LocalTime实例，由于其不可变性，返回后一定要用变量赋值。

```
//增加小时
public void plusHours(){
    LocalTime time = LocalTime.now();
    LocalTime newTime = time.plusHours(2); // 增加两小时
    System.out.println("Time after 2 hours : " +  newTime);
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tPCvNJgJcpuiappQTyAJiaWpvMS4uvZYIricDF9pXk4UyjyghllqF7fVwQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 8.如何计算一个星期之后的日期

和上个例子计算两小时以后的时间类似，这个例子会计算一周后的日期。LocalDate日期不包含时间信息，它的plus()方法用来增加天、周、月，ChronoUnit类声明了这些时间单位。由于LocalDate也是不变类型，返回后一定要用变量赋值。

可以用同样的方法增加1个月、1年、1小时、1分钟甚至一个世纪，更多选项可以查看Java 8 API中的ChronoUnit类。

```
//如何计算一周后的日期
public void nextWeek(){
    LocalDate today = LocalDate.now();
    LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);    //使用变量赋值
    System.out.println("Today is : " + today);
    System.out.println("Date after 1 week : " + nextWeek);
}
```

![图片](https://mmbiz.qpic.cn/sz_mmbiz_png/knmrNHnmCLETkShoD4ZD0kJlX9yo279bhH6JtQcDibBjgCEpyqEicoFLOecjd0WmzZr4F8bKTj2yIbna4TICtBibQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 9.计算一年前或一年后的日期

接着上面的例子中我们通过 `LocalDate` 的 `plus()` 方法增加天数、周数或月数，这个例子我们利用 `minus()` 方法计算一年前的日期。

```
//计算一年前或一年后的日期
public void minusDate(){
    LocalDate today = LocalDate.now();
    LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
    System.out.println("Date before 1 year : " + previousYear);

    LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
    System.out.println("Date after 1 year : " + nextYear);
}
```

![图片](data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==)图片

### 10.使用Java 8的Clock时钟类

Java 8增加了一个 Clock 时钟类用于获取当时的时间戳，或当前时区下的日期时间信息。以前用到System.currentTimeInMillis() 和 TimeZone.getDefault() 的地方都可用Clock替换。

```
public void clock(){
    // 根据系统时间返回当前时间并设置为UTC。
    Clock clock = Clock.systemUTC();
    System.out.println("Clock : " + clock);

    // 根据系统时钟区域返回时间
    Clock defaultClock = Clock.systemDefaultZone();
    System.out.println("Clock : " + clock);
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99t5EkIJmrTgibwkToOUTaBFMmaMlmQkRXbR4IGj5TG9SROV2OnOUxh9GA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 11.判断日期是早于还是晚于另一个日期

LocalDate 类有两类方法 `isBefore()` 和 `isAfter()` 用于比较日期。调用 `isBefore()`方法时，如果给定日期小于当前日期则返回 true。

```
//如何用Java判断日期是早于还是晚于另一个日期
public void isBeforeOrIsAfter(){
    LocalDate today = LocalDate.now();

    LocalDate tomorrow = LocalDate.of(2018, 1, 29);
    if(tomorrow.isAfter(today)){
        System.out.println("Tomorrow comes after today");
    }

    //减去一天
    LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);

    if(yesterday.isBefore(today)){
        System.out.println("Yesterday is day before today");
    }
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tPDgYhZGcbqgJlQK0VKen004SNVmue1ltE9TbeX8NIdURk8w1o5lM7Q/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 12.处理时区

Java 8不仅分离了日期和时间，也把时区分离出来了。现在有一系列单独的类如 ZoneId 来处理特定时区，ZoneDateTime 类来表示某时区下的时间。

```
//获取特定时区下面的时间
public void getZoneTime(){
    //设置时区
    ZoneId america = ZoneId.of("America/New_York");

    LocalDateTime localtDateAndTime = LocalDateTime.now();

    ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
    System.out.println("现在的日期和时间在特定的时区 : " + dateAndTimeInNewYork);
}
```

![图片](data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==)图片

### 13.如何体现出固定日期

例如：表示信用卡到期这类固定日期。与 MonthDay 检查重复事件的例子相似，`YearMonth` 是另一个组合类，用于表示信用卡到期日、FD到期日、期货期权到期日等。还可以用这个类得到 当月共有多少天，YearMonth 实例的 `lengthOfMonth()` 方法可以返回当月的天数，在判断2月有28天还是29天时非常有用。

```
//使用 YearMonth类处理特定的日期
public void checkCardExpiry(){
    YearMonth currentYearMonth = YearMonth.now();
    System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

    YearMonth creditCardExpiry = YearMonth.of(2028, Month.FEBRUARY);
    System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tJoWcXIjovbKghpZn305IoObedk7O4sOHWWjBj5JQwK3SoXOjvJfBRQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 14.检查闰年

LocalDate类有一个很实用的方法 `isLeapYear()` 判断该实例是否是一个闰年，如果你还是想重新发明轮子，这有一个代码示例，纯Java逻辑编写的判断闰年的程序。

```
//检查闰年
public void isLeapYear(){
    LocalDate today = LocalDate.now();
    if(today.isLeapYear()){
        System.out.println("This year is Leap year");
    }else {
        System.out.println("2018 is not a Leap year");
    }
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tic1jVhibBtRK9pIWGe6Et4pNl3dSVzNibwZicvWSybD380y3gGic40s9BWQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 15.计算两个日期之间的天数和月数

有一个常见日期操作是计算两个日期之间的天数、周数或月数。在Java 8中可以用java.time.Period类来做计算。下面这个例子中，我们计算了当天和将来某一天之间的月数。下面的例子：现在是一月份，距离到五月份，中间相隔3月

```
//计算两个日期之间的天数和月数
public void calcDateDays(){
    LocalDate today = LocalDate.now();

    LocalDate java8Release = LocalDate.of(2018, Month.MAY, 14);

    Period periodToNextJavaRelease = Period.between(today, java8Release);

    System.out.println("Months left between today and Java 8 release : "
                                           + periodToNextJavaRelease.getMonths() );
}
```

![图片](data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==)图片

### 16.包含时差信息的日期和时间

ZoneOffset类用来表示时区，举例来说印度与GMT或UTC标准时区相差+05:30，可以通过ZoneOffset.of()静态方法来 获取对应的时区。一旦得到了时差就可以通过传入LocalDateTime和ZoneOffset来创建一个OffSetDateTime对象。

```
public void ZoneOffset(){
    LocalDateTime datetime = LocalDateTime.of(2018, Month.FEBRUARY, 14, 19, 30);
    ZoneOffset offset = ZoneOffset.of("+05:30");
    OffsetDateTime date = OffsetDateTime.of(datetime, offset);
    System.out.println("Date and Time with timezone offset in Java : " + date);
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tDfbUhgJEH9h5PRXd3C2H7eZCGMGUe17D9xmkKTtfl4ujGnNW1xRsBA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 17.获取当前的时间戳

Instant类有一个静态工厂方法now()会返回当前的时间戳，如下所示：

```
public void getTimestamp(){
    Instant timestamp = Instant.now();
    System.out.println("What is value of this instant " + timestamp);
}
```

![图片](https://mmbiz.qpic.cn/mmbiz_png/6mychickmupWdx1iaqrRl512WdRqG9c99tgcHk7F2JVoSibIMWXTFEO6MMWTR3NictLB28ElaKV0iaUB9dqT2b6lP0w/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)图片

### 18.使用预定义的格式化工具去解析或格式化日期

Java 8引入了全新的日期时间格式工具，线程安全而且使用方便。它自带了一些常用的内置格式化工具。下面这个例子使用了BASIC_ISO_DATE格式化工具将2018年2月10日格式化成20180210。

```
// 使用预定义的格式化工具去解析或格式化日期
public void formateDate(){
    String dayAfterTommorrow = "20180210";
    LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
    System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
}
```

![图片](data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==)图片

## 最后

最后附上全部代码

```
package com.wq.study.java8.date;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTest {

    //获取今天的日期
    public void getCurrentDate(){
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);

        //这个是作为对比
        Date date = new Date();
        System.out.println(date);
    }

    //获取年、月、日信息
    public void getDetailDate(){
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.printf("Year : %d  Month : %d  day : %d t %n", year, month, day);
    }

    //处理特定日期
    public void handleSpecilDate(){
        LocalDate dateOfBirth = LocalDate.of(2018, 01, 21);
        System.out.println("The specil date is : " + dateOfBirth);
    }

    //判断两个日期是否相等
    public void compareDate(){
        LocalDate today = LocalDate.now();
        LocalDate date1 = LocalDate.of(2018, 01, 21);

        if(date1.equals(today)){
            System.out.printf("TODAY %s and DATE1 %s are same date %n", today, date1);
        }
    }

    //处理周期性的日期
    public void cycleDate(){
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2018, 01, 21);

        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);

        if(currentMonthDay.equals(birthday)){
           System.out.println("Many Many happy returns of the day !!");
        }else{
           System.out.println("Sorry, today is not your birthday");
        }
    }

    //获取当前时间
    public void getCurrentTime(){
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);
    }

    //增加小时
    public void plusHours(){
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2); // 增加两小时
        System.out.println("Time after 2 hours : " +  newTime);
    }

    //如何计算一周后的日期
    public void nextWeek(){
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);
    }

    //计算一年前或一年后的日期
    public void minusDate(){
        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Date after 1 year : " + nextYear);
    }

    public void clock(){
        // 根据系统时间返回当前时间并设置为UTC。
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        // 根据系统时钟区域返回时间
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + clock);
    }

    //如何用Java判断日期是早于还是晚于另一个日期
    public void isBeforeOrIsAfter(){
        LocalDate today = LocalDate.now();

        LocalDate tomorrow = LocalDate.of(2018, 1, 29);
        if(tomorrow.isAfter(today)){
            System.out.println("Tomorrow comes after today");
        }

        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);

        if(yesterday.isBefore(today)){
            System.out.println("Yesterday is day before today");
        }
    }

    //时区处理
    public void getZoneTime(){
        //设置时区
        ZoneId america = ZoneId.of("America/New_York");

        LocalDateTime localtDateAndTime = LocalDateTime.now();

        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
        System.out.println("现在的日期和时间在特定的时区 : " + dateAndTimeInNewYork);
    }

    //使用 YearMonth类处理特定的日期
    public void checkCardExpiry(){
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2028, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }

    //检查闰年
    public void isLeapYear(){
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
           System.out.println("This year is Leap year");
        }else {
            System.out.println("2018 is not a Leap year");
        }
    }

    //计算两个日期之间的天数和月数
    public void calcDateDays(){
        LocalDate today = LocalDate.now();

        LocalDate java8Release = LocalDate.of(2018, Month.MAY, 14);

        Period periodToNextJavaRelease = Period.between(today, java8Release);

        System.out.println("Months left between today and Java 8 release : "
                                           + periodToNextJavaRelease.getMonths() );
    }

    // 包含时差信息的日期和时间
    public void ZoneOffset(){
        LocalDateTime datetime = LocalDateTime.of(2018, Month.FEBRUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }

    // 获取时间戳
    public void getTimestamp(){
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
    }

    // 使用预定义的格式化工具去解析或格式化日期
    public void formateDate(){
        String dayAfterTommorrow = "20180210";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
    }

    public static void main(String[] args) {
        DateTest dt = new DateTest();

        dt.formateDate();
    }

}
```

## 总结

```
Java 8日期时间API的重点
1）提供了javax.time.ZoneId 获取时区。
2）提供了LocalDate和LocalTime类。
3）Java 8 的所有日期和时间API都是不可变类并且线程安全，而现有的Date和Calendar API中的java.util.Date和SimpleDateFormat是非线程安全的。
4）主包是 java.time,包含了表示日期、时间、时间间隔的一些类。里面有两个子包java.time.format用于格式化， java.time.temporal用于更底层的操作。
5）时区代表了地球上某个区域内普遍使用的标准时间。每个时区都有一个代号，格式通常由区域/城市构成（Asia/Tokyo），在加上与格林威治或 UTC的时差。例如：东京的时差是+09:00。
```