package com.hibernate.demo1;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {


            // Start a transaction
            session.beginTransaction();

            // Get a course
            int id = 10;
            Course tempCourse = session.get(Course.class, id);

            // Delete course
            System.out.println("Deleting Course: " + tempCourse);

            session.delete(tempCourse);

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
