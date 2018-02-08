package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    // This is where we add all of our related advices for logging
    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=======> Executing @Before on method addAccount()");
    }

    @Before("forDAOPackage()")
    public void performApiAnalytics() {
        System.out.println("#######>> Performing API analytics");
    }
}
