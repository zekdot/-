package com.zekdot.notemanagement.action;

import com.zekdot.notemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zekdot on 2021/9/1.
 */
@RestController
@RequestMapping("/user")
public class UserAction {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username, String password) {
        return userService.login(username, password).toString();
    }

    /**
     * 判断是否登录
     * @return
     */
    @RequestMapping("/isLogin")
    public String isLogin() {
        return userService.isLogin().toString();
    }
}
