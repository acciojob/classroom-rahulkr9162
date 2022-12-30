package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public Teacher addTeacher(Teacher teacher){
        return studentRepository.addTeacher(teacher);
    }

    public String addStudentTeacherPair(String student, String teacher){
       return studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name){
        Student student = studentRepository.getStudentByName(name);
        return student;
    }

    public Teacher getTeacherByName(String name){
        Teacher teacher = studentRepository.getTeacherByName(name);
        return teacher;
    }
    public List<String> getStudentsByTeacherName(String name){
        List<String> student = studentRepository.getStudentsByTeacherName(name);
        return student;
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public String deleteTeacherByName(String name){
        return studentRepository.deleteTeacherByName(name);
    }

    public String deleteAllTeachers(){
        return studentRepository.deleteAllTeachers();
    }
}
