package com.hibernate.demo1;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {

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

            // Create a course
            Course tempCourse = new Course("Being a madDog");

            // Save the course
            System.out.println("\nSaving course");
            session.save(tempCourse);
            System.out.println("Saved Course: " + tempCourse);

            // Create students
            Student tempStudent1 = new Student("Dave", "Madman", "dave@email.com");
            Student tempStudent2 = new Student("Steve", "Sensibleman", "Steve@email.com");

            // Add students to course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            // Save students
            System.out.println("Saving students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Students saved: " + tempCourse.getStudents());

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
