package com.example.fsoft.demo.DAO;

import com.example.fsoft.demo.Model.Student;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class StudentDAO extends DBContext{

    public ArrayList<Student> getAllStudents(){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select student_demo.id, " +
                "student_demo.name, " +
                "student_demo.age, " +
                "student_demo.major, " +
                "student_demo.gender, " +
                "student_demo.studentCode " +
                "from student_demo";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("major"),
                        resultSet.getBoolean("gender"),
                        resultSet.getString("studentCode"));
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {}
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {}
            }
            if (connection == null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
        return list;
    }

    public Student getDetailStudent(int id){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select student_demo.id, " +
                "student_demo.name, " +
                "student_demo.age, " +
                "student_demo.major, " +
                "student_demo.gender, " +
                "student_demo.studentCode " +
                "from student_demo where student_demo.id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("major"),
                        resultSet.getBoolean("gender"),
                        resultSet.getString("studentCode"));
                return student;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {}
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {}
            }
            if (connection == null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
        return null;
    }

    public void deleteStudent(int id){
        PreparedStatement preparedStatement = null;
        String sql = "delete from student_demo where student_demo.id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {}
            }
            if (connection == null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void addStudent(Student student){
        PreparedStatement preparedStatement = null;
        String sql = "insert into student_demo (student_demo.id, " +
                "student_demo.name, " +
                "student_demo.age, " +
                "student_demo.major, " +
                "student_demo.gender, " +
                "student_demo.studentCode) " +
                "values (?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getMajor());
            preparedStatement.setBoolean(5, student.isGender());
            preparedStatement.setString(6, student.getStudentCode());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {}
            }
            if (connection == null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void editStudent(Student student){
        PreparedStatement preparedStatement = null;
        String sql = "update student_demo " +
                "set student_demo.name = ? , " +
                "student_demo.age = ? , " +
                "student_demo.major = ? , " +
                "student_demo.gender = ? , " +
                "student_demo.studentCode = ?  " +
                "where student_demo.id = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getMajor());
            preparedStatement.setBoolean(4, student.isGender());
            preparedStatement.setString(5, student.getStudentCode());
            preparedStatement.setInt(6, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {}
            }
            if (connection == null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

}
