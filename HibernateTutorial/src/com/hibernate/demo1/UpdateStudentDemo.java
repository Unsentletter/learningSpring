package com.hibernate.demo1;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            // Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student");
            myStudent.setFirstName("Scooby");

            // Update email for all students
            System.out.println("Updating email for all students to mail@mail.com");

            session.createQuery("Update Student set email='mail@mail.com'").executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done " + myStudent);

        }
        finally {
            factory.close();
        }

    }
}
