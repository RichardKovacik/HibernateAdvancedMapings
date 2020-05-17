package org.example.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.*;

public class GetData {
    public static void main(String[] args) {
        //creating SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Adress.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            long idS=1L;
            // start transaction
            session.beginTransaction();
            //get student from table
            Student student=session.get(Student.class,idS);//studen s id 1
            System.out.println("Student "+student.getLastname()+" absolvoval kurzy: "+student.getCourses());
            //commit transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }
}
