package com.example.jpahibernate.Repository;

import com.example.jpahibernate.Entity.Course;
import com.example.jpahibernate.Entity.Passport;
import com.example.jpahibernate.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;


    //findById public Student findById()
    public Student findById(Long id){
        return em.find(Student.class,id);
    }
    //insert

    //delete
    public void deleteById(Long id){
        Student student = findById(id);
        em.remove(student);
    }

    public Student insert(Student student){
        return em.merge(student);
    }

    public List<Student> getStudents(){
        List<Student> select_c_from_student_c = em.createQuery("SELECT c from Student c", Student.class).getResultList();
        return select_c_from_student_c;
    }

    public void saveWithPassport(){
        Passport passport = new Passport("D1234");
        em.persist(passport);
        Student student = new Student("Krishna");
        student.setPassport(passport);
         em.persist(student);
    }



    public void insertStudentCourse(){
        Student student = new Student("Jamuna");
        Course course = new Course("CD");
        em.persist(student);
        em.persist(course);
        student.setCourses(Arrays.asList(course));
        course.setStudents(Arrays.asList(student));
        em.persist(student);
    }
}
