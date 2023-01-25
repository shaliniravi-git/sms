package com.springboot.crud.studentregistration.service;

import com.springboot.crud.studentregistration.entity.Student;
import com.springboot.crud.studentregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student)
    {
        studentRepository.save(student);
        String rollNumber = student.getDepartment()+"-"+student.getId();
        student.setRollNo(rollNumber);
    }

    @Override
    public List<Student> fetchStudentList()
    {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void deleteStudentByRollNo(int rollNo)
    {
       Student student = studentRepository.findById(rollNo).get();
       student.setStatus("inactive");
       student.setDeletedOn(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
       student.setDeletedBy("Admin");
        studentRepository.save(student);
    }
}
