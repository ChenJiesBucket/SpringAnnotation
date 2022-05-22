package com.atguigu.config;

import com.atguigu.Condition.LinuxCondition;
import com.atguigu.Condition.WindowsCondition;
import com.atguigu.bean.Cat;
import com.atguigu.bean.Color;
import com.atguigu.bean.Person;
import org.springframework.context.annotation.*;

//
@Configuration
public class MainConfig2 {
    /** exp5 Scope 默认单实例
     * singleton  单实例 ioc 启动的时候创建实例 类似从map中拿取
     * prototype  多实例
     * request 同一个request 一个实例
     * session  同一个session 一个实例
     */
    @Scope("singleton")
    @Lazy
    /**
     * exp6 懒加载 IOC创建的时候不加载 在使用的时候创建
    **/
    @Bean("person2")
    public Person person(){
        System.out.println("单实例Bean");
        return new Person("zhangsan",22);
    }

    @Scope("prototype")
    @Bean("person3")
    public Person person3(){
        System.out.println("多实例Bean");
        return new Person("zhangsan",22);
    }
    //exp7 按照条件进行初始化Bean 根据系统环境选择
    /**
     * @Conditional 既可以加在 方法上 也可以加在类上，当加在类上时表示只有return true 后才能加载该类
    **/
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person4(){
        return new Person("Bill",55);
    }

    //按照条件进行初始化Bean  vm 配置 -Dos.name=linux
    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person5(){
        return new Person("Linus",65);
    }

    //exp12
    @Bean("cat")
    public Cat cat(){
        return new Cat();
    }
}
