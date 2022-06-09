package com.atguigu.bean;

import org.springframework.stereotype.Component;

/*exp12*/
@Component
public class Car {
    public Car(){
        System.out.println("Car Constroster");
    }
    public void init(){
        System.out.println("Car init");
    }
    public void destory(){
        System.out.println("Car destory");
    }
}
