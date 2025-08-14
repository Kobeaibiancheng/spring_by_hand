package com.yuxiang.design.framework.link.example.filter;

import com.yuxiang.design.framework.link.example.TradeSettlementRuleFilterFactory;
import com.yuxiang.design.framework.link.example.entity.TradeSettlementRuleCommandEntity;
import com.yuxiang.design.framework.link.example.entity.TradeSettlementRuleFilterBackEntity;
import com.yuxiang.design.framework.link.handler.ILogicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SCRuleFilter implements ILogicHandler<TradeSettlementRuleCommandEntity, TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> {

    @Override
    public TradeSettlementRuleFilterBackEntity apply(TradeSettlementRuleCommandEntity requestParameter, TradeSettlementRuleFilterFactory.DynamicContext dynamicContext) {
        String s = "国家地理";

        String source = requestParameter.getSource();
        boolean isTrue = source.equals(s);
        log.info("sc校验，来源和渠道,{},{}",source,isTrue);

        return next(requestParameter, dynamicContext);
    }
}
