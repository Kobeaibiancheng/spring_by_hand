package com.yuxiang.design.framework.link.example.employeeFilter;

import com.yuxiang.design.framework.link.example.EmployeeInformationRuleFilterFactory;
import com.yuxiang.design.framework.link.example.entity.UserInformationEntity;
import com.yuxiang.design.framework.link.example.entity.UserInformationRuleFilterBackEntity;
import com.yuxiang.design.framework.link.handler.ILogicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class NameFilter implements ILogicHandler<UserInformationEntity, EmployeeInformationRuleFilterFactory.DynamicContext, UserInformationRuleFilterBackEntity> {
    @Override
    public UserInformationRuleFilterBackEntity apply(UserInformationEntity requestParameter, EmployeeInformationRuleFilterFactory.DynamicContext dynamicContext) {

        log.info("名称过滤");
        return next(requestParameter,dynamicContext);
    }
}
