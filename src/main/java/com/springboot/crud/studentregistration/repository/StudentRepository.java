package com.springboot.crud.studentregistration.repository;

import com.springboot.crud.studentregistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


   /* @Query(nativeQuery = true, value = "SELECT * FROM studentregistration.student LIMIT 2;")
    List<Student> fetchStudentList();*/

}
