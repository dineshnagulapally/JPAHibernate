package com.example.jpahibernate.Repository;

import com.example.jpahibernate.Entity.Course;
import com.example.jpahibernate.JpaHibernateApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    void findById() {
        Course course = courseRepository.findById(1l);
        assertEquals("BigData", course.getName());
    }

    @Test
    @DirtiesContext
    void deleteById() {
        courseRepository.deleteById(1l);
        //how do we check unit test for delete.
        //we can fetch the record and check it with NULL
        Course course = courseRepository.findById(1l);
        assertNull(course);
    }

    @Test
    @DirtiesContext
    void insert() {
        Course course = courseRepository.insert(new Course("AI"));

        assertEquals("AI",course.getName());
    }

    @Test
    @DirtiesContext
    void update() {
        Course course = courseRepository.findById(2l);
        course.setName("MachineLearning");
        Course course1 = courseRepository.insert(course);

        assertEquals("MachineLearning",course1.getName());
    }


//    @Test
//    @DirtiesContext
//    void WithManager() {
//        courseRepository.WithEntityManager();
//    }
    @Test
    @DirtiesContext
    void getCourse(){
        courseRepository.getCourses();
    }

    @Test

    @Transactional
    public void getReview(){
        Course course = courseRepository.findById(1l);
        logger.info("{}" , course.getReviews());

    }
}