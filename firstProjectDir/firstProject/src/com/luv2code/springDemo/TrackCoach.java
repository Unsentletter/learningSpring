package com.luv2code.springDemo;

public class TrackCoach implements Coach{

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do dope shit";
    }

    @Override
    public String getDailyFortune() {
        return "adding strings together" + fortuneService.getDailyFortune();
    }

    public void doMyStartupStuff() {
        System.out.println("TrackCoach inside method doMyStartupStuff");
    }

    public void doMyCleanupStuff() {
        System.out.println("TrackCoach inside method doMyCleanupStuff");
    }
}
