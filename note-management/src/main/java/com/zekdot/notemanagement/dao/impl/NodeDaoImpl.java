package com.zekdot.notemanagement.dao.impl;

import com.zekdot.notemanagement.dao.NodeDao;
import com.zekdot.notemanagement.entity.NodeItemEntity;
import com.zekdot.notemanagement.exception.FileAlreadyExistException;
import com.zekdot.notemanagement.exception.NotDirectionException;
import com.zekdot.notemanagement.exception.NotEmptyDirectionException;
import com.zekdot.notemanagement.utils.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by zekdot on 2021/8/30.
 */
@Repository
public class NodeDaoImpl implements NodeDao {
    @Autowired
    private ConfigInfo configInfo;

    @Override
    public List<NodeItemEntity> getNodes(String address) throws NotDirectionException, IOException {
        address = address.replace("..", "/");
        String dir = configInfo.notepath + "/" + address;
        File root = new File(dir);
        if(root == null || !root.isDirectory()){
            throw new NotDirectionException();
        }
        List<NodeItemEntity> res = new ArrayList<>();
        File[] listFiles = root.listFiles();
        for(File file : listFiles){
            NodeItemEntity nodeItemEntity = new NodeItemEntity();
            // 是否为目录
            nodeItemEntity.setDir(file.isDirectory());
            // 设置名称
            nodeItemEntity.setName(file.getName());
            // 设置路径
//            nodeItemEntity.setAddress(file.getPath().replace(configInfo.notepath, "/"));
            nodeItemEntity.setAddress(file.getName());
            res.add(nodeItemEntity);
        }
        return res;
    }

    @Override
    public boolean addNode(String address, String name, boolean isDir) throws NotDirectionException, FileAlreadyExistException, IOException {
        address = address.replace("..", "/");
        String dir = configInfo.notepath + "/" + address;
        File root = new File(dir);
        if(!root.exists() || !root.isDirectory()){
            throw new NotDirectionException();
        }
        File newFile = new File(dir + "/" + name);
        if(newFile.exists()){
            throw new FileAlreadyExistException();
        }
//        System.out.println(newFile.getAbsolutePath());
        if(isDir){
            return newFile.mkdir();
        }else{
            return newFile.createNewFile();
        }
    }

    @Override
    public boolean delNode(String address) throws NotEmptyDirectionException {
        address = address.replace("..", "/");
        String dir = configInfo.notepath + "/" + address;
        File root = new File(dir);
        if(!root.exists()){
            return true;
        }
//        System.out.println(root.list());
        if(root.isDirectory() && root.listFiles().length > 0){
            throw new NotEmptyDirectionException();
        }
        return root.delete();
    }

    @Override
    public boolean updateNode(String address, String newName) {
        address = address.replace("..", "/");
        String dir = configInfo.notepath + "/" + address;
        File root = new File(dir);
        if(!root.exists()){
            return true;
        }
        dir = dir.substring(0, dir.lastIndexOf("/")) + "/" + newName;
        System.out.println(dir);
        return root.renameTo(new File(dir));
    }

    @Override
    public NodeItemEntity getNode(String address) {
//        NodeItemEntity nodeItemEntity = new NodeItemEntity();
//        nodeItemE
        return null;
    }
}
