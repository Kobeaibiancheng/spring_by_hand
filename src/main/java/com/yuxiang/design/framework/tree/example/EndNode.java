package com.yuxiang.design.framework.tree.example;

import com.yuxiang.design.framework.tree.AbstractStrategyRouter;
import com.yuxiang.design.framework.tree.StrategyHandler;
import com.yuxiang.design.framework.tree.StrategyMapper;
import com.yuxiang.design.framework.tree.types.DynamicParameter;
import com.yuxiang.design.framework.tree.types.RequestParameter;
import com.yuxiang.design.framework.tree.types.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EndNode extends AbstractStrategyRouter<RequestParameter, DynamicParameter, ReturnResult> {
    @Override
    public ReturnResult apply(RequestParameter requestParameter, DynamicParameter dynamicParameter) {
        System.out.println("正在执行EndNode节点的业务。。。");
        requestParameter.setChannel("我是end节点做的事");
        return new ReturnResult("结束");
    }

    @Override
    public StrategyHandler<RequestParameter, DynamicParameter, ReturnResult> get(RequestParameter requestParameter, DynamicParameter dynamicParameter) {
        return defaultStrategyHandler;
    }
}
