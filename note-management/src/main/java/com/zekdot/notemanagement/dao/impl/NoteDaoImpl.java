package com.zekdot.notemanagement.dao.impl;

import com.zekdot.notemanagement.dao.NoteDao;
import com.zekdot.notemanagement.exception.NotEmptyDirectionException;
import com.zekdot.notemanagement.utils.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;

/**
 * Create by zekdot on 2021/9/1.
 */
@Repository
public class NoteDaoImpl implements NoteDao {
    @Autowired
    private ConfigInfo configInfo;
    @Override
    public boolean updateContent(String address, String newContent) throws IOException {
        address = address.replace("..", "/");
        String dir = configInfo.notepath + "/" + address;
        File root = new File(dir);
        OutputStream outputStream = new FileOutputStream(root);
        byte[] b = newContent.getBytes();
        outputStream.write(b);
        outputStream.close();
        return true;
    }
}
