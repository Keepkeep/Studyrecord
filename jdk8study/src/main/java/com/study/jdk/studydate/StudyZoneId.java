package com.study.jdk.studydate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Set;

public class StudyZoneId {
    //一个ZoneId用于识别用于Instant和LocalDateTime之间的转换规则
    public static void main(String[] args) {
        //获取所有的id
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.println(availableZoneId);
        }
        
        // 获取 默认时区  输出Asia/Shanghai
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.printf("获取时区%s\n",zoneId);

        //获取不同的时区
        ZoneId zoneid1 = ZoneId.of("Asia/Kolkata");
        ZoneId zoneid2 = ZoneId.of("Asia/Tokyo");
        ZoneId zoneid3 = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(Instant.now(), zoneid1);
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.now(), zoneid2);
        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(Instant.now(), zoneid3);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);

        //获取文本区域表示
        //获取区域的文本表示形式
        //输出中国时间
        ZoneId zoneid4 = ZoneId.of("Asia/Shanghai");
        System.out.println("获取文本格式的时区"+zoneid4.getDisplayName(TextStyle.FULL, Locale.CHINA));

        //获取反结果nodeid
        ZoneId zoneid5 = ZoneId.of("Asia/Shanghai");
        System.out.println(zoneid5.normalized());

        //
    }
}
