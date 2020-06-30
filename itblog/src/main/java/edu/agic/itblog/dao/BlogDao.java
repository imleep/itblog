package edu.agic.itblog.dao;

import edu.agic.itblog.entity.BlogEty;

import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 18:32
 */
public interface BlogDao {
    // 添加博客
    Integer insert(BlogEty blog);

    // 删除一篇博客blogid
    Integer delete(String blogid);

    // 获取某一篇博客blogid
    BlogEty selectOneByBlogid(String blogid);

    // 获取所有博客列表 admin
    List<BlogEty> selectList();

    // 通过display获取博客列表
    List<BlogEty> selectListByDisplay(Integer display);

    // 获取某用户的所有博客
    List<BlogEty> selectListByUserid(String userid);

    // 修改某一篇博客
    Integer update(BlogEty blog);

}
