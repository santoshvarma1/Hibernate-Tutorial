package org.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.luv2code.hibernate.Entity.Student;



public class StudentDemo {
    public static void main( String[] args ){

        SessionFactory sFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sFactory.getCurrentSession();
        try{
            //use the session object to save java object
            Student student = new Student("santosh", "saripella", "svs0395@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("done");
            student.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
