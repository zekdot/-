package com.zekdot.notemanagement.dao;

import com.zekdot.notemanagement.entity.NodeItemEntity;
import com.zekdot.notemanagement.exception.FileAlreadyExistException;
import com.zekdot.notemanagement.exception.NotDirectionException;
import com.zekdot.notemanagement.exception.NotEmptyDirectionException;

import java.io.IOException;
import java.util.List;

/**
 * Create by zekdot on 2021/8/30.
 */
public interface NodeDao {
    /**
     * 根据地址获取节点列表
     * @param address 目录地址，需要保证该地址为一个目录地址，否则可能出错
     * @return
     */
    List<NodeItemEntity> getNodes(String address) throws NotDirectionException, IOException;

    /**
     * 添加一个新的节点
     * @param address 要添加的地址
     * @param name 节点名称
     * @param isDir 是否是根目录
     * @return
     */
    boolean addNode(String address, String name, boolean isDir) throws NotDirectionException, FileAlreadyExistException, IOException;

    /**
     * 删除一个节点
     * @param address 节点的完整地址
     * @return
     */
    boolean delNode(String address) throws NotEmptyDirectionException;

    /**
     * 更新节点名称
     * @param address 完整节点地址
     * @param newName 节点的新名称
     * @return
     */
    boolean updateNode(String address, String newName);
    /**
     * 根据地址获取节点，该地址需要保证是一个文件地址，否则可能出错
     * @param address
     * @return
     */
    NodeItemEntity getNode(String address);


}
