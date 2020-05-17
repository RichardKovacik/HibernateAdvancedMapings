package org.example.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.*;

public class PriradenieKurzuStudentovi {
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
            long idC=4L;
            long idC2=5L;
            // start transaction
            session.beginTransaction();
            //get student from table
            Student student=session.get(Student.class,idS);//studen s id 1
            //ziskam si 2 existujuce kurzy z tabulky
            Course course=session.get(Course.class,idC);
            Course course2=session.get(Course.class,idC2);
            //priradim mu 2 uz existujuce kurzy v tabulke
            student.addCourse(course);
            student.addCourse(course2);
            //save student
            session.save(student);
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
