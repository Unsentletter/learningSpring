package com.luv2code.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // Read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // Get the bean from the spring container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        // Call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        // Call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        //Call getters
        System.out.println("email: " + theCoach.getEmail());

        System.out.println("team: " + theCoach.getTeam());

        // Close the context
        context.close();
    }
}
