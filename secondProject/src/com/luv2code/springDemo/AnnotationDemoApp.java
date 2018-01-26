package com.luv2code.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // Read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the bean from the spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach secondCoach = context.getBean("footyCoach", Coach.class);

        // Call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        // Call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(secondCoach.getDailyWorkout());
        System.out.println(secondCoach.getDailyFortune());

        // Close the context
        context.close();
    }
}
