package com.zekdot.notemanagement.service;

import com.zekdot.notemanagement.dto.Envelope;

/**
 * Create by zekdot on 2021/8/30.
 */
public interface NodeService {
    /**
     * 获取某个地址之下的节点
     * @param address
     * @return
     */
    Envelope getNodes(String address);

    /**
     * 给某个地址下面增加节点
     * @param address
     * @param name
     * @return
     */
    Envelope addNode(String address, String name, boolean isDir);

    /**
     *  删除地址对应的文件
     * @param address
     * @return
     */
    Envelope delNode(String address);

    /**
     * 修改地址对应的文件名
     * @param address 地址
     * @param newName 新的名称
     * @return
     */
    Envelope updateNode(String address, String newName);
}
