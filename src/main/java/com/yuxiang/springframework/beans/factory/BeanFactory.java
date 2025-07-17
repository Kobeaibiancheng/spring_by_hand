package com.yuxiang.springframework.beans.factory;

import org.springframework.beans.BeansException;

public interface BeanFactory {
    public Object getBean(String name);

    Object getBean(String name, Object... args) throws BeansException;//
}
