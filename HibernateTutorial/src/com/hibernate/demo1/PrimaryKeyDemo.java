package com.hibernate.demo1;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            //--- Use the session object to save Java object ---//
            // Create three student object
            System.out.println("Creating three new student object...");
            Student tempStudent1 = new Student("Steve", "Sensibleman", "steve@sensibleman.com");
            Student tempStudent2 = new Student("Pete", "Thepainter", "pete@painting.com");
            Student tempStudent3 = new Student("Scuba", "Steve", "scuba@steve.com");

            // Start a transaction
            session.beginTransaction();

            // Save the student object
            System.out.println("Saving the student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}
