package com.luv2code.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">>Inside default constructor");
    }

    // Define init method
    @PostConstruct
    public void doStartupStuff() {
        System.out.println(">>TennisCoach: inside of STARTUP");
    }

    // Define destroy method
    @PreDestroy
    public void doCleanup() {
        System.out.println(">>Tennis coach: inside CLEANUP");
    }


//    @Autowired
//    public void anyOldMethodName(FortuneService theFortuneService) {
//        System.out.println(">>In the random named method");
//        this.fortuneService = theFortuneService;
//    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println(">>Inside setter");
//
//        this.fortuneService = fortuneService;
//    }

    //    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Hit balls";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
