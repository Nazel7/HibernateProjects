package com.learnSpring.hibernateclasses;

import com.learnSpring.objectsclass.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateStudentsFactory {
    public static void main(String[] args) throws ParseException {


        SessionFactory sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (sessionFactory) {
            DateUtilFormatter dateUtilFormatter= new DateUtilFormatter();
            String dateString= "12/06/1991";
            Date date= dateUtilFormatter.dateFormatter(dateString);
            Student student = new Student("Casey", "Olanipekun", date, "KezyKezy");

            Session session = sessionFactory.getCurrentSession();
            System.out.println("Creating SessionFactory....");

            System.out.println("Session Created");
            session.beginTransaction();
            System.out.println("Student object saving...");
            session.save(student);
            session.getTransaction().commit();

//            System.out.println("Session committed");
//            System.out.println(student.getId());
//            System.out.println("student primary key printed");
//            session= sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            System.out.println("getting student :"+ student.getId());
//            Student theStudent= session.get(Student.class, student.getId());
//            System.out.println("Student: "+ theStudent);
//            session.getTransaction().commit();
//           session.close();
        }

    }
}
