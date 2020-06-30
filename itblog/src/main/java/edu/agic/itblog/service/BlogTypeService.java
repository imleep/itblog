package edu.agic.itblog.service;

import edu.agic.itblog.dao.BlogTypeDao;
import edu.agic.itblog.entity.BlogTypeEty;
import edu.agic.itblog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 23:02
 */
@Service
@Transactional
public class BlogTypeService {
    @Autowired
    BlogTypeDao blogTypeDao;

    public Integer insert(BlogTypeEty blogType) {
        blogType.setTypeid(UUIDUtil.get());
        return blogTypeDao.insert(blogType);
    }

    public Integer delete(String typeid) {
        return blogTypeDao.delete(typeid);
    }

    public List<String> selectListParent() {
        return blogTypeDao.selectListParent();
    }

    public List<BlogTypeEty> selectList() {
        return blogTypeDao.selectList();
    }

    public Integer update(BlogTypeEty blogType) {
        return blogTypeDao.update(blogType);
    }
}
