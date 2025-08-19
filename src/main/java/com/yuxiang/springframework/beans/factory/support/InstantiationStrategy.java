package com.yuxiang.springframework.beans.factory.support;


import com.yuxiang.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.BeansException;


import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws Exception;

}
