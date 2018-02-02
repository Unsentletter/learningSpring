package com.hibernate.demo1;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

           // Delete the student
//            System.out.println("deleting student" + myStudent);
//            session.delete((myStudent));

            // Delet student id = 2

            System.out.println("Deleting student id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done " + myStudent);

        }
        finally {
            factory.close();
        }

    }
}
