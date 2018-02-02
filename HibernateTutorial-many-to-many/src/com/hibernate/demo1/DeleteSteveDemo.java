package com.hibernate.demo1;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteSteveDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // Start a transaction
            session.beginTransaction();

            // Get Dave from database
            int id = 6;
            Student tempStudent = session.get(Student.class, id);
            System.out.println("\nLoaded student: " + tempStudent);
            System.out.println("Daves courses " + tempStudent.getCourses());

            System.out.println("\nDeleteing student: " + tempStudent);

            session.delete(tempStudent);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {

            session.close();

            factory.close();
        }

    }
}
