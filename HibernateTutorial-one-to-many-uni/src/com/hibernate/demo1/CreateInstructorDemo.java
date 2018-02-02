package com.hibernate.demo1;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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

            // Create the objects
//            Instructor tempInstructor = new Instructor("Chad", "Sexington", "chad@email.com");
//
//            InstructorDetail tempInstructorDetail = new InstructorDetail("http://somewebsite.com/youtube", "Drinking");

            Instructor tempInstructor = new Instructor("dave", "madman", "dave@email.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("http://anotherwebsite.com/youtube", "Extreme sports");

            // Associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // Start a transaction
            session.beginTransaction();

            // Save the Instructor
            // NOTE: this will also save the InstructorDetails object because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            factory.close();
        }

    }
}
