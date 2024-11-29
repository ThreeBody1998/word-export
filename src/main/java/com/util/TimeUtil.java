package com.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description 时间工具类
 * @Author 周建泽
 * @Date 2024-11-27 11:47
 */
public class TimeUtil {
    /**
     * 获取当前时间戳
     * @return  当前时间戳 格式：yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTime(){
        //设置创建时间
        LocalDateTime now = LocalDateTime.now();
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
