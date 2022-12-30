package org.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.luv2code.hibernate.Entity.Student;

import java.util.List;

public class QueryStudentDemo {
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
            }

            studentList = session.createQuery("from Student s where s.email=\"svs0395@gmail.com\"", Student.class).getResultList();

            System.out.println("================================");
            System.out.println("last name of bhupathiarju");
            for (Student student: studentList) {
                System.out.println(student.toString());
            }
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
