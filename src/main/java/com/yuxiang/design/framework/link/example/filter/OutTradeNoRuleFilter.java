package com.yuxiang.design.framework.link.example.filter;

import com.yuxiang.design.framework.link.example.TradeSettlementRuleFilterFactory;
import com.yuxiang.design.framework.link.example.entity.TradeSettlementRuleCommandEntity;
import com.yuxiang.design.framework.link.example.entity.TradeSettlementRuleFilterBackEntity;
import com.yuxiang.design.framework.link.handler.ILogicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OutTradeNoRuleFilter implements ILogicHandler<TradeSettlementRuleCommandEntity, TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> {

    @Override
    public TradeSettlementRuleFilterBackEntity apply(TradeSettlementRuleCommandEntity requestParameter, TradeSettlementRuleFilterFactory.DynamicContext dynamicContext) {
        String number = "12345678";
        boolean isTrue = number.equals(requestParameter.getOutTradeNo());
        log.info("外部唯一单号校验，{},{}",requestParameter.getOutTradeNo(),isTrue);

        return next(requestParameter, dynamicContext);
    }
}
