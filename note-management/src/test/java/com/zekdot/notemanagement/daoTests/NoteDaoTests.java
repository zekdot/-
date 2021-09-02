package com.zekdot.notemanagement.daoTests;

import com.zekdot.notemanagement.NoteManagementApplicationTests;
import com.zekdot.notemanagement.dao.NoteDao;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Create by zekdot on 2021/9/1.
 */
public class NoteDaoTests extends NoteManagementApplicationTests {
    @Resource
    private NoteDao noteDao;

    @Test
    public void updateContent(){
        try {
            Assert.assertTrue(noteDao.updateContent("nginx/test.md", "# Hello \n## this is a test"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
