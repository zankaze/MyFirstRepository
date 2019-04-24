package com.xa.fourth_p.utils;

import com.xa.fourth_p.pojo.AdminUser;
import com.xa.fourth_p.pojo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InterceptorConfig implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("开始拦截");
        String uri = request.getRequestURI();
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");
        AdminUser ad = (AdminUser) session.getAttribute("admin");

        if (user != null || ad != null || uri.indexOf("doRes") >= 0 || uri.indexOf("getEmail") >= 0
                || uri.indexOf("doLogin") >= 0 || uri.indexOf("login.html") >= 0 || uri.indexOf("register.html") >= 0) {
            log.info("未拦截");
            if(user != null&&user.getUserlevel().equals("0")&&uri.indexOf("snake.html")>0){
                log.info("非VIP拦截");
                response.sendRedirect("index.html");
                return false;
            }
            if (user != null&&ad==null&&(uri.indexOf("viewUserinfo.html") >= 0||uri.indexOf("updateQes.html") >= 0||uri.indexOf("updateGoods.html") >= 0
                    ||uri.indexOf("testQue.html") >= 0||uri.indexOf("orderForm.html") >= 0||uri.indexOf("goodsphoto.html") >= 0
                   ||uri.indexOf("addUserinfo.html") >= 0||uri.indexOf("addGoods.html") >= 0||uri.indexOf("users.html")>0
            ||uri.indexOf("goods.html")>0)){
                log.info("非管理员拦截");
                response.sendRedirect("index.html");
                return false;
            }
            if(user==null&&ad!=null&&(!((uri.indexOf("viewUserinfo.html") >= 0||uri.indexOf("updateQes.html") >= 0||uri.indexOf("updateGoods.html") >= 0
                    ||uri.indexOf("testQue.html") >= 0||uri.indexOf("orderForm.html") >= 0||uri.indexOf("goodsphoto.html") >= 0
                    ||uri.indexOf("addUserinfo.html") >= 0||uri.indexOf("addGoods.html") >= 0||uri.indexOf("users.html") >= 0||uri.indexOf("goods.html")>0)))){
                log.info("管理员拦截");
                response.sendRedirect("users.html");
                return false;
            }
            return true;
        }else{
            log.info("拦截成功");
            response.sendRedirect("login.html");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
