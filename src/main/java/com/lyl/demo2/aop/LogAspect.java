package com.lyl.demo2.aop;

import com.lyl.demo2.annotation.MyLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *@ClassName:LogAspect
 *@Description:TODO
 *@date: 2019-08-13 19:26
 **/

//将普通pojo实例化注册到spring容器中
@Component
//切面注解
@Aspect
public class LogAspect {

    /**
     * 将使用了@MyLog的注解的方法当作切点方法
     */
    @Pointcut("@annotation(com.lyl.demo2.annotation.MyLog)")
    private void cut() { }

    /**
     * 为切点方法定制一个环绕通知增强
     * @param joinPoint
     */
    @Around("cut()")
    public void advice(ProceedingJoinPoint joinPoint){
        System.out.println("环绕通知之开始");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕通知之结束");
    }

    /**
     * 对切点方法的前置增强
     * @param joinPoint  连接点
     */
    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("开始记录下操作日志@Before 方法执行前"+joinPoint.toString());
    }

    /**
     * 对切点方法的后置增强
     * @param joinPoint  连接点
     */
    @After("cut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("已经记录下操作日志@After 方法执行后"+joinPoint.toString());
    }

}
