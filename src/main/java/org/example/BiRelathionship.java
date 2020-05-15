package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.Adress;
import tables.Instructor;

public class BiRelathionship {
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
                Long id =5L;
                // start transaction
                session.beginTransaction();
                //object of Adress class
                Adress adress=session.get(Adress.class,id);
                //the associated Instructor
                System.out.println("teraz ziskam pristup cez adresu k instruktorovi "+adress.getInstructor());

                //commit transaction
                session.getTransaction().commit();
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                session.close();
                factory.close();
            }
        }
}
