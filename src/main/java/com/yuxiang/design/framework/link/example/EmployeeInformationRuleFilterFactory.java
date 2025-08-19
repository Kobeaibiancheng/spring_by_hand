package com.yuxiang.design.framework.link.example;

import com.yuxiang.design.framework.link.LinkArmory;
import com.yuxiang.design.framework.link.chain.BusinessLinkedList;
import com.yuxiang.design.framework.link.example.employeeFilter.AgeFilter;
import com.yuxiang.design.framework.link.example.employeeFilter.JobFilter;
import com.yuxiang.design.framework.link.example.employeeFilter.NameFilter;
import com.yuxiang.design.framework.link.example.entity.*;
import com.yuxiang.design.framework.link.example.filter.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeInformationRuleFilterFactory {

    @Bean("employeeInformationRuleFilter")
    public BusinessLinkedList<UserInformationEntity,
            EmployeeInformationRuleFilterFactory.DynamicContext, UserInformationRuleFilterBackEntity> employeeInformationRuleFilter(
            NameFilter nameFilter,
            JobFilter jobFilter,
            AgeFilter ageFilter) {

        // 组装链
        LinkArmory<UserInformationEntity, EmployeeInformationRuleFilterFactory.DynamicContext, UserInformationRuleFilterBackEntity> linkArmory =
                new LinkArmory<>("交易结算规则过滤链", nameFilter, jobFilter, ageFilter);

        // 链对象
        return linkArmory.getLogicLink();
    }

    @Bean("userInformationEntity")
    public UserInformationEntity userInformationEntity() {
        UserInformationEntity userInformationEntity = new UserInformationEntity("1","汪玉祥", 25, "陕西西安", "13572151005", "1244838148@qq.com", "学生");
        return userInformationEntity;
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
