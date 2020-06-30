package edu.agic.itblog.service;

import edu.agic.itblog.dao.BlogReadDao;
import edu.agic.itblog.entity.BlogReadEty;
import edu.agic.itblog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 23:00
 */
@Service
@Transactional
public class BlogReadService {
    @Autowired
    BlogReadDao blogReadDao;

    public Integer insert(BlogReadEty read) {
        read.setReadid(UUIDUtil.get());
        read.setReadtime(LocalDateTime.now());
        return blogReadDao.insert(read);
    }

    public List<BlogReadEty> selectListByBlogid(String blogid) {
        return blogReadDao.selectListByBlogid(blogid);
    }

    public List<String> selectListByUserid(String userid) {
        return blogReadDao.selectListByUserid(userid);
    }

    public Map<String, Integer> countRead() {
        return blogReadDao.countRead();
    }
}
