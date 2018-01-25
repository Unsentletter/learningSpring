package com.luv2code.springDemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
    @Override
    public String getDailyFortune() {
        String[] fortunes = new String[] {"Fortune1", "Fortune2", "Fortune3"};

        Random generator = new Random();
        int randomIndex = generator.nextInt(fortunes.length);
        return fortunes[randomIndex];
    }
}
