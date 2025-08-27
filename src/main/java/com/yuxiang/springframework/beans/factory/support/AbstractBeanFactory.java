package com.yuxiang.springframework.beans.factory.support;





import com.yuxiang.springframework.beans.BeansException;
import com.yuxiang.springframework.beans.factory.BeanFactory;
import com.yuxiang.springframework.beans.factory.config.BeanDefinition;



public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {




    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition,args);
    }


    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
