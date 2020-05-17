package org.example.reviewsOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.Adress;
import tables.Course;
import tables.Instructor;
import tables.Review;

public class DeleteReviews {
    public static void main(String[] args) {
        //creating SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Adress.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            Long id = 1L;
            // start transaction
            session.beginTransaction();
            //get Course from db
            Review review=session.get(Review.class,id);

            System.out.println("Deleting review: " + review.getComent());
            session.delete(review);
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
