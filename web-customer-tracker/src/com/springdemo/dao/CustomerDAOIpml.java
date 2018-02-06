package com.springdemo.dao;

import com.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOIpml implements CustomerDAO {

    // Inject hibernate session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // Get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Create a query and sort by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName" , Customer.class);

        // Excecute the query and get result list
        List<Customer> customers = theQuery.getResultList();

        // Return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        // Get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //Save the customer to the db
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {

        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Retrieve object from db using the primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Delete the object from the db using the primary key
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();

    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {

        // Get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        // Only search by name if theSearchName is empty
        if(theSearchName != null && theSearchName.trim().length() > 0) {
            // Search for firstName or lastName
            theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);

            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            // theSearchName is empty so get all customers
            theQuery = currentSession.createQuery("from Customer", Customer.class);
        }

        // Execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // Return results
        return customers;
    }
}
