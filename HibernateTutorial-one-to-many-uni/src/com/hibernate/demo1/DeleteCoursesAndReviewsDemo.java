package com.hibernate.demo1;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesAndReviewsDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // Start a transaction
            session.beginTransaction();

            // Get the course
            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            // Print the course
            System.out.println("Course: " + tempCourse);

            // Print the course reviews
            System.out.println("Course reviews: " + tempCourse.getReviews());

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
