package com.example.jpahibernate.Repository;

import com.example.jpahibernate.Entity.Course;
import com.example.jpahibernate.Entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;


    //findById public Course findById()
    public Course findById(Long id){
        return em.find(Course.class,id);
    }
    //insert

    //delete
    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public Course insert(Course course){
        return em.merge(course);
    }

//    public void WithEntityManager(){
//        Course course = new Course(4,"AEC");
//        em.persist(course);
//        em.detach(course);
//        course.setName("DEC");
//    }

    public List<Course> getCourses(){
        List<Course> select_c_from_course_c = em.createQuery("SELECT c from Course c", Course.class).getResultList();
        return select_c_from_course_c;
    }

    public void addReview(){
        Course course = em.find(Course.class,1l);
        Review review1 = new Review("5", "gooood");
        Review review2 = new Review("4", "ok");
        List<Review> reviews = Arrays.asList(review1,review2);
        course.setReviews(reviews);

        review1.setCourse(course);
        review2.setCourse(course);
        em.persist(review1);
        em.persist(review2);

    }
}
