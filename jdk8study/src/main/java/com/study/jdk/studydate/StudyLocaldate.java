package com.study.jdk.studydate;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class StudyLocaldate {
    public static void main(String[] args) {
        //Java8里面新出来了一些API，LocalDate、LocalTime、LocalDateTime 非常好用 注意使用的时候确认下数据库驱动的版本否则会报错误
        //产考博客：https://blog.csdn.net/qq_40006446/article/details/80535359
        //jdk 1.8 时间日期函数API
        //只有时间的函数 localdate 构造函数为私有的所以不能使用构造函数获取
        LocalDate localDate = LocalDate.now();
        //输出格式为2020-06-01
        System.out.println(localDate);
        // of() 设置指定的年月日时分秒  体现不偏移性
        LocalDateTime dateTime = LocalDateTime.of(2019, 04, 10, 23, 03);
        System.out.println("设置时间日期"+dateTime);
        //带有时间日期
        LocalDateTime now = LocalDateTime.now();
        //输出2020-06-01T23:53:51.392
        System.out.println(now);

        //底层LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute)的实现
        //  LocalDate date = LocalDate.of(year, month, dayOfMonth);
        //  LocalTime time = LocalTime.of(hour, minute);
        //  return new LocalDateTime(date, time);
        //  由上可以发现LocalDateTime通过localdate 和localTime 构建成的


        //时间格式化
        // 格式化日期 --- > 字符串
        //预定义的标准格式  ISO_LOCAL_DATE_TIME,ISO_LOCAL_DATE,ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(formatter.format(now));  //2020-06-01T23:58:51.996
        System.out.println(now);    //2020-06-01T23:58:51.996

        // 字符串--->时间
        TemporalAccessor parse = formatter.parse("2020-06-01T23:58:51.996");
        System.out.println(parse);

        //自定义时间格式
        // ofPattern("yyyy-MM-dd hh:mm:ss") -->和SimpleDateFormat相似
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println("自定义格式"+format);

        //时间比较
        LocalDateTime now2 = LocalDateTime.now();
        LocalDateTime befornow = LocalDateTime.of(2018, 9, 01, 8, 36);
        boolean before = befornow.isBefore(now);
        System.out.println("之前时间"+before);

        //获取LocalDateTime年月日
        LocalDateTime now3 = LocalDateTime.now();
        System.out.println("获取年"+now3.getYear()+"获取月份"+now3.getDayOfMonth()+"获取时间"+now3.getHour()+"获取分"+now3.getMinute()+"获取秒"+now3.getSecond());;

        //时间操作减时间
        //去年该时刻
        LocalDateTime localDateTime = now3.minusYears(1);
        // 减去一个月
        LocalDateTime localDateTime1 = now3.minusMonths(1);
        //上周时间
        LocalDateTime localDateTime2 = now3.minusWeeks(1);
        System.out.println(localDateTime);

        // 时间加的操作
        LocalDateTime now4 = LocalDateTime.now();
        LocalDateTime localDateTime3 = now4.plusYears(1);
        LocalDateTime localDateTime4 = now4.plusMonths(1);
        System.out.println( localDateTime3);

        //计算时间差
        LocalDateTime now5 = LocalDateTime.now();
        LocalDateTime now6 = LocalDateTime.of(2019,6,2,10,26,12);
        Duration between = Duration.between(now6, now5);

        System.out.println("相隔多少天："+between.toDays()+"相隔多少个小时"+between.toHours());

        //通过时间戳
        LocalDateTime localDateTime5 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.printf("获取的时间%s\n",DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(localDateTime5));


    }

    //将java.util.Date 转换为java8 的java.time.LocalDateTime,默认时区为东8区
    public static LocalDateTime dateConvertToLocalDateTime(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }


    //将java8 的 java.time.LocalDateTime 转换为 java.util.Date，默认时区为东8区
    public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
    }

}
