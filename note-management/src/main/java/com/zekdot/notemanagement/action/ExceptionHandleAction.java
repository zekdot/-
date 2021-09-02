package com.zekdot.notemanagement.action;

import cn.dev33.satoken.exception.NotLoginException;
import com.zekdot.notemanagement.dto.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.xml.sax.ErrorHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by zekdot on 2021/9/1.
 */
@ControllerAdvice
public class ExceptionHandleAction{

    @ExceptionHandler(value = NotLoginException.class)
    @ResponseBody
    public String notLoginHandler(NotLoginException e){
        return new Envelope(1024, "请先登录", null).toString();
    }
}
