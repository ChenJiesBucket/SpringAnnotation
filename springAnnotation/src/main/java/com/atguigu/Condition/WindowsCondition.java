package com.atguigu.Condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.Annotation;

public class WindowsCondition  implements Condition {
    //ConditionContext 当前上下文
    //AnnotatedTypeMetadata 当前注释信息
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取当前IOC类加载器
        conditionContext.getClassLoader();
        //获取BeanFactory
        conditionContext.getBeanFactory();
        //既可以注册一个Bean的定义 也可以移除一个Bean的定义
        conditionContext.getRegistry();
        //获得当前运行环境
        Environment e = conditionContext.getEnvironment();
        if(e.getProperty("os.name").contains("Window")){
            return true;
        }else{
            return false;
        }

    }
}