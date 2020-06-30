package edu.agic.itblog.dao;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 19:06
 */

import edu.agic.itblog.entity.BlogClickEty;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * CREATE TABLE `t_blog_click` (
 *   `blogid` char(32) NOT NULL,
 *   `userid` char(32) NOT NULL,
 *   `clicktype` int(11) NOT NULL,
 *   `clicktime` datetime NOT NULL,
 *   PRIMARY KEY (`blogid`,`userid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public interface BlogClickDao {
    // 添加一条喜欢或踩记录
    Integer insert(BlogClickEty click);

    // 删除某用户对某文章的点击记录
    Integer delete(@Param("userid") String userid, @Param("blogid") String blogid);

    // 获得某篇文章被点击的记录
    List<BlogClickEty> selectListByBlogid(@Param("blogid") String blogid, @Param("clicktype") Integer clicktype);

    // 获得某用户点击过的文章
    List<BlogClickEty> selectListByUserid(@Param("userid") String userid, @Param("clicktype") Integer clicktype);

    // 获得某用户对某篇文章的点击类型
    BlogClickEty selectOneByUseridToBlogid(@Param("userid") String userid, @Param("blogid") String blogid);



}
