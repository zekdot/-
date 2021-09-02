package com.zekdot.notemanagement.dao;

import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Create by zekdot on 2021/9/1.
 */
@Repository
public interface NoteDao {
    /**
     * 更新内容
     * @param address 笔记地址
     * @param newContent  新内容
     * @return
     */
    boolean updateContent(String address, String newContent) throws IOException;
}
