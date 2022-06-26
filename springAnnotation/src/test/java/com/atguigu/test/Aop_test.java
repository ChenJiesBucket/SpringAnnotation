package com.atguigu.test;

import com.atguigu.aop.MathCalculator;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aop_test {
    @Test
    public void AopTestAspect(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(5,0);

    }
}
