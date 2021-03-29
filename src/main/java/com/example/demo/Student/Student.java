package com.example.demo.Student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String firstName;
    private String eMail;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id, String firstName, String eMail, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.eMail = eMail;
        this.dob = dob;
    }

    public Student(String firstName, String eMail, LocalDate dob) {
        this.firstName = firstName;
        this.eMail = eMail;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String firstName) {
        this.firstName = firstName;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
