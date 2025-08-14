package com.yuxiang.design.framework.link.example.employeeFilter;

import com.yuxiang.dao.UserDao;
import com.yuxiang.design.framework.link.example.EmployeeInformationRuleFilterFactory;
import com.yuxiang.design.framework.link.example.entity.UserInformationEntity;
import com.yuxiang.design.framework.link.example.entity.UserInformationRuleFilterBackEntity;
import com.yuxiang.design.framework.link.example.repository.IUserRepository;
import com.yuxiang.design.framework.link.handler.ILogicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Slf4j
@Service
public class NameFilter implements ILogicHandler<UserInformationEntity, EmployeeInformationRuleFilterFactory.DynamicContext, UserInformationRuleFilterBackEntity> {

    @Resource
    private IUserRepository userRepository;

    @Override
    public UserInformationRuleFilterBackEntity apply(UserInformationEntity requestParameter, EmployeeInformationRuleFilterFactory.DynamicContext dynamicContext) {

        log.info("名称过滤");
        String id = requestParameter.getId();
        UserDao userDao = userRepository.queryUserInformationById(id);
        System.out.println(userDao);
        return next(requestParameter,dynamicContext);
    }
}
