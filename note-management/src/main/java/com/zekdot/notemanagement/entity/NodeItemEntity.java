package com.zekdot.notemanagement.entity;

import lombok.Data;

import java.util.Map;

/** 节点项目
 * Create by zekdot on 2021/8/30.
 */
@Data
public class NodeItemEntity {
    // 是否是文件夹
    private boolean isDir;
    // 节点名称
    private String name;
    // 节点下一层访问地址
    private String address;
    // 节点图标
    private String icon;
    // 其他属性
    private Map<String, Object> others;
}
