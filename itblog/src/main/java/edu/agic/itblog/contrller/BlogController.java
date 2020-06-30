package edu.agic.itblog.contrller;

import edu.agic.itblog.dao.BlogReadDao;
import edu.agic.itblog.entity.BlogClickEty;
import edu.agic.itblog.entity.BlogEty;
import edu.agic.itblog.model.ReturnModel;
import edu.agic.itblog.service.BlogClickService;
import edu.agic.itblog.service.BlogReadService;
import edu.agic.itblog.service.BlogService;
import edu.agic.itblog.util.ReturnUtil;
import edu.agic.itblog.util.TokenUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/27 0:45
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    BlogReadService blogReadService;
    @Autowired
    BlogClickService blogClickService;

    // 增加博客
    @PostMapping("article/add")
    @ResponseBody
    public ReturnModel add(BlogEty blog, HttpServletRequest req) { // String title, String content, Integer display
        try {
            String userid = TokenUtil.parseToUserid(req.getHeader("token"));
            if (userid == null) {
                return ReturnUtil.get(1001, null);
            }
            blog.setUserid(userid);
            Integer insert = blogService.insert(blog);
            if (1 == insert) {
                return ReturnUtil.get(3000, blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.get(3001, null);
        }
        return ReturnUtil.get(3001, null);
    }

    // 获取某一篇 api
    @GetMapping("api/article/get/{blogid}")
    @ResponseBody
    public ReturnModel get(@PathVariable("blogid") String blogid) {
        try {
            BlogEty blog = blogService.selectOneByBlogid(blogid);
            blog = BlogCompleteUtil.completeBlog(blog);
            return ReturnUtil.get(3005, blog);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.get(3006, null);
        }
    }

    // 获取博客列表 api
    @GetMapping("api/article/all/list")
    @ResponseBody
    public ReturnModel list() {
        try {
            List<BlogEty> blogs = BlogCompleteUtil.completeBlogs(blogService.selectList());
            return ReturnUtil.get(3005, blogs);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.get(3006, null);
        }
    }

    // 获取某用户的博客列表 api
    @GetMapping("api/article/list/{userid}")
    @ResponseBody
    public ReturnModel list(@PathVariable String userid) {
        try {
            List<BlogEty> blogs = BlogCompleteUtil.completeBlogs(blogService.selectListByUserid(userid));
            return ReturnUtil.get(3005, blogs);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.get(3006, null);
        }
    }

    // 某用户给博客点击
    @PostMapping("article/click/{blogid}/{clicktype}")
    @ResponseBody
    public ReturnModel click(@PathVariable("blogid") String blogid, @PathVariable("clicktype") Integer clicktype, HttpServletRequest req) {
        try {
            // 通过token获取userid
            String userid = TokenUtil.parseToUserid(req.getHeader("token"));
            if (userid == null)
                return ReturnUtil.get(1001, null);
            BlogClickEty blogClickEty = new BlogClickEty();
            blogClickEty.setUserid(userid);
            blogClickEty.setBlogid(blogid);
            blogClickEty.setClicktype(clicktype);
            if (null != blogClickService.selectOneByUseridToBlogid(userid, blogid))
                blogClickService.delete(userid, blogid);
            return blogClickService.insert(blogClickEty) == 1 ? ReturnUtil.get(3002, blogClickEty) : ReturnUtil.get(3003, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.get(3003, null);
        }
    }

    // 某用户阅读过的博客列表
    @GetMapping("api/article/list/read/{userid}")
    @ResponseBody
    public ReturnModel readHistory(@PathVariable("userid") String userid) {
        try {
            List<String> blogids = blogReadService.selectListByUserid(userid);
            List<BlogEty> blogs = new ArrayList<>();
            for (String blogid : blogids) {
                BlogEty blogEty = blogService.selectOneByBlogid(blogid);
                BlogEty blog = BlogCompleteUtil.completeBlog(blogEty);
                blogs.add(blog);
            }
            return ReturnUtil.get(3005, blogs);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.get(3006, null);
        }
    }

    // 某用户修改/编辑博客
    @PostMapping("article/edit")
    @ResponseBody
    public ReturnModel updateArticle(BlogEty blogEty, HttpServletRequest req) {
        // 首先获取用户的userid，重复检测
        try {
            String userid = TokenUtil.parseToUserid(req.getHeader("token"));
            if (userid == null) {
                return ReturnUtil.get(1001, null);
            }
            if (blogEty.getUserid().equals(userid)) {
                blogService.update(blogEty);
                return ReturnUtil.get(3007, blogEty);
            } else {
                return ReturnUtil.get(3004, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.get(3008, null);
        }
    }

}

class BlogCompleteUtil {
    @Autowired
    static BlogService blogService;
    @Autowired
    static BlogReadService blogReadService;
    @Autowired
    static BlogClickService blogClickService;

    // 填充点击 和 阅读 记录
    public static BlogEty completeBlog(BlogEty blog) {
        String blogid = blog.getBlogid();
        blog.setReadEtyList(blogReadService.selectListByBlogid(blogid));
        blog.setClickEtyListUp(blogClickService.selectListByBlogid(blogid, 1)); // 喜欢
        blog.setClickEtyListDown(blogClickService.selectListByBlogid(blogid, -1)); // 踩
        blog.setReadCount(blogReadService.countRead().get(blogid));
        return blog;
    }

    public static List<BlogEty> completeBlogs(List<BlogEty> blogs) {
        for (int i = 0; i < blogs.size(); i++) {
            completeBlog(blogs.get(i));
        }
        return blogs;
    }
}
