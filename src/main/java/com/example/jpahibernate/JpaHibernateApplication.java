package com.example.jpahibernate;

import com.example.jpahibernate.Entity.*;
import com.example.jpahibernate.Exception.UserNotFound;
import com.example.jpahibernate.Repository.CourseRepository;
import com.example.jpahibernate.Repository.EmployeeRepository;
import com.example.jpahibernate.Repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository cr;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    EmployeeRepository er;
    public static void main(String[] args) {

        SpringApplication.run(JpaHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        logger.info("{}",cr.findById(1l));
//        //cr.deleteById(1l);
//        logger.info("deleted ");
//        logger.info("{}",cr.insert(new Course("Machine Learning")));
//        logger.info("{}",cr.insert(new Course("Machine Learning1")));
//        //cr.WithEntityManager();
//         studentRepository.saveWithPassport();

            //cr.addReview();
//
//        er.insert(new PartTimeEmployee("Jill",new BigDecimal(50)));
//        er.insert(new fullTimeEmployee("Jack",new BigDecimal(10000)));
//
//        logger.info("{}",er.getAll());
        Student sid = studentRepository.findById(10000l);
        if(sid == null) throw new UserNotFound("user not found");



    }
}
