package com.zekdot.notemanagement.service.impl;

import com.zekdot.notemanagement.dao.NodeDao;
import com.zekdot.notemanagement.dto.Envelope;
import com.zekdot.notemanagement.entity.NodeItemEntity;
import com.zekdot.notemanagement.exception.FileAlreadyExistException;
import com.zekdot.notemanagement.exception.NotDirectionException;
import com.zekdot.notemanagement.exception.NotEmptyDirectionException;
import com.zekdot.notemanagement.service.NodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Create by zekdot on 2021/8/30.
 */
@Service
public class NodeServiceImpl implements NodeService {
    @Resource
    private NodeDao nodeDao;
    @Override
    public Envelope getNodes(String address) {
        List<NodeItemEntity> list;

        try {
            list = nodeDao.getNodes(address);
        } catch (NotDirectionException e) {
            e.printStackTrace();
            return new Envelope(1, "非目录文件", null);
        } catch (IOException e) {
            e.printStackTrace();
            list = null;
        }
        return new Envelope(list);
    }

    @Override
    public Envelope addNode(String address, String name, boolean isDir) {
        try {
            if(nodeDao.addNode(address, name, isDir)){
                return Envelope.SUCCESS;
            }else{
                return Envelope.systemError;
            }
        } catch (NotDirectionException e) {
            e.printStackTrace();
            return new Envelope(1, "当前地址不是一个目录",null );
        } catch (FileAlreadyExistException e) {
            e.printStackTrace();
            return new Envelope(2, "此名称已经被占用", null);
        } catch (IOException e) {
            e.printStackTrace();
            return Envelope.systemError;
        }
    }

    @Override
    public Envelope delNode(String address) {
        try {
            if(nodeDao.delNode(address)){
                return Envelope.SUCCESS;
            }else{
                return Envelope.systemError;
            }
        } catch (NotEmptyDirectionException e) {
            e.printStackTrace();
            return new Envelope(1, "要删除的目录非空，需要先删除目录中的其他文件", null);
        }
    }

    @Override
    public Envelope updateNode(String address, String newName) {
        if(nodeDao.updateNode(address, newName)){
            return Envelope.SUCCESS;
        }else {
            return Envelope.systemError;
        }
    }
}
