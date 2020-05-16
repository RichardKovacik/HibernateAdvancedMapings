package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.Adress;
import tables.Course;
import tables.Instructor;

import java.util.List;

public class OneToManyC extends Data {
    public static void main(String[] args) {
        //creating SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Adress.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            Long id = 4L;
            //create Data object to acces data from Data.class
            Data data = new Data();
            // start transaction
            session.beginTransaction();
            //get Instructor from db
            Instructor instructor = session.get(Instructor.class, id);
            //creating course to save it to db
            Course course = new Course(getRandomData(data.getCources()));
            instructor.add(course);
            //save course
            session.save(course);
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




