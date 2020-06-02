package com.study.jdk.studydate;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class StudyZonedDateTime {

    //zonedDateTime 带时区的时间日期
    public static void main(String[] args) {
        // 输出所有时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
        // 带时区的时间或日期
        // 2020-06-25T22:58:50.537-08:00[US/Pacific] 太平洋时区
        System.out.println(ZonedDateTime.now(ZoneId.of("US/Pacific")));

        // 获取时区时间
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime from = ZonedDateTime.from(LocalDateTime.now().atZone(zoneId));
        System.out.println(from);

        //localdatetime 转换zonedDatetime
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("US/Pacific"));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(zonedDateTime));

        //zonedDatetime 转换为localdatetime
        LocalDate localDate = zonedDateTime.toLocalDate();
        System.out.println("转换为本地时间 "+localDate);

        // 一样的get获取，plus加时间，minus减时间...

    }
}
