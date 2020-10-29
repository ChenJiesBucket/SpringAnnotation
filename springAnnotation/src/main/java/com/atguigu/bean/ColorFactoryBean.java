package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

/*exp 11 FactoryBean 里面填Bean的泛型*/
public class ColorFactoryBean implements FactoryBean<Color> {
    //返回Bean对象 对象会添加到容器中
    public Color getObject() throws Exception {
        System.out.println("FactoryBean多例模式获得Bean。。。");
        return new Color();
    }

    //返回的Bean类型
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否为单例 (否则为prototype 每次获取都会调用getObject 获取新的Bean 通过 == 即可得知)
    public boolean isSingleton() {
        return false;
    }
}