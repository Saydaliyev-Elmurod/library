package com.example.library.service;

import com.example.library.dto.StudentEntity;
import com.example.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create")
    public void create(@RequestBody StudentEntity student) {
        studentRepository.save(student);
    }

    @GetMapping("/list")
    public List<StudentEntity> getList() {
        return studentRepository.list();
    }

    @GetMapping("/get/{id}")
    public StudentEntity getStudentByID(@PathVariable("id") Integer id) {
        return studentRepository.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        studentRepository.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Integer id,
                        @RequestBody StudentEntity student) {
        student.setId(id);
        studentRepository.update(student);
    }

}
