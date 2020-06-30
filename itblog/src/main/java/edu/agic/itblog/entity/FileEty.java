package edu.agic.itblog.entity;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 18:14
 */


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
/**
 * CREATE TABLE `t_file` (
 * `fileid` char(32) NOT NULL,
 * `filetype` char(32) NOT NULL COMMENT 'avatar|appendix|source',
 * `filename` char(128) NOT NULL,
 * `userid` char(32) NOT NULL,
 * `size` bigint(20) NOT NULL,
 * `uploadtime` datetime NOT NULL,
 * PRIMARY KEY (`fileid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class FileEty {

    String fileid;
    String filetype;
    String filename;
    String userid;
    Long size;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    LocalDateTime uploadtime;

    public FileEty() {
    }

    public FileEty(String fileid, String filetype, String filename, String userid, Long size, LocalDateTime uploadtime) {
        this.fileid = fileid;
        this.filetype = filetype;
        this.filename = filename;
        this.userid = userid;
        this.size = size;
        this.uploadtime = uploadtime;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public LocalDateTime getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(LocalDateTime uploadtime) {
        this.uploadtime = uploadtime;
    }
}
