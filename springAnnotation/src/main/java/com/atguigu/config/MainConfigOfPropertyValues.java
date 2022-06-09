package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//使用@PropertySource 读取外部配置文件中的k/v 保存到运行环境中；加载完配置后配合${}使用
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean("person")
    public Person getPerson(){
        return  new Person();
    }
}
