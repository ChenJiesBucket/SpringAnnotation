package com.atguigu.test;

import com.atguigu.bean.Cat;
import com.atguigu.bean.Color;
import com.atguigu.bean.Person;
import com.atguigu.config.ImportConfig;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import com.atguigu.config.MainConfigOfFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class IocTest2 {
    //exp11
    /**
     *制定初始化和销毁方法
     * 1 通过@Bean注解的init-method destory-method
     * 2 通过让Bean实现 InitializingBean DisposableBean 内部方法
     * 3 使用jsr250  类方法内部使用注解方法定义初始 销毁方法 @PostConstruct 在bean创建完成执行  @PreDestory销毁之前执行
     * 4 benPostProcessor【interface】 bean后置处理器
     * 在Bean初始化前后进行一些操作()
     * postProcessBeforeInitialization 在初始化之前工作 早于 前1 2 3 方法执行
     * postProcessBeforeInitialization 在初始化之后工作
    **/
    @Test
    public void testInitDestory(){
        System.out.println("IOC容器创建。。。。。");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

       Cat cat = (Cat)applicationContext.getBean("cat");

    }

    @Test
    public void ConditionalLoadBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        //exp7 通过类型获取Bean
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String s : beanNamesForType){
            System.out.println(s);
        }
        Map<String,Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

}
