package edu.agic.itblog.service;

import edu.agic.itblog.dao.UserDao;
import edu.agic.itblog.entity.UserEty;
import edu.agic.itblog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 21:53
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao;

    public Integer insert(UserEty user) {
        user.setUserid(UUIDUtil.get());
        user.setRegisttime(LocalDateTime.now());
        user.setRole("普通用户");
        Integer insert = userDao.insert(user);
        return insert;
    }

    public Integer delete(String userid) {
        return userDao.delete(userid);
    }

    public String selectOnePasswordByUserid(String userid) {
        return userDao.selectOnePasswordByUserid(userid);
    }

    public List<UserEty> selectList() {
        return userDao.selectList();
    }

    public UserEty selectOneByUserid(String userid) {
        return userDao.selectOneByUserid(userid);
    }

    public UserEty selectOneByUsername(String username) {
        return userDao.selectOneByUsername(username);
    }

    public UserEty selectOneByEmail(String email) {
        return userDao.selectOneByEmail(email);
    }

    public List<UserEty> selectListByRole(String role) {
        return userDao.selectListByRole(role);
    }

    public Integer update(UserEty user) {
        return userDao.update(user);
    }


}
