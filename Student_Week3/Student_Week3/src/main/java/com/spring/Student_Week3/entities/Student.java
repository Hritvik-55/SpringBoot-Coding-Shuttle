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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    private String name;
    @OneToOne(mappedBy = "student")
    private AdmissionRecord admissionRecord;
    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Set<Professor> professors;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Students_Subjects",joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "id"))
    @JsonIgnore
    private List<Subject> subjects;

}
