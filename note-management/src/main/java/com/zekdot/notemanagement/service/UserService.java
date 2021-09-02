package com.zekdot.notemanagement.service;

import com.zekdot.notemanagement.dto.Envelope;

/**
 * Create by zekdot on 2021/9/1.
 */
public interface UserService {
    /**
     * 用户进行登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Envelope login(String username, String password);

    /**
     * 判断用户是否登录
     * @return
     */
    Envelope isLogin();
}
