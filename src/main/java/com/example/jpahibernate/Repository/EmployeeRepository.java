package com.example.jpahibernate.Repository;

import com.example.jpahibernate.Entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public void insert(Employee employee){
        em.persist(employee);
    }

    public List<Employee> getAll(){
        return em.createQuery("select e from Employee e",Employee.class).getResultList();
    }
}
