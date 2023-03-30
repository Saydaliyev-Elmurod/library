package com.example.library.service;

import com.example.library.dto.BookEntity;
import com.example.library.dto.StudentBookEntity;
import com.example.library.dto.StudentEntity;
import com.example.library.enums.BookStatus;
import com.example.library.repository.StudentBookRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/student_book")
public class StudentBookService {
    @Autowired
    private StudentBookRepository studentBookRepository;

    @PostMapping("/create")
    public void create(@RequestBody StudentBookEntity entity) {
        entity.setBookStatus(BookStatus.TAKEN);
        entity.setDuration(7);
        studentBookRepository.save(entity);
    }

    @GetMapping("/{id}")
    public StudentBookEntity getByID(@PathVariable("id") Integer id) {
        return studentBookRepository.getByID(id);
    }

    //return studentBook list 3
    @GetMapping("/list")
    public List<StudentBookEntity> list() {
        return studentBookRepository.list();
    }

    // return all studentBook where book id = {id}   4
    @GetMapping("/book/{id}")
    public List<StudentBookEntity> getListByBookId(@PathVariable("id") Integer id) {
        return studentBookRepository.getListByBookId(id);
    }

    //return all student who get book   5
    @GetMapping("/student/list")
    public HashSet<StudentEntity> getStudentList() {
        return studentBookRepository.getStudentList();
    }

    //return all book that taken    6
    @GetMapping("/book/list")
    public HashSet<BookEntity> getBookList() {
        return studentBookRepository.getBookList();
    }

}
