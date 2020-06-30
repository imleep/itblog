package edu.agic.itblog.entity;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 17:53
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * CREATE TABLE `t_user` (
 *   `userid` char(32) NOT NULL,
 *   `username` char(32) NOT NULL,
 *   `realname` char(32) NOT NULL,
 *   `birthday` date NOT NULL,
 *   `email` char(32) NOT NULL,
 *   `password` char(32) NOT NULL,
 *   `avatar` char(32) DEFAULT NULL,
 *   `registtime` datetime NOT NULL,
 *   `role` char(16) NOT NULL,
 *   PRIMARY KEY (`userid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * */
public class UserEty {

    private String userid; // 主键，有java生成uuid
    private String username;
    private String realname;
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    private LocalDate birthday;
    private String email;
    private String password;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private LocalDateTime registtime;
    private String role;
    private String avatar;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisttime() {
        return registtime;
    }

    public void setRegisttime(LocalDateTime regtime) {
        this.registtime = regtime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
