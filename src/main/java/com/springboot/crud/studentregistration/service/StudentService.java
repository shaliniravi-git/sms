package com.springboot.crud.studentregistration.service;

import com.springboot.crud.studentregistration.entity.Student;

import java.util.List;

public interface StudentService {

    public void saveStudent(Student student);

    public List<Student> fetchStudentList();


    public void deleteStudentByRollNo(int rollNo);
}
