package com.yuxiang.springframework.beans.factory.support;

import com.yuxiang.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.BeansException;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {

        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            //
        }

        addSingleton(beanName, bean);
        return bean;
    }
}
