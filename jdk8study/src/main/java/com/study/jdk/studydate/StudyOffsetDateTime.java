package com.study.jdk.studydate;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class StudyOffsetDateTime {
    /**
     *一个时区偏移量从格林尼治/ UTC，如 +02:00。
     * 这个类是不可变的和线程安全的。
     */
    public static void main(String[] args) {

        //创建offserDatetime
        OffsetDateTime now = OffsetDateTime.now();
        System.out.println(now);

        //字符串转OffsetDatetime
        String DATE_TIME_SECOND_STRING = "yyyy-MM-dd HH:mm:ss";
        String value = "2020-06-02 10:01:15";
        // 方法一
        // 先转换为localdatetime 再调用zonedDateTime的of方法
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_SECOND_STRING);
        LocalDateTime parse1 = LocalDateTime.parse(value, dateTimeFormatter);
        System.out.printf("转换时间%s\n",parse1);
        // 结果
        OffsetDateTime offsetDateTime = ZonedDateTime.of(parse1, ZoneId.of("US/Pacific")).toOffsetDateTime();
        System.out.println("时间  "+ offsetDateTime);

        // localdateTime 直接转换为offsetDateTime
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("US/Pacific"));
        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(localDateTime, ZoneOffset.of("+8"));
        System.out.println("localTime装换为offsetDateTime  "+offsetDateTime1);
        //或者使用
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(8));
        System.out.println("localTime装换为offsetDateTime  "+offsetDateTime2);

    }
}
