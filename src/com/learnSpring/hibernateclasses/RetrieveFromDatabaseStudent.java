package com.learnSpring.hibernateclasses;

import com.learnSpring.objectsclass.Student;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveFromDatabaseStudent {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        try(sessionFactory){
            Session session= sessionFactory.getCurrentSession();
            session.beginTransaction();
            int studentID= 2;
            Student student= session.get(Student.class, studentID);
            student.setFirstName("Bello");
            session.getTransaction().commit();
            System.out.println("FirstName changed for student with ID: " +studentID);

        }
    }

}
