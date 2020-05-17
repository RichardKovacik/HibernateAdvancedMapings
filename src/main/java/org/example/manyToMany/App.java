package org.example.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.*;

public class App {
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
            // start transaction
            session.beginTransaction();
            //create a course
            Course course=new Course("MySql");
            //save course
            session.save(course);
            System.out.println("saved courses...");
            //create Student
            Student student=new Student("Jacob","Hill","Hill00@gmail.com");
            Student student1=new Student("Dominik","Jagr","jagkr446@gmail.com");
            //tzmto dvom studentom som priradil kurz MySql
            course.addStudent(student);
            course.addStudent(student1);
            System.out.println("saved students");
            //save students
            session.save(student);
            session.save(student1);
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
