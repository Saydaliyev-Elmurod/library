package com.example.library.controller;

import com.example.library.entity.StudentEntity;
import com.example.library.repository.BookRepository;
import com.example.library.repository.StudentRepository;
import com.example.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody StudentEntity student) {
        studentService.save(student);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(studentService.list());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudentByID(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody StudentEntity student) {
        student.setId(id);
        studentService.update(student);
        return ResponseEntity.ok(student);
    }
}
