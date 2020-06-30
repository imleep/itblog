package edu.agic.itblog.entity;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 18:00
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.List;

/**
 * CREATE TABLE `t_blog` (
 *   `blogid` char(32) NOT NULL,
 *   `userid` char(32) NOT NULL,
 *   `title` char(64) NOT NULL,
 *   `content` text NOT NULL,
 *   `createtime` datetime NOT NULL,
 *   `updatetime` datetime NOT NULL,
 *   `display` int(11) NOT NULL COMMENT '0:不可见 |1:可见',
 *   PRIMARY KEY (`blogid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * */
public class BlogEty {

    private String blogid; // PRIMARY KEY (`blogid`)
    private String title;
    private String userid;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private LocalDateTime createtime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private LocalDateTime updatetime;
    private Integer display; // 0:不可见 | 1:可见
    private Integer readCount;

    private List<BlogClickEty> clickEtyListUp;
    private List<BlogClickEty> clickEtyListDown;
    private List<BlogReadEty> readEtyList;

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public List<BlogClickEty> getClickEtyListUp() {
        return clickEtyListUp;
    }

    public void setClickEtyListUp(List<BlogClickEty> clickEtyListUp) {
        this.clickEtyListUp = clickEtyListUp;
    }

    public List<BlogClickEty> getClickEtyListDown() {
        return clickEtyListDown;
    }

    public void setClickEtyListDown(List<BlogClickEty> clickEtyListDown) {
        this.clickEtyListDown = clickEtyListDown;
    }

    public List<BlogReadEty> getReadEtyList() {
        return readEtyList;
    }

    public void setReadEtyList(List<BlogReadEty> readEtyList) {
        this.readEtyList = readEtyList;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }
}
