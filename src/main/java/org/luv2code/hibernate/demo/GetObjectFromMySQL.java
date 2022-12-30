package org.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.luv2code.hibernate.Entity.Student;

public class GetObjectFromMySQL {
    public static void main( String[] args ){

        SessionFactory sFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sFactory.getCurrentSession();
        try{
            //use the session object to retrieve objects from database
            session.beginTransaction();
            Student student = session.get(Student.class, 4);
            System.out.println(student.toString());
            session.getTransaction().commit();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
