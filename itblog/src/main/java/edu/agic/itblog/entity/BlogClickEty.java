package edu.agic.itblog.entity;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 18:10
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * CREATE TABLE `t_blog_click` (
 *   `blogid` char(32) NOT NULL,
 *   `userid` char(32) NOT NULL,
 *   `clicktype` int(11) NOT NULL,
 *   `clicktime` datetime NOT NULL,
 *   PRIMARY KEY (`blogid`,`userid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class BlogClickEty {
    String blogid; // PRIMARY KEY (`blogid`,`userid`)
    String userid; // PRIMARY KEY (`blogid`,`userid`)
    Integer clicktype; // 1 b | -1 p
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    LocalDateTime clicktime;

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

    public Integer getClicktype() {
        return clicktype;
    }

    public void setClicktype(Integer clicktype) {
        this.clicktype = clicktype;
    }

    public LocalDateTime getClicktime() {
        return clicktime;
    }

    public void setClicktime(LocalDateTime clicktime) {
        this.clicktime = clicktime;
    }
}
