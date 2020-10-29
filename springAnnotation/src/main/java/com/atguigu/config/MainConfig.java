package com.atguigu.config;

import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

//exp1
@Configuration
//exp2  excludeFilters 排除包  type 根据哪种类型排除（默认注解）  提示 ： 使用Ctrl+P 可以查看参数表
//@ComponentScan(value = "com.atguigu",  = {@Filter(type = FilterType.ANNOTATION,classes = {Controller.class})})
// ;使用 includeFilters 时要将useDefaultFilters 关闭 默认为true
//@ComponentScan(value = "com.atguigu",includeFilters = {@Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},useDefaultFilters = false)
//使用多个过滤规则时java8 支持多个@ComponentScan  较低版本要用 @ComponentScans
//FilterType :  ANNOTATION (根据注解 )  ASSIGNABLE_TYPE（一个类 BookServer。class）, ASPECTJ（表达式一般不用）,REGEX（正则表达式可以）, CUSTOM 自定义方法;
/*@ComponentScans(value = {@ComponentScan(value = "com.atguigu",excludeFilters = {@Filter(type = FilterType.ANNOTATION,classes = {Configuration.class})}),
        @ComponentScan(value = "com.atguigu",includeFilters = {@Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},useDefaultFilters = false)})*/

//exp4 自定义过滤
@ComponentScan(value = "com.atguigu",includeFilters = {@Filter(type = FilterType.CUSTOM,classes = {CustomTypeFilter.class})},useDefaultFilters = false)

public class MainConfig {

    //注册一个bean id默认为方法名
    @Bean("person1")
    public Person person(){
        return new Person("lisi",89);
    }

    /*exp11  注册FactoryBean*/
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}