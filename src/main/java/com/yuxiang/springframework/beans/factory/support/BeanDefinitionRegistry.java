package com.yuxiang.springframework.beans.factory.support;

import com.yuxiang.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
