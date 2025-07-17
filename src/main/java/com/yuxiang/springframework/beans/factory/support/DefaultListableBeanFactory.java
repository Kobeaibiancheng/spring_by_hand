package com.yuxiang.springframework.beans.factory.support;

import com.yuxiang.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.BeansException;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }


    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            System.out.println("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }


    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return null;
    }
}
