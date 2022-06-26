package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//声明是一个切面
@Aspect
public class LogAspects {
    //抽取公共的切入点表达式  这个类就叫切面类
    //1  本类引用（不写参数时候默认本类）
    //2  其他的切面引用
    //@Pointcut("execution(public int com.atguigu.aop.MathCalculator.div(int,int))")
    // 匹配某个类所有方法
     @Pointcut("execution(public int com.atguigu.aop.MathCalculator.*(..))")
    public void pointCut(){

    }
    // 内部方法可以用@PointCut 配置
    @Before("execution(public int com.atguigu.aop.MathCalculator.div(int,int))")
    public void logStart(JoinPoint joinPoint){
         //joinPoint 用于获取运行函数方法以及参数等信息
        Object[] args = joinPoint.getArgs();
        System.out.println("除法运行开始@Before方法："+joinPoint.getSignature().getName()+"输入参数"+ Arrays.asList(args));
    }
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println("除法@After运行结束"+joinPoint.getKind());
    }
    // * joinPoint必须要在参数的首位否则spring是无法识别的
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
         //returning 指定谁来接受返回值result
         System.out.println("除法运行@AfterReturnin返回结果:"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
         //throwing告诉spring exception是用来接收异常的
        System.out.println("除法运行 @AfterThrowing异常后运行的函数,异常信息为"+exception.toString());
    }

}
