package ru.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.model.Student;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class StudentRepositories {
    private final AtomicLong counter =new AtomicLong();
    private final Map<Long, Student> students = new ConcurrentHashMap<>();

    @PostConstruct
    public void fillStudents(){
        students.put(counter.incrementAndGet(),new Student(counter.get(),"Artem", "Tester"));
        students.put(counter.incrementAndGet(),new Student(counter.get(),"Kris", "Tester"));
        students.put(counter.incrementAndGet(),new Student(counter.get(),"Ivan", "Senior"));
        students.put(counter.incrementAndGet(),new Student(counter.get(),"Vika", "Junior"));
        students.put(counter.incrementAndGet(),new Student(counter.get(),"Javachir", "Midle"));
    }

    public List<Student> getAllStudents() { return new ArrayList<>(students.values()); }

    public Student getStudent (Long id){
        return students.get(id);
    }
    public List<Student> getAllStudentsSubstringName (String nameSubstring) {
        return  students.values().stream().filter(student ->student.getName().contains(nameSubstring)).toList();
    }
    public List<Student> getAllStudentsByGroup(String group){
        return students.values().stream().filter(student -> student.getGroupName().contains(group)).toList();
    }
    public Student addStudent(Student student){
        if(student.getId() == null){
            student.setId(counter.incrementAndGet());
        }
        students.put(student.getId(), student);
        return student;
    }
    public void deleteStudent(Long id){
        students.remove(id);
    }
    public Student updateStudents(Long id, Student student){
        Student updateStudent = students.get(id);
        if(updateStudent != null){
            updateStudent.setName(student.getName());
            updateStudent.setGroupName(student.getGroupName());

        }
        return updateStudent;
    }


}