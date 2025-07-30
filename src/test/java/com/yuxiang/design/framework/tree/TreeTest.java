package com.yuxiang.design.framework.tree;

import com.yuxiang.design.framework.tree.example.RootNode;
import com.yuxiang.design.framework.tree.types.DynamicParameter;
import com.yuxiang.design.framework.tree.types.RequestParameter;
import com.yuxiang.design.framework.tree.types.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@Slf4j
@SpringBootTest
public class TreeTest {
    @Resource
    private RootNode rootNode;
    @Test
    public void treeTest(){
        RequestParameter requestParameter = new RequestParameter();
        DynamicParameter dynamicParameter = new DynamicParameter();
        //RootNode rootNode = new RootNode();
        ReturnResult returnResult = rootNode.apply(requestParameter, dynamicParameter);
    }
}
