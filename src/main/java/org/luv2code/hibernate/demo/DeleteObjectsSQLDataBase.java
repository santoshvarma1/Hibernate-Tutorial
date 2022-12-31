package org.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.luv2code.hibernate.Entity.Student;

import java.util.List;

public class DeleteObjectsSQLDataBase {
    public static void main( String[] args ){

        SessionFactory sFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sFactory.getCurrentSession();
        session.beginTransaction();
        try{
            List<Student> students = session.createQuery("From Student s Where s.id=10 OR s.id=11 OR s.id=12 OR s.id=13", Student.class).getResultList();
            Transaction t = session.getTransaction();
            for (Student student: students) {
                session.remove(student);
            }
            t.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
