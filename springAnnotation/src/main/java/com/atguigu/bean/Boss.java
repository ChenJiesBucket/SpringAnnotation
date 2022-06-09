package com.atguigu.bean;

//exp22 @AutoWride  @Resource @Inject

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
//@Autowride
//1 标注在方法位置
//2 有参构造器 如果组件只有有参位置 这个@Autowride可以省略
//3 放在参数位置
@Component
public class Boss implements ApplicationContextAware {

    private Car car;

   // @Autowired
    public Boss(Car car) {
        this.car = car;
        //参数地址相同
        System.out.println("有参构造器。。。"+car);
    }

    @Autowired
    //标注在方法：spring容器创建当前对象，就会调用方法 完成赋值
    //方法使用的参数 自定义类型的值从IOC中获取
    public void setCar(Car car) {
        this.car = car;
        //参数地址相同
        System.out.println("setCar...."+car);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //类似回调方法 可以获得application
    }
}
