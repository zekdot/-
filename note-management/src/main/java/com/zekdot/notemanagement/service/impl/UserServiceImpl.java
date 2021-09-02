package com.zekdot.notemanagement.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.zekdot.notemanagement.dto.Envelope;
import com.zekdot.notemanagement.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Create by zekdot on 2021/9/1.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Envelope login(String username, String password) {

        if("zekdot".equals(username) && "123456".equals(password)) {
            StpUtil.login(username);
            return Envelope.SUCCESS;
        }else{
            return new Envelope(1, "用户名或密码错误", null);
        }
    }

    @Override
    public Envelope isLogin() {
        return new Envelope(StpUtil.isLogin());
    }
}
