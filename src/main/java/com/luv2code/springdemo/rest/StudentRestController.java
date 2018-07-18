package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springdemo.entity.Student;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //    @PostConstruct
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }

    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

//        check the studentId againts the list size

        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        } else {
            return theStudents.get(studentId);
        }
    }

//    Add an exception hander using @ExceptionHandler


}









