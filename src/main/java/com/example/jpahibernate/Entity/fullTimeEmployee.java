package com.example.jpahibernate.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class fullTimeEmployee extends Employee {
    private BigDecimal salary;

    public fullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary ;

    }
}
