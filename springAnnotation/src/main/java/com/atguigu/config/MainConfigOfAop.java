package com.atguigu.config;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author dcj
 * @Description
 * AOP动态代理
 * 指在程序运行期间动态的将某段代码切入到指定位置进行运行的编程方式
 * 1导入AOP模块 spring AOP spring aspects
 * 2 定义一个业务逻辑类(MathCalcuator 在业务逻辑运行的时候将日志进行打印 打印之前 方法运行)
 * 3 定义一个日志切面累 LogAspect 切面类里面的方法
 * 4 给切面类方法标注何时何地运行（通知注解）
 *通知方法 前置通知
 *value 值填充 "方法权限 包路径.方法名(参数，参数)"
 * 前置通知（@Before）：logStart 在目标方法div运行之前
 * 后置通知（@After）：logEnd 在目标方法div运行结束之后运行
 * 返回通知（@AfterReturning）: logReturn  在目标方法div运行 正常返回之后运行
 * 异常通知 logException :在目标方法运行抛出异常以后运行
 * 环绕通知 动态代理 手动推进目标方法运行 （joinPoint.procced()） (最底层通知)
 *
 * 5 将切面类和被切的业务逻辑类（目标方法所在类） 都加入到容器中
 * 6 告诉spring 那个是切面类在类上面加上 @Aspect
 * 7 开启基于注解的切面注解  @EnableAspectJAutoProxy
 * 测试时不要自己new 组件 使用dpring
 * joinPoint必须要在参数的首位否则spring是无法识别的
 *
 * 1 将业务逻辑和切面类都加到容器中 告诉spring 那个是切面类@Aspect
 * 2 在切面类每一个通知方法加上注解 告诉spring 何时何地运行 PoingCut
 * 3 开启 基于注解的Aop模式
 * * @Date 2022/6/9 22:50
 * @Param
 * @return
**/
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAop {
    //5 类注册到容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
