package com.chunyue.springframeworkdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof com.chunyue.springframeworkdi.services.LifeCycleDemoBean){
            ((com.chunyue.springframeworkdi.services.LifeCycleDemoBean) bean).beforeInit();
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof com.chunyue.springframeworkdi.services.LifeCycleDemoBean){
            ((com.chunyue.springframeworkdi.services.LifeCycleDemoBean) bean).afterInit();
        }

        return bean;
    }
}