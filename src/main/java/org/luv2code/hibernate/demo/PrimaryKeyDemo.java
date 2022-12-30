package org.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.luv2code.hibernate.Entity.Student;

public class PrimaryKeyDemo {
    public static void main( String[] args ){

        SessionFactory sFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sFactory.getCurrentSession();
        try{
            //use the session object to save java object
            Student student1 = new Student("santosh", "saripella", "svs0395@gmail.com");
            Student student2 = new Student("stu 2", "bhupathiraju", "br@gmail.com");
            Student student3 = new Student("stu 3", "saripella", "svs0395@gmail.com");
            session.beginTransaction();
            session.persist(student1);
            session.persist(student2);
            session.persist(student3);
            session.getTransaction().commit();
            System.out.println("done");
            student1.toString();
            student2.toString();
            student3.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
