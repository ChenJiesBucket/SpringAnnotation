package com.atguigu.Condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        String name = conditionContext.getEnvironment().getProperty("os.name");
        System.out.println(name);
        if(name.contains("linux")){
            return true;
        }else{
            return false;
        }
    }
}