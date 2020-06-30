package edu.agic.itblog.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 23:55
 */
public class TimeStampUtil {
    public static long get() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    } // string length is 13

}
