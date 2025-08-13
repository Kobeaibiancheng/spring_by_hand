package com.yuxiang.design.framework.link.example;

import com.yuxiang.design.framework.link.LinkArmory;
import com.yuxiang.design.framework.link.chain.BusinessLinkedList;
import com.yuxiang.design.framework.link.example.entity.GroupBuyTeamEntity;
import com.yuxiang.design.framework.link.example.entity.MarketPayOrderEntity;
import com.yuxiang.design.framework.link.example.entity.TradeSettlementRuleCommandEntity;
import com.yuxiang.design.framework.link.example.entity.TradeSettlementRuleFilterBackEntity;
import com.yuxiang.design.framework.link.example.filter.EndRuleFilter;
import com.yuxiang.design.framework.link.example.filter.OutTradeNoRuleFilter;
import com.yuxiang.design.framework.link.example.filter.SCRuleFilter;
import com.yuxiang.design.framework.link.example.filter.SettableRuleFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TradeSettlementRuleFilterFactory {


    @Bean("tradeSettlementRuleFilter")
    public BusinessLinkedList<TradeSettlementRuleCommandEntity,
                DynamicContext, TradeSettlementRuleFilterBackEntity> tradeSettlementRuleFilter(
            SCRuleFilter scRuleFilter,
            OutTradeNoRuleFilter outTradeNoRuleFilter,
            SettableRuleFilter settableRuleFilter,
            EndRuleFilter endRuleFilter) {

        // 组装链
        LinkArmory<TradeSettlementRuleCommandEntity, DynamicContext, TradeSettlementRuleFilterBackEntity> linkArmory =
                new LinkArmory<>("交易结算规则过滤链", scRuleFilter, outTradeNoRuleFilter, settableRuleFilter, endRuleFilter);

        // 链对象
        return linkArmory.getLogicLink();
    }



    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {
        // 订单营销实体对象
        private MarketPayOrderEntity marketPayOrderEntity;
        // 拼团组队实体对象
        private GroupBuyTeamEntity groupBuyTeamEntity;
    }
}
