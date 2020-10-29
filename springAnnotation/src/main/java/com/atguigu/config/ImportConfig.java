package com.atguigu.config;

import com.atguigu.Condition.LinuxCondition;
import com.atguigu.Condition.WindowsCondition;
import com.atguigu.ImportSelector.BeanDefineRegistrar;
import com.atguigu.ImportSelector.MyImportSelector;
import com.atguigu.bean.Color;
import com.atguigu.bean.Person;
import org.springframework.context.annotation.*;

//
@Configuration
/*com.atguigu.bean.Color*/

@Import({Color.class, MyImportSelector.class, BeanDefineRegistrar.class})
public class ImportConfig {

    /** exp 8-11  @Import
     * 给容器注册组件
     * 1 包扫描+组件标注注解 ru @Controller @Service @Repository  @Component
     * 2 @Bean[导入的第三方包里面的组件】
     * 3 @Import 快速给容器中导入组件
     * 使用位置在@Configuration
     *  传入的参数类型有
     *    1） @Import(要导入到容器中的组件) ：容器中就会自动注册这个组件 id 默认是全类名
     *    2） 实现类.class   实现ImportSelector类方法  返回值 需要导入的组件的全类名数组（com.atguigu.bean.Person 数组）
     *    3）实现类.class 实现 ImportBeanDefinitionRegistrar 类方法   实现手动注册bean 到容器中
     * 4  FactoryBean  使用Spring提供的FactoryBean （工厂Bean） 一般多见于第三方调用
     */
    /*exp9 @Import  */

}