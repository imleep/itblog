package edu.agic.itblog.interceptor;

import com.google.gson.Gson;
import edu.agic.itblog.model.ReturnModel;
import edu.agic.itblog.util.ReturnUtil;
import edu.agic.itblog.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/27 2:13
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        if (token == null) {
            response.getWriter().print(new Gson().toJson(ReturnUtil.get(1002, null)));
            return false;
        }else if (TokenUtil.checkToken(token) == false) { // token未通过验证
            response.getWriter().print(new Gson().toJson(ReturnUtil.get(1001, null)));
            return false;
        }
        return true;
    }
}
