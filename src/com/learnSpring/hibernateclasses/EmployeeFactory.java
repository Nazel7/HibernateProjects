package com.learnSpring.hibernateclasses;

import com.learnSpring.objectsclass.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeFactory {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg1.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        try(sessionFactory){
//            Employee employee= new Employee("Gafar", "Olanipekun", "K-Devs System");
//            Employee employee= new Employee("Hikmah", "Nafihu", "Hik_Learner");
//            Employee employee= new Employee("Mujib", "Olanrewaju", "I-Tech");
//            Begin session...
            Session session= sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            int employeeID= 2;
//            Employee employee= session.get(Employee.class, employeeID);
//            System.out.println("Employee retrieved:\n"+ employee.getFirstName() + " "+
//                    employee.getLastName()+"\n"+ employee.getCompany());
//            System.out.println("trasaction connected...");
//            session.save(employee);
//            System.out.println("Employee saved");
//            session.getTransaction().commit();
            session= sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("DELETE from Employee s where s.id= 3").executeUpdate();
//         List<Employee> employees= session.createQuery("from Employee s where s.company= 'K-Devs System'")
//                 .getResultList();
//         readData(employees);
           session.getTransaction().commit();
            System.out.println("transaction completed...");
        }

    }
    public static void readData(List<Employee> employees){
        for(Employee s: employees){
            System.out.println(s.getFirstName()+ " " + s.getLastName());
        }
    }
}
