package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSillyMember() {
        System.out.println(getClass() + ": Doign stuff in memberhsipdao");

        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": Im going to sleep now.");
    }
}
