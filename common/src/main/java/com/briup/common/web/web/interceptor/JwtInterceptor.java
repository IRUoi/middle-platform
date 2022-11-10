package com.briup.common.web.web.interceptor;

import com.briup.common.web.util.JwtUtil;
import com.briup.common.web.web.exception.CustomerException;
import com.briup.common.web.web.response.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/8/2022-11-08-7:53 PM
 * @Description：com.briup.common.web.web.interceptor
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、获取请求头中的token
        String token = request.getHeader("Authorization");
        //2、如果为空，未登录
        if(!StringUtils.hasText(token)){
            throw new CustomerException(ResultCode.USER_NOT_LOGIN);
        }
        //3、token过期 token篡改 token是否合法
        JwtUtil.checkSign(token);
        //4、取出token的信息 业务操作
        Map<String,Object> info = JwtUtil.getInfo(token);
        info.forEach((k,v) -> System.out.println(k+" = " + v));
        return true;
    }
}
