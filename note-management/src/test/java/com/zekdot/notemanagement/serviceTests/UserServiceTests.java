package com.zekdot.notemanagement.serviceTests;

import com.zekdot.notemanagement.NoteManagementApplicationTests;
import com.zekdot.notemanagement.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by zekdot on 2021/9/1.
 */
public class UserServiceTests extends NoteManagementApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testLogin(){
        Assert.assertEquals(0, userService.login("zekdot", "123456").getCode());
        Assert.assertEquals(true, userService.isLogin().getObj());
        Assert.assertEquals(1, userService.login("zekdot", "123453").getCode());
    }
}
