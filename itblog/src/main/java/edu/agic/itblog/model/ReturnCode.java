package edu.agic.itblog.model;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 23:15
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 返回值:处理结果信息
 * */
public class ReturnCode {
    private static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(1000, "用户登录成功");
        map.put(1001, "登录验证信息已经过期，请尝试重新登录");
        map.put(1002, "该操作需要登录，请前往登录页面登录");
        map.put(1003, "用户登录失败，登录名不存在");
        map.put(1004, "用户登录失败，登录名或密码错误");
        map.put(1005, "用户登录失败，服务器异常，请稍候重试");
        map.put(1006, "用户登录失败，登录名或密码不得为空");
        map.put(1007, "用户信息获取成功");
        map.put(1008, "信息修改失败，无法获得修改信息的权限");
        map.put(1009, "系统错误,请稍候重试");
        map.put(1010, "用户信息修改成功");

        map.put(2000, "用户注册成功，即将跳转至登录页面");
        map.put(2001, "用户注册失败，用户名重复");
        map.put(2002, "用户注册失败，邮箱已被占用");
        map.put(2003, "用户注册失败，服务器异常，请稍候重试");

        map.put(3000, "博客发布成功");
        map.put(3001, "博客发表失败，服务器异常，请稍候重试");
        map.put(3002, "博客点击成功");
        map.put(3003, "博客点击失败，服务器异常，请稍候重试");
        map.put(3004, "博客无法编辑，您不是博客的作者");
        map.put(3005, "博客查询成功");
        map.put(3006, "博客查询失败，请重试");
        map.put(3007, "博客编辑成功");
        map.put(3008, "博客编辑失败，请重新尝试");

        map.put(4000, "博客类型添加成功");
        map.put(4001, "博客类型添加失败，服务器异常，请稍候重试");

        map.put(5000, "文件上传成功");
        map.put(5001, "文件为0字节");
        map.put(5002, "文件过大，限制在");
        map.put(5003, "文件不能为空");
    }
    public static String get(int code) {
        return map.get(code);
    }
}