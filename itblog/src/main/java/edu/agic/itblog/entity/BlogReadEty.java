package edu.agic.itblog.entity;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 18:12
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * CREATE TABLE `t_blog_read` (
 * `readid` char(32) NOT NULL,
 * `blogid` char(32) NOT NULL,
 * `userid` char(32) NOT NULL,
 * `readtime` datetime NOT NULL,
 * PRIMARY KEY (`readid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class BlogReadEty {
    String readid;
    String blogid;
    String userid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    LocalDateTime readtime;

    public String getReadid() {
        return readid;
    }

    public void setReadid(String readid) {
        this.readid = readid;
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public LocalDateTime getReadtime() {
        return readtime;
    }

    public void setReadtime(LocalDateTime readtime) {
        this.readtime = readtime;
    }
}
