package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.Adress;
import tables.Instructor;

/**
 * Hello world!
 *
 */
public class SaveObject extends Data {
    public static void main( String[] args ) {
        //creating SessionFactory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Adress.class)
                .buildSessionFactory();
        //create session
        Session session=factory.getCurrentSession();
        //create object to acces data
        Data data=new Data();
        try {
            //create objects
            Instructor instructor=new Instructor(getRandomData(data.getNames()),getRandomData(data.getLastnames()));
            Adress adress=new Adress(getRandomData(data.getCountries()),getRandomData(data.getCities()));
            //associate the objects
            instructor.setAdressId(adress);
            // start transaction
            session.beginTransaction();
            //save object  @OneToOne(cascade = CascadeType.ALL) because of this save adress object too
            session.save(instructor);
            //commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
