package edu.agic.itblog.dao;

import edu.agic.itblog.entity.UserEty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 18:19
 */
public interface UserDao {
    // 增加用户
    Integer insert(UserEty user);

    // 删除用户
    Integer delete(String userid);

    // 获取某用户的密码
    String selectOnePasswordByUserid(String userid);

    // 获取所有用户列表
    List<UserEty> selectList();

    // 根据userid获取某个用户（唯一）
    UserEty selectOneByUserid(String userid);

    // 根据username获取用户（唯一）
    UserEty selectOneByUsername(String username);

    // 根据邮箱获取用户（唯一）
    UserEty selectOneByEmail(String email);

    // 更具role角色获取用户
    List<UserEty> selectListByRole(String role);

    // 修改某用户信息,如果不修改哪一个字段，置null即可
    Integer update(UserEty user);
}
