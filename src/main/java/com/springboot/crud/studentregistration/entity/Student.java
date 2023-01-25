package com.springboot.crud.studentregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rollNo;

    @NotNull(message = "First Name should not be null")
    @Size(min = 1, max = 30)
    private String firstName;

    @NotNull(message = "Last Name should not be null")
    @Size(min = 1, max = 30)
    private String lastName;

    @NotNull(message = "DOB should not be null")
    private Date dob;

    private LocalDate doj = LocalDate.now();

    @NotNull
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Email is not valid")
    private String email;

    @NotNull(message = "Department should not be null")
    private String department;

    @NotNull(message = "Age should not be null")
    @Min(value = 18, message = "Student is not eligible as the age should not be less than 18")
    @Max(value = 20, message = "Student is not eligible as the age should not be greater than 18")
    private int age;

    private String address;

    private String deletedOn;

    private Timestamp createdOn = Timestamp.valueOf(LocalDateTime.now());

    private String status = "active";

    private String DeletedBy = "";
}
