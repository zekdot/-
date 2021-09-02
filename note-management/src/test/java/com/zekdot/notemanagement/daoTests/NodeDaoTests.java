package com.zekdot.notemanagement.daoTests;

import com.alibaba.fastjson.JSONObject;
import com.zekdot.notemanagement.NoteManagementApplicationTests;
import com.zekdot.notemanagement.dao.NodeDao;
import com.zekdot.notemanagement.exception.FileAlreadyExistException;
import com.zekdot.notemanagement.exception.NotDirectionException;
import com.zekdot.notemanagement.exception.NotEmptyDirectionException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Create by zekdot on 2021/8/30.
 */
public class NodeDaoTests extends NoteManagementApplicationTests {

    @Resource
    private NodeDao nodeDao;

    @Test
    public void getNodes(){
        try {
            Assert.assertTrue(JSONObject.toJSONString(nodeDao.getNodes("/")).length() > 0);
            Assert.assertTrue(JSONObject.toJSONString(nodeDao.getNodes("/nginx")).length() > 0);
            Assert.assertTrue(JSONObject.toJSONString(nodeDao.getNodes("/..")).length() > 0);
        } catch (NotDirectionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addNode(){
        try {
            Assert.assertTrue(nodeDao.addNode("nginx", "test", true));
            Assert.assertTrue(nodeDao.addNode("nginx", "file.md", false));
        } catch (NotDirectionException e) {
            e.printStackTrace();
        } catch (FileAlreadyExistException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delNode(){
        try {
            Assert.assertTrue(nodeDao.delNode("nginx/test"));
            Assert.assertTrue(nodeDao.delNode("nginx/test.md"));
        } catch (NotEmptyDirectionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateNode(){
        Assert.assertTrue(nodeDao.updateNode("nginx/file.md", "test.md"));
    }

    @Test
    public void getNode(){

    }
}
