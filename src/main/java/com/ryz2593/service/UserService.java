package com.ryz2593.service;

import com.ryz2593.domain.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ryz2593
 * @date 2019/4/11
 * @desc 用户对象的接口
 */
public interface UserService {

    /**
     * 定义登录的方法
     * @param user
     * @return
     */
    UserInfo login(HttpServletResponse response, UserInfo user);

    /**
     * 根据token获取到对应的用户对象
     * @param request
     * @param token
     * @return
     */
    UserInfo getTokenByUser(HttpServletRequest request, String token);
}
