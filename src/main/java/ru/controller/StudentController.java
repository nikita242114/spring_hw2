package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.model.Student;
import ru.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){

        return ResponseEntity.ok().body(service.getAllStudents());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Student> getStudent(@PathVariable Long id){
        return  ResponseEntity.ok().body(service.getStudent(id));
    }

    @GetMapping("/search")
    public  ResponseEntity<List<Student>> getStudent(@RequestParam String nameSubstring){
        return  ResponseEntity.ok().body(service.getAllStudentsSubstringName(nameSubstring));
    }

    @GetMapping("/group/{group}")
    public  ResponseEntity<List<Student>> getAllStudentsByGroup(@PathVariable String group){
        return  ResponseEntity.ok().body(service.getAllStudentsByGroup(group));
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(service.addStudent(student), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        return new ResponseEntity<>(service.updateStudent(id,student), HttpStatus.OK);
    }
}