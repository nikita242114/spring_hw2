package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.model.Student;
import ru.repositories.StudentRepositories;


import java.util.List;
@Service
public class StudentService {
    private final StudentRepositories repositories;

    @Autowired
    public StudentService(StudentRepositories repositories) {
        this.repositories = repositories;
    }
    public List<Student> getAllStudents(){
        return repositories.getAllStudents();
    }
    public Student getStudent (Long id){
        return  repositories.getStudent(id);
    }
    public List<Student> getAllStudentsSubstringName (String nameSubstring){
        return repositories.getAllStudentsSubstringName(nameSubstring);
    }
    public List<Student> getAllStudentsByGroup(String group){
        return repositories.getAllStudentsByGroup(group);
    }
    public Student addStudent(Student student){
        return repositories.addStudent(student);
    }
    public void deleteStudent(Long id){
        repositories.deleteStudent(id);
    }
    public Student updateStudent(Long id, Student student){
        return repositories.updateStudents(id,student);
    }

}
