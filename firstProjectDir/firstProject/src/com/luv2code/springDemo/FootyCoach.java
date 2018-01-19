package com.luv2code.springDemo;

public class FootyCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "footy is fun";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
