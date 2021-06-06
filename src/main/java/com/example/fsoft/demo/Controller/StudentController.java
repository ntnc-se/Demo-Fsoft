package com.example.fsoft.demo.Controller;

import com.example.fsoft.demo.Model.Student;
import com.example.fsoft.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/api/students")
    public ArrayList<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/api/student/{id}")
    public Student getDetailStudent(@PathVariable int id){
        return studentService.getDetailStudent(id);
    }

    @DeleteMapping("/api/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/student/add")
    public ResponseEntity<Void> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/student/edit")
    public ResponseEntity<Void> editStudent(@RequestBody Student student){
        studentService.editStudent(student);
        return ResponseEntity.noContent().build();
    }

}

