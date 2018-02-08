package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // Read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // Get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // Call the business method
        Account myAccount = new Account();
        myAccount.setLevel("Five");
        myAccount.setName("Tritan");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        // Call getters and setters
        theAccountDAO.setName("Trit");
        theAccountDAO.setServiceCode("Silver");

        theAccountDAO.getName();
        theAccountDAO.getServiceCode();

        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();

        // Close the context
        context.close();
    }
}
