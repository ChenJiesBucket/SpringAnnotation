package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;
//exp23 使用aware获取底层方法 后置处理器机制
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    public void setBeanName(String name) {
        System.out.println("当前bean名称："+name);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);

    }
//用来解析字符串
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        System.out.println(stringValueResolver.resolveStringValue("你好,${os.name}"));
    }
}
