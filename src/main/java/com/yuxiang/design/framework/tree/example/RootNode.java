package com.yuxiang.design.framework.tree.example;

import com.yuxiang.design.framework.tree.AbstractStrategyRouter;
import com.yuxiang.design.framework.tree.StrategyHandler;
import com.yuxiang.design.framework.tree.StrategyMapper;
import com.yuxiang.design.framework.tree.types.DynamicParameter;
import com.yuxiang.design.framework.tree.types.RequestParameter;
import com.yuxiang.design.framework.tree.types.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
@Slf4j
public class RootNode extends AbstractStrategyRouter<RequestParameter, DynamicParameter, ReturnResult> {


    @Resource
    private SwitchNode switchNode;


    @Override
    public ReturnResult apply(RequestParameter requestParameter, DynamicParameter dynamicParameter) {
        System.out.println("执行RootNode节点的业务。。。。。");
        requestParameter.setName("我是root节点做的事");
        return router(requestParameter, dynamicParameter);
    }

    @Override
    public StrategyHandler<RequestParameter, DynamicParameter, ReturnResult> get(RequestParameter requestParameter, DynamicParameter dynamicParameter) {
        System.out.println("映射下一个节点,switchNode");
        return switchNode;
    }
}
