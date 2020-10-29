package com.atguigu.ImportSelector;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class BeanDefineRegistrar  implements ImportBeanDefinitionRegistrar {
    /**
     * @Author dcj
     * @Description registerBeanDefinitions
     * @Date 2020/6/25 22:31
     * @Param [annotationMetadata 当前类的注册信息,
     * beanDefinitionRegistry ： BeanDefinition 注册类  Bean定义注册类  ]
     * @return void
    **/
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Boolean beanDefinition = beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Red");
        Boolean beanDefinition1 = beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Blue");
        if(beanDefinition&&beanDefinition1){
            RootBeanDefinition beanDef = new RootBeanDefinition(RainBow.class);
            beanDefinitionRegistry.registerBeanDefinition("RainBow",beanDef);
        }
    }
}