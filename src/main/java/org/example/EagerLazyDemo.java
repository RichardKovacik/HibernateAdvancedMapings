package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.Adress;
import tables.Course;
import tables.Instructor;

public class EagerLazyDemo {
    public static void main( String[] args ) {
        //creating SessionFactory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Adress.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        //create session
        Session session=factory.getCurrentSession();
        try {
            Long id =4L;
            // start transaction
            session.beginTransaction();
            //get Instructor from db
            Instructor instructor=session.get(Instructor.class,id);
            System.out.println("Instruktor lastname: "+instructor.getLastname());
            //display instructor cources
            System.out.println("Instructor courses: "+instructor.getCourses());
            //commit transaction
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
            session.close();
        }
    }
}
