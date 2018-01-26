package com.luv2code.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemo {
    public static void main(String[] args) {

        // Load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
        // Retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);


        System.out.println(theCoach.getDailyWorkout());
        context.close();
    }
}
