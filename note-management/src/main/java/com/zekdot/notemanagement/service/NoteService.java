package com.zekdot.notemanagement.service;

import com.zekdot.notemanagement.dto.Envelope;

/**
 * Create by zekdot on 2021/9/1.
 */
public interface NoteService {
    /**
     * 更新节点文件内容
     * @param address 地址
     * @param newContent 新内容
     * @return
     */
    Envelope updateContent(String address, String newContent);
}
