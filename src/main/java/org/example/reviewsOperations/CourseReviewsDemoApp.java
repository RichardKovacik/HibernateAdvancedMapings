package org.example.reviewsOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.Adress;
import tables.Course;
import tables.Instructor;
import tables.Review;

public class CourseReviewsDemoApp {
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
            Long id = 4L;
            // start transaction
            session.beginTransaction();
            //get Course from db
            Course course=session.get(Course.class,id);
            System.out.println("Course: " + course.getTitle());
            //set review
            course.add(new Review("This was really good"));
            course.add(new Review("Bad explanation of instructor"));
            //display reviews of cources
            System.out.println("Couses reviews: " + course.getReviews());
            //save it to db
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