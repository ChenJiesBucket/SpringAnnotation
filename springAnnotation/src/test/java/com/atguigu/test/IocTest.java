package com.atguigu.test;

import com.atguigu.bean.Color;
import com.atguigu.bean.Person;
import com.atguigu.config.ImportConfig;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import com.atguigu.config.MainConfigOfFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class IocTest {
    @SuppressWarnings("resources")
    @Test
    //exp2     @ComponentScan包扫描 通过过滤器进行过滤扫描包
    public void ComponyScanTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionName = applicationContext.getBeanDefinitionNames();
        for(String name : definitionName){
            System.out.println(name);
        }

    }

    @Test
    public void ScopeSingleton(){
        System.out.println("IOC容器创建。。。。。");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        //添加Lazy后不进行初始化
       // Person person2 = (Person)applicationContext.getBean("person2");

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
    public void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] defineBeans = applicationContext.getBeanDefinitionNames();
        for(String s : defineBeans){
            System.out.println(s);
        }
    }
    @Test
    public void ImportTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
        printBeans(applicationContext);
    }

    @Test
    //exp11
    public void FactoryBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionName = applicationContext.getBeanDefinitionNames();
        for(String name : definitionName){
            System.out.println(name);
        }
        Color c1 = applicationContext.getBean(Color.class);
        Color c2 = applicationContext.getBean(Color.class);
        System.out.println(c1==c2);
    }

    @Test
    public void testLifeOfBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfFactory.class);
        applicationContext.close();
    }

}