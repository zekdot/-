package com.zekdot.notemanagement.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Create by zekdot on 20-1-10.
 */
@Component
public class ConfigInfo {
    @Value("${config.notepath}")
    public String notepath;
}
