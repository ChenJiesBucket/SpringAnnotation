package com.atguigu.aop;

/** AOP
 * @Author dcj
 * @Description
 *
 *
 * @Date 2022/6/26 13:58
 * @Param
 * @return
**/
public class MathCalculator {

    public int div(int i,int j){
        System.out.println("MathCalculator...div..");
        return i/j;
    }
}
