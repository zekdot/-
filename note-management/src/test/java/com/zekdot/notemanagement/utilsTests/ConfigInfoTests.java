package com.zekdot.notemanagement.utilsTests;

import com.zekdot.notemanagement.NoteManagementApplicationTests;
import com.zekdot.notemanagement.utils.ConfigInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by zekdot on 2021/8/30.
 */
public class ConfigInfoTests extends NoteManagementApplicationTests {

    @Autowired
    private ConfigInfo configInfo;

    @Test
    public void notepath(){
        Assert.assertNotNull(configInfo.notepath);
    }

}
