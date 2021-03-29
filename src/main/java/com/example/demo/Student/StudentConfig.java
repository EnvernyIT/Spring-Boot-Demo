package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student miriam = new Student(
                    1L,
                    "Miriam",
                    "miriamjamal@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER,4)
            );
            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2003, Month.JANUARY,14)
            );

            studentRepository.saveAll(
                    List.of(miriam, alex)
            );
        };
    }
}
