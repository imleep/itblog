package edu.agic.itblog.dao;

import edu.agic.itblog.entity.FileEty;

import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 18:52
 */
public interface FileDao {
    // 上传文件
    Integer insert(FileEty file);
    // 删除文件
    Integer delete(String fileid);
    // 获取所有文件列表
    List<FileEty> selectList();
    // 获得某一个文件
    FileEty selectOneByFileid(String fileid);
    // 获取某用户上传的所有文件列表
    List<FileEty> selectListByUserid(String userid);
}
