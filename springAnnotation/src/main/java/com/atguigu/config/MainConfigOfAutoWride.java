package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.atguigu.dao","com.atguigu.Controller","com.atguigu.bean"})
public class MainConfigOfAutoWride {

}
