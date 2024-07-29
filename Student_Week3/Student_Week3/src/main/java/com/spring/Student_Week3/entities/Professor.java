package com.spring.Student_Week3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Professor_Students",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;
    @OneToMany(mappedBy = "professor")
    @JsonIgnore
    private Set<Subject> subjects;

}
