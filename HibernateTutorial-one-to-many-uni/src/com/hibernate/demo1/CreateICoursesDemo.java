package com.hibernate.demo1;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateICoursesDemo {

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

            // Get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            // Create some courses
            Course tempCourse1 = new Course("Air Guitar");
            Course tempCourse2 = new Course("Being a mad dog");

            // Add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            // Save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            factory.close();
        }

    }
}
