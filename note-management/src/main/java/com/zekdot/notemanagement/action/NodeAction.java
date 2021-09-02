package com.zekdot.notemanagement.action;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.zekdot.notemanagement.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zekdot on 2021/8/30.
 */
@RestController
@RequestMapping("/node")
public class NodeAction {

    @Autowired
    private NodeService nodeService;

    /**
     * 根据地址获取节点
     * @param address
     * @return
     */
    @RequestMapping("/getNodes")
    public String getNodes(String address){
        return nodeService.getNodes(address).toString();
    }

    /**
     * 添加新节点
     * @param address 节点地址
     * @param name 节点名称
     * @param isDir 是否为目录
     * @return
     */
    @SaCheckLogin
    @RequestMapping(value = "/addNode", method = RequestMethod.POST)
    public String addNode(String address, String name, boolean isDir) {
        return nodeService.addNode(address, name, isDir).toString();
    }

    /**
     * 删除节点
     * @param address 节点地址
     * @return
     */
    @SaCheckLogin
    @RequestMapping(value = "/delNode", method = RequestMethod.POST)
    public String delNode(String address) {
        return nodeService.delNode(address).toString();
    }

    /**
     * 更新节点名称
     * @param address
     * @param newName
     * @return
     */
    @SaCheckLogin
    @RequestMapping(value = "/updateNode", method = RequestMethod.POST)
    public String updateNode(String address, String newName){
        return nodeService.updateNode(address, newName).toString();
    }
}
