package com.atguigu.config;

import com.atguigu.bean.Car;
import org.springframework.context.annotation.Bean;

/**
 * exp12   Bean的生命周期 ：
 * bean创建 --> 初始化 --> 销毁
 * 操作方法
 * 容器管理bean 的生命周期：
 * 我们可以自定义 初始化和销毁方法
 *  在bean进行到当前生命周期的时候调用对应自定义方法
 *
 *  1) 指定初始化和销毁方法：
 *  指定init-method 和destroy-method
 *  单实例: 在容器起订的时候创建对象
 *  多实例： 在每次获取的时候创建对象
 *
 *  初始化：
 *         创建对象完成，并赋值好，调用初始化方法。。。
 *  销毁：
 *        单实例;容器关闭的时候
 *        多实例 容器不会管理这个Bean  容器不会调用销毁方法
 *
 * exp13 通过InitialzingBean
 *
**/
public class MainConfigOfFactory {
    @Bean(initMethod = "init" ,destroyMethod ="destory")
    public Car Car(){
        return new Car();
    }
}
