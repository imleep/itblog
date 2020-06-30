package edu.agic.itblog.dao;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 19:00
 */

import edu.agic.itblog.entity.BlogReadEty;

import java.util.List;
import java.util.Map;

/**
 * CREATE TABLE `t_blog_read` (
 * `readid` char(32) NOT NULL,
 * `blogid` char(32) NOT NULL,
 * `userid` char(32) NOT NULL,
 * `readtime` datetime NOT NULL,
 * PRIMARY KEY (`readid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public interface BlogReadDao {
    // 增加阅读记录
    Integer insert(BlogReadEty read);
    // 获得某篇博客的阅读记录
    List<BlogReadEty> selectListByBlogid(String blogid);
    // 获得或用户阅读过的文章
    List<String> selectListByUserid(String userid);
    // 统计每篇文章的阅读次数
    Map<String, Integer> countRead();


}
