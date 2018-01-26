package com.luv2code.springDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class FootyCoach implements Coach {

    @Value("${foo.fortune1}")
    private String fortune1;

    @Value("${foo.fortune2}")
    private String fortune2;

    @Value("${foo.fortune3}")
    private String fortune3;

    @Value("${foo.fortune4}")
    private String fortune4;

    private String[] fortunes;

    @PostConstruct
    public void setUpRandomFortunes() {
        fortunes = new String[4];

        fortunes[0] = fortune1;
        fortunes[1] = fortune2;
        fortunes[2] = fortune3;
        fortunes[3] = fortune4;
    }

    private Random myRandom = new Random();

    @Override
    public String getDailyWorkout() {
        return "Run circles around the shit guy";
    }

    @Override
    public String getDailyFortune() {
        int index = myRandom.nextInt(fortunes.length);

        String theFortune = fortunes[index];

        return theFortune;
    }
}
