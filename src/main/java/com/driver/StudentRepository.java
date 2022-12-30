package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class StudentRepository {

    HashMap<String, Student> StudentDb;
    HashMap<String, Teacher> TeacherDb;
    HashMap<String, List<String>> PairDb;

    public StudentRepository() {
        this.StudentDb = new HashMap<>();
        this.TeacherDb = new HashMap<>();
        this.PairDb = new HashMap<>();
    }

    public Student addStudent(Student student){
        return StudentDb.put(student.getName(),student);
    }

    public Teacher addTeacher(Teacher teacher){
        return TeacherDb.put(teacher.getName(), teacher);
    }

    public String addStudentTeacherPair(String student, String teacher){
        List<String> studentlist = new ArrayList<>();
        if(StudentDb.containsKey(student) && TeacherDb.containsKey(teacher)){
            if(PairDb.containsKey(teacher)){
                studentlist = PairDb.get(teacher);
            }
            studentlist.add(student);
            PairDb.put(teacher, studentlist);

        }
        return"New student-teacher pair added successfully";
    }

    public Student getStudentByName(String name){
        if(StudentDb.containsKey(name))
            return StudentDb.get(name);
        else
            return null;
    }

    public Teacher getTeacherByName(String name){
        if(TeacherDb.containsKey(name)){
            return TeacherDb.get(name);
        }
        else
            return null;
    }

    public List<String> getStudentsByTeacherName(String name){
        if (PairDb.containsKey(name)) {
            return PairDb.get(name);
        }
        else
            return null;
    }

    public List<String> getAllStudents(){
        List<String> studentlist = new ArrayList<>();
        for(String str : StudentDb.keySet()){
            studentlist.add(str);
        }
        return studentlist;
    }

    public String deleteTeacherByName(String name){
        List<String> list = new ArrayList<>();
        if(PairDb.containsKey(name)){
            list = PairDb.get(name);
        }
        PairDb.remove(name);
        TeacherDb.remove(name);
        for(String str : list){
            StudentDb.remove(str);
        }
        return " removed successfully";

    }

    public String deleteAllTeachers(){
        List<String> studentlist = new ArrayList<>();

        for(String teachername : PairDb.keySet()){
            for(String studentname : PairDb.get(teachername)){
                studentlist.add(studentname);
            }
        }
        PairDb = new HashMap<>();
        TeacherDb = new HashMap<>();
        for(String name : studentlist){
            StudentDb.remove(name);
        }
        return "All teachers deleted successfully";
    }
}
