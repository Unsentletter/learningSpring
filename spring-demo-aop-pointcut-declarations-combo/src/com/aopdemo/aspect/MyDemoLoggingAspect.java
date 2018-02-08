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

    @Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
    private void getter() {};

    @Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
    private void setter() {};

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    // This is where we add all of our related advices for logging
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=======> Executing @Before on method addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("#######>> Performing API analytics");
    }
}
