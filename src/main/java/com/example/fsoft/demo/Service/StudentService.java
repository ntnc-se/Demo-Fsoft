package com.example.fsoft.demo.Service;

import com.example.fsoft.demo.DAO.StudentDAO;
import com.example.fsoft.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public ArrayList<Student> getAllStudent(){
        return studentDAO.getAllStudents();
    }

    public Student getDetailStudent(int id){
        return studentDAO.getDetailStudent(id);
    }

    public void editStudent(Student student){
        studentDAO.editStudent(student);
    }

    public void deleteStudent(int id){
        studentDAO.deleteStudent(id);
    }

    public void addStudent(Student student){
        studentDAO.addStudent(student);
    }

}
