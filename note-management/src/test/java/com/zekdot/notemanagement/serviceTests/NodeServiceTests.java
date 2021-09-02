package com.zekdot.notemanagement.serviceTests;

import com.zekdot.notemanagement.NoteManagementApplicationTests;
import com.zekdot.notemanagement.dto.Envelope;
import com.zekdot.notemanagement.service.NodeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by zekdot on 2021/8/30.
 */
public class NodeServiceTests extends NoteManagementApplicationTests {
    @Autowired
    private NodeService nodeService;

    @Test
    public void getNodes(){
        System.out.println(nodeService.getNodes("/"));
        System.out.println(nodeService.getNodes("/nginx"));
    }
}
