package com.study.jdk.studydate;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class StudyLocaldate {
    public static void main(String[] args) {
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


    }
}
