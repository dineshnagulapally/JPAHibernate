package com.example.jpahibernate.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor

@Entity
public class PartTimeEmployee extends Employee {
    private BigDecimal hourRate;

    public PartTimeEmployee(String name,BigDecimal hourRate) {
        super(name);
        this.hourRate = hourRate;

    }
}
