package edu.agic.itblog.service;

import edu.agic.itblog.dao.BlogClickDao;
import edu.agic.itblog.entity.BlogClickEty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 23:06
 */
@Service
@Transactional
public class BlogClickService {
    @Autowired
    BlogClickDao blogClickDao;

    public Integer insert(BlogClickEty click) {
        click.setClicktime(LocalDateTime.now());
        return blogClickDao.insert(click);
    }

    public Integer delete(String userid, String blogid) {
        return blogClickDao.delete(userid, blogid);
    }

    public List<BlogClickEty> selectListByBlogid(String blogid, Integer clicktype) {
        return blogClickDao.selectListByBlogid(blogid, clicktype);
    }

    public List<BlogClickEty> selectListByUserid(String userid, Integer clicktype) {
        return blogClickDao.selectListByUserid(userid, clicktype);
    }

    public BlogClickEty selectOneByUseridToBlogid(String userid, String blogid) {
        return blogClickDao.selectOneByUseridToBlogid(userid, blogid);
    }
}
