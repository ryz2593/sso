package com.ryz2593.service;

import com.alibaba.fastjson.JSON;
import com.ryz2593.common.redis.RedisService;
import com.ryz2593.common.redis.SystemConstant;
import com.ryz2593.domain.UserInfo;
import com.ryz2593.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ryz2593
 * @date 2019/4/11
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisService redisService;

    @Override
    public UserInfo login(HttpServletResponse response, UserInfo user) {
        if ("admin".equals(user.getUserName()) && "123".equals(user.getUserPass())) {
            //生成一个会话ID
            String sessionId = UUIDUtil.getUUID();

            //把生成的会话ID,存储到redis
            redisService.set(sessionId, JSON.toJSONString(user));
            //设置redis中key的有效期
            redisService.expire(sessionId, SystemConstant.SESSION_TIME_OUT);

            //把指定的cookie的ID值发送到客户端保存
            Cookie cookie = new Cookie(SystemConstant.COOKIE_NAME, sessionId);
            //设置cookie的访问域
            //cookie.setDomain(".gerry.com");
            //设置cookie的访问路径
            cookie.setPath("/");
            //设置cookie的有效时间
            cookie.setMaxAge(SystemConstant.SESSION_TIME_OUT);
            //发送cookie到客户端
            response.addCookie(cookie);
        }

        return null;
    }

    @Override
    public UserInfo getTokenByUser(HttpServletRequest request, String token) {

        return null;
    }
}
