package com.hibernate.demo1;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // Start a transaction
            session.beginTransaction();

            // Query students
            List<Student> theStudents = session.createQuery("from Student").list();
            // List<Student> theStudents = session.createQuery("from Student").getResultList(); // For Hibernate 5.2 or higher

            // Display students
            displayStudents(theStudents);

            // Query students: lastname madman
            System.out.println("\nStudents last name Madman");
            theStudents = session.createQuery("from Student s where s.lastName='Madman'").list();
            displayStudents(theStudents);

            // Query students: lastName = 'Madman' OR firstName 'Steve'
            theStudents = session.createQuery("from Student s where" + " s.lastName='Madman' OR s.firstName='Steve'").list();
            System.out.println("\nStudents who have last name Madman, or firstName Steve");
            displayStudents(theStudents);

            // Query students where email LIKE '%madman'
            theStudents = session.createQuery("from Student s where" + " s.email LIKE '%madman.com'").list();
            System.out.println("\nQuery students with email ends with madman");
            displayStudents(theStudents);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
