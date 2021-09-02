package com.zekdot.notemanagement.action;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.zekdot.notemanagement.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zekdot on 2021/9/1.
 */
@RestController
@RequestMapping("/note")
public class NoteAction {
    @Autowired
    private NoteService noteService;

    /**
     * 更新笔记内容
     * @param address
     * @param newContent
     * @return
     */
    @SaCheckLogin
    @RequestMapping(value = "/updateContent", method = RequestMethod.POST)
    public String updateContent(String address, String newContent) {
        return noteService.updateContent(address, newContent).toString();
    }

}
