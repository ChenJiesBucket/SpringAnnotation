package com.atguigu;


import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.beancontext.BeanContext;

public class MainTest {
    public static void main(String[] args) {
        //exp1 注解使用@Configuration 替代xml文件代表配置来源，使用@Bean 代表<bean> 标签
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        Person p = (Person) applicationContext.getBean("person");
        System.out.println(p);*/
       // AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person per = annotationConfigApplicationContext.getBean(Person.class);
        String[] s = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for(String st : s){
            System.out.println(st);
        }
        System.out.println(per);
    }


}
