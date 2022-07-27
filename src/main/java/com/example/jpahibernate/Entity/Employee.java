package com.example.jpahibernate.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    public Employee(String name) {
        this.name = name;
    }
}
