package com.example.jpahibernate.Repository;

import com.example.jpahibernate.Entity.Passport;
import com.example.jpahibernate.Entity.Student;
import com.example.jpahibernate.JpaHibernateApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
class StudentRepositoryTest {
    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StudentRepository studentRepository;

    @Test
    @Transactional
    void saveWithPassport() {
        Student student = studentRepository.findById(101l);
        logger.info("{}", student);
        logger.info("{}",student.getPassport());

    }

    @Test
    @Transactional
    void getStudentWithPassport() {
        Passport passport = em.find(Passport.class,3l);
        logger.info("{}", passport);
        logger.info("{}",passport.getStudent());

    }

    @Test
    @Transactional
    public void getCoursesWithStudent(){
        Student student = em.find(Student.class,1l);
        logger.info("{}",student.getCourses());
    }
}