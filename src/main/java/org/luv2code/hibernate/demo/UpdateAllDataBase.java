package org.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.luv2code.hibernate.Entity.Student;

import java.util.List;

public class UpdateAllDataBase {
    public static void main( String[] args ){

        SessionFactory sFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sFactory.getCurrentSession();
        try{
            //use the session object to retrieve objects from database
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student", Student.class).getResultList();
            for (Student student: studentList) {
                System.out.println(student.toString());
                student.setEmail("sex@gmail.com");
            }
            session.getTransaction().commit();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
