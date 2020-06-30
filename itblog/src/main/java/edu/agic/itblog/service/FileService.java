package edu.agic.itblog.service;

import edu.agic.itblog.dao.FileDao;
import edu.agic.itblog.entity.FileEty;
import edu.agic.itblog.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 22:19
 */
@Service
@Transactional
public class FileService {
    @Autowired
    FileDao fileDao;

    public Integer insert(FileEty file) {
        return fileDao.insert(file);
    }

    public Integer delete(String fileid) {
        return fileDao.delete(fileid);
    }

    public List<FileEty> selectList() {
        return fileDao.selectList();
    }

    public FileEty selectOneByFileid(String fileid) {
        return fileDao.selectOneByFileid(fileid);
    }

    public List<FileEty> selectListByUserid(String userid) {
        return fileDao.selectListByUserid(userid);
    }
}
