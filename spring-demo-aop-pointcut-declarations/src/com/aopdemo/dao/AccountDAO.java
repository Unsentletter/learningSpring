package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my db work: Adding account");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": dowork");
        return false;
    }
}
