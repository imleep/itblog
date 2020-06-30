package edu.agic.itblog.util;


import java.util.UUID;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 17:58
 */
public class UUIDUtil {
    public static String get() {
        return UUID.randomUUID().toString().replaceAll("-", "").toString();
    }
}
