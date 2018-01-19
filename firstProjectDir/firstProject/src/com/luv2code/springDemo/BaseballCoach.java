package com.luv2code.springDemo;

public class BaseballCoach implements Coach {

    // Define a private field for the dependency
    private FortuneService fortuneService;

    // Define a constructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend time doing cool shit";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
