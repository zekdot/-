package com.zekdot.notemanagement.service.impl;

import com.zekdot.notemanagement.dao.NoteDao;
import com.zekdot.notemanagement.dto.Envelope;
import com.zekdot.notemanagement.service.NoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Create by zekdot on 2021/9/1.
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Resource
    private NoteDao noteDao;
    
    @Override
    public Envelope updateContent(String address, String newContent) {
        try {
            if(noteDao.updateContent(address, newContent)){
                return Envelope.SUCCESS;
            }else{
                return Envelope.systemError;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Envelope.systemError;
        }
    }
}
