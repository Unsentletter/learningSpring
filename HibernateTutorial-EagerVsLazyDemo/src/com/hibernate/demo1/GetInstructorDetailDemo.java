package com.hibernate.demo1;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                   .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // Start a transaction
            session.beginTransaction();

            // Get instructor details object
            int theId = 2;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            // Print the instructor
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            // Print the associated instructor
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        catch(Exception exc) {
            exc.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}