package com.luv2code.springDemo;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "That makes me a saaad panda";
    }
}
