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
@Entity
@NamedQuery(name="all_courses",query = "Select c from Course c")
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "Course_Student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;
    public Course(String name) {
        this.name = name;
    }
}
