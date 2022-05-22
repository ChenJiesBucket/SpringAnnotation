package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//注册到容器
@Component
public class Cat  implements InitializingBean, DisposableBean,
        BeanPostProcessor {
    //InitializingBean 实现方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat..initMethod by InitializingBean");
    }
    //DisposableBean 实现方法
    public void destroy() throws Exception {
        System.out.println("cat..destroyMethod by DisposableBean");
    }

    @PostConstruct
    public void initMethod(){
        System.out.println("PostConstruct initMethod....");
    }

    @PreDestroy
    public void destotMethod(){
        System.out.println("PostConstruct initMethod....");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("exec postProcessBeforeInitialization");
        //返回值为封装处理好的Bean
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("exec postProcessAfterInitialization");
        //返回值为封装处理好的Bean
        return bean;
    }
}
