package com.atguigu.test;

import com.atguigu.bean.*;
import com.atguigu.config.*;
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


    @Test
    public void test(){
        //exp18 @Value注解
        //1、基本数值
        //2、可以写SPEL #{} 内部写计算公式
        //3 ${} 取出配置文件中的值
        //PropertiesSource 和 PropertiesSourceas 一个可以使用多个一个只能使用一次
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        String[] defNames =  applicationContext.getBeanDefinitionNames();
        for (String def:defNames){
            System.out.println(def);
        }
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.toString());
        applicationContext.close();
    }

    @Test
    public void test01(){
        //exp19 @Autowird注解
        //@Autowird  BookDao bookDao1
        // 如果有多个 相同的BookDao 先根据类型找 再根据属性名(bookDao1)作为id 进行查找
        //也可以使用@Qualifier（"bookDao1"） 来指定id
        //@Autowirde(required=false) 非必填 防止启动报错 spring专用
        //也可以在Bean上（BookDao） 使用@primary 指定首选项 同时Qualifier不能用
        //PropertiesSource 和 PropertiesSourceas 一个可以使用多个一个只能使用一次
        //exp21 @Resource(name="bookDao1") 不支持@primary Require=false java规范
        //@Inject 没有require=false 的功能 java规范
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutoWride.class);
        String[] defNames =  applicationContext.getBeanDefinitionNames();
        for (String def:defNames){
            System.out.println(def);
        }


        Boss boss = (Boss) applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = (Car) applicationContext.getBean(Car.class);
        System.out.println(car);


        applicationContext.close();
    }
}
