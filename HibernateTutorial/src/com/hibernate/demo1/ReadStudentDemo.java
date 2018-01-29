package com.hibernate.demo1;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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
            // Create a student object
            System.out.println("Creating a new student object...");
            Student tempStudent = new Student("Dave", "Madman", "dave@madman.com");

            // Start a transaction
            session.beginTransaction();

            // Save the student object
            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // Commit transaction
            session.getTransaction().commit();

            //--- CODE FOR RETREIVING DATA ---//
            // Find out the students id(primary key)
            System.out.println("Student id is: " + tempStudent.getId());

            // Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done " + myStudent);

        }
        finally {
            factory.close();
        }

    }
}
