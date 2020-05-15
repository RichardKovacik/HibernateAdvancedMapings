package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.Adress;
import tables.Instructor;

public class DeleteObject {
    public static void main( String[] args ) {
        //creating SessionFactory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Adress.class)
                .buildSessionFactory();
        //create session
        Session session=factory.getCurrentSession();
        try {
            Long id =1L;
            // start transaction
            session.beginTransaction();
            Instructor instructor=session.get(Instructor.class,id);
            if (instructor!=null) {
                //delete also adress object because of relationship between two tables
                session.delete(instructor);
            }
            //commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
