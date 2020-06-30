package edu.agic.itblog.service;

import edu.agic.itblog.dao.BlogDao;
import edu.agic.itblog.dao.UserDao;
import edu.agic.itblog.entity.BlogEty;
import edu.agic.itblog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 22:11
 */
@Service
@Transactional
public class BlogService {

    @Autowired
    BlogDao blogDao;

    public Integer insert(BlogEty blog) {
        blog.setBlogid(UUIDUtil.get());
        LocalDateTime now = LocalDateTime.now();
        blog.setCreatetime(now);
        blog.setUpdatetime(now);
        return blogDao.insert(blog);
    }

    
    public Integer delete(String blogid) {
        return blogDao.delete(blogid);
    }

    
    public BlogEty selectOneByBlogid(String blogid) {
        return blogDao.selectOneByBlogid(blogid);
    }

    
    public List<BlogEty> selectList() {
        return blogDao.selectList();
    }

    
    public List<BlogEty> selectListBydisplay(Integer display) {
        return blogDao.selectListByDisplay(display);
    }

    
    public List<BlogEty> selectListByUserid(String userid) {
        return blogDao.selectListByUserid(userid);
    }

    
    public Integer update(BlogEty blog) {
        blog.setUpdatetime(LocalDateTime.now());
        return blogDao.update(blog);
    }
}
