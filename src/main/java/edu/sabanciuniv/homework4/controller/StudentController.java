package edu.sabanciuniv.homework4.controller;


import edu.sabanciuniv.homework4.model.Student;
import edu.sabanciuniv.homework4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Add new student to database
    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }


    //Get all students from database
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    //Get a student with specific ID from database
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }



    //Update a student data on database
    @PutMapping("/students")
    public Student updateExistingStudent (@RequestBody Student student){
        return studentService.updateExistingStudent(student);
    }


    //Delete a student data from database
    @DeleteMapping("/students")
    public void deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
    }
}
