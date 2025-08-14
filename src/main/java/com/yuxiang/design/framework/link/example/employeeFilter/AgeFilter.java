package com.yuxiang.design.framework.link.example.employeeFilter;

import com.yuxiang.design.framework.link.example.EmployeeInformationRuleFilterFactory;
import com.yuxiang.design.framework.link.example.entity.TradeSettlementRuleFilterBackEntity;
import com.yuxiang.design.framework.link.example.entity.UserInformationEntity;
import com.yuxiang.design.framework.link.example.entity.UserInformationRuleFilterBackEntity;
import com.yuxiang.design.framework.link.handler.ILogicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AgeFilter implements ILogicHandler<UserInformationEntity, EmployeeInformationRuleFilterFactory.DynamicContext, UserInformationRuleFilterBackEntity> {
    @Override
    public UserInformationRuleFilterBackEntity apply(UserInformationEntity requestParameter, EmployeeInformationRuleFilterFactory.DynamicContext dynamicContext) {
        log.info("年龄过滤");

        return UserInformationRuleFilterBackEntity.builder().build();
    }
}
