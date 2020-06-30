package edu.agic.itblog.contrller;

import edu.agic.itblog.entity.UserEty;
import edu.agic.itblog.model.ReturnModel;
import edu.agic.itblog.util.ReturnUtil;
import edu.agic.itblog.service.UserService;
import edu.agic.itblog.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/27 0:43
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ReturnModel login(String loginname, String password) {
        if (loginname == null || loginname.length() == 0 || password == null || password.length() == 0) {
            return ReturnUtil.get(1006,null);
        }
        try {
            // 登录可以使用邮箱和用户名登录
            UserEty user = null;
            UserEty userEtyUsername = userService.selectOneByUsername(loginname);
            UserEty userEtyEmail = userService.selectOneByEmail(loginname);
            if (userEtyUsername != null) {
                user = userEtyUsername;
            } else if (userEtyEmail != null) {
                user = userEtyEmail;
            } else {
                return ReturnUtil.get(1003, null);
            }
            String userid = user.getUserid();
            if (!userService.selectOnePasswordByUserid(userid).equals(password)) {
                return ReturnUtil.get(1004, null);
            }
            String token = TokenUtil.get(userid);
            return ReturnUtil.get(1000, user);
        } catch (Exception e) { // 万一数据库没开
            System.out.println("异常：用户登录异常，" + e.getMessage());
            return ReturnUtil.get(1005, null);
        }
    }

    @PostMapping("/login/youke")
    @ResponseBody
    public ReturnModel youkeLogin() {
        try {
            // 可以直接使用游客登录
            UserEty youkeUser = userService.selectListByRole("游客").get(0);
            String token = TokenUtil.get(youkeUser.getUserid());
            return ReturnUtil.get(1000, token);
        } catch (Exception e) { // 万一数据库没开
            return ReturnUtil.get(1005, null);
        }
    }

    @RequestMapping("/regist")
    @ResponseBody
    public ReturnModel regist(UserEty userEty) {
        try {
            // 检测用户名重复
            if (userService.selectOneByUsername(userEty.getUsername()) != null) {
                return ReturnUtil.get(2001, null);
            } else if (userService.selectOneByEmail(userEty.getEmail())!= null) {
                return ReturnUtil.get(2002, null);
            }
            // 数据通过可以添加
            Integer insert = userService.insert(userEty);
            if (1 == insert) {
                return ReturnUtil.get(2000, null);
            } else {
                return ReturnUtil.get(2003, null);
            }
        } catch (Exception e) { // 万一数据库没开
            return ReturnUtil.get(2003, null);
        }
    }
    @GetMapping("/api/query/one/{userid}")
    @ResponseBody
    public ReturnModel info(@PathVariable("userid") String userid) {
        try {
            UserEty userEty = userService.selectOneByUserid(userid);
            return ReturnUtil.get(1007, userEty);
        } catch (Exception e) {
            return ReturnUtil.get(1009, null);
        }
    }
    @GetMapping("/api/query/list")
    @ResponseBody
    public ReturnModel list() {
        try {
            List<UserEty> userEties = userService.selectList();
            return ReturnUtil.get(1007, userEties);
        } catch (Exception e) {
            return ReturnUtil.get(1009, null);
        }
    }
    @PostMapping("/update")
    @ResponseBody
    public ReturnModel update(UserEty user, HttpServletRequest req) {
        String token = req.getHeader("token");
        String userid = TokenUtil.parseToUserid(token);
        // 管理员 和 信息的所有者 可修改
        boolean update = userService.selectOneByUserid(token).getRole().equals("管理员") || user.getUserid().equals(userid);
        try {
            if (update) {
                userService.update(user);
                return ReturnUtil.get(1010, null);
            } else {
                return ReturnUtil.get(1008, null);
            }
        } catch (Exception e) {
            return ReturnUtil.get(1009, null);
        }
    }


}
