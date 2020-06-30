package edu.agic.itblog.dao;

import edu.agic.itblog.entity.BlogTypeEty;

import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 18:56
 */
public interface BlogTypeDao {
    // 增加类型
    Integer insert(BlogTypeEty blogType);

    // 删除子类型
    Integer delete(String typeid);

    // 查找所有一级列表
    List<String> selectListParent();

    // 查找所有二级列表
    List<BlogTypeEty> selectList();

    // 修改类别
    Integer update(BlogTypeEty blogType);
}
