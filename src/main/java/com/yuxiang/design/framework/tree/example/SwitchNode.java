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
public class SwitchNode extends AbstractStrategyRouter<RequestParameter, DynamicParameter, ReturnResult> {


    @Resource
    private ErrorNode errorNode;


    @Override
    public ReturnResult apply(RequestParameter requestParameter, DynamicParameter dynamicParameter) {
        System.out.println("执行SwitchNode节点的业务。。。。。");
        requestParameter.setValue("我是switch节点做的事");
        return router(requestParameter, dynamicParameter);
    }

    @Override
    public StrategyHandler<RequestParameter, DynamicParameter, ReturnResult> get(RequestParameter requestParameter, DynamicParameter dynamicParameter) {
        System.out.println("映射下一个节点,errorNode");
        return errorNode;
    }
}
