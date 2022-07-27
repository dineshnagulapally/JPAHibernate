package com.example.jpahibernate.Entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
    public Student(String name) {
        this.name = name;
    }
}
