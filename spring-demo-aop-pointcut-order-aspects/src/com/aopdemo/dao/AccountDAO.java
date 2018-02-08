package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my db work: Adding account");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": dowork");
        return false;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public void setName(String name) {
        System.out.println("SETNAME");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(serviceCode);
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("SETSERVICECODE");
        this.serviceCode = serviceCode;
    }
}
