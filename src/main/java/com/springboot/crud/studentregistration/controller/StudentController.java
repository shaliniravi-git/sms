package com.springboot.crud.studentregistration.controller;

import com.springboot.crud.studentregistration.entity.Student;
import com.springboot.crud.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/addstudent")
    public ResponseEntity<String> saveStudent(@Valid @RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student named "+ student.getFirstName() +" "+ student.getLastName()+ " is added successfully");
    }

    @GetMapping("/getallstudent")
    public List<Student> fetchDepartmentList()
    {
        return studentService.fetchStudentList();
    }

    @DeleteMapping("/deletestudentbyid")
    public String deleteStudentById(@RequestHeader int rollNo)
    {
        studentService.deleteStudentByRollNo(rollNo);
        return "Student with Roll Number " + rollNo + " is deleted successfully";
    }

    /*@DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable("id") int rollNo)
    {
        studentService.deleteStudentByRollNo(rollNo);
    }*/


}
