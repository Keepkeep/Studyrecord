package com.study.jdk.studydate;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * 使用 Instant ： 时间戳（以Unix 元年 ： 1970-01-01 00：00：00 到某个时间之间的毫秒数）
 */
public class StudyInstant {
    public static void main(String[] args) {
        // 用来记录应用程序中的事件时间戳
        //获取当前时间 默认获取 UTC 时区
        Instant now = Instant.now();
        System.out.println(now);

        // 获取中国时区时间
        Instant instant = Instant.now().atOffset(ZoneOffset.ofHours(8)).toInstant();
        System.out.println(instant);

        //between   minus

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
