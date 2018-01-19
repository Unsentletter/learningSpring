package com.luv2code.springDemo;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getDailyFortune() {
        return "You will fail your driving test";
    }
}
