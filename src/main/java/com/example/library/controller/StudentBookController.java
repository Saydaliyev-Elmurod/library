package com.example.library.controller;

import com.example.library.entity.BookEntity;
import com.example.library.entity.StudentBookEntity;
import com.example.library.entity.StudentEntity;
import com.example.library.enums.BookStatus;
import com.example.library.service.StudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/student_book")
public class StudentBookController {
    @Autowired
    private StudentBookService studentBookService;

    @PostMapping("/create")
    public void create(@RequestBody StudentBookEntity entity) {
        entity.setBookStatus(BookStatus.TAKEN);
        entity.setDuration(7);
        studentBookService.save(entity);
    }

    @GetMapping("/{id}")
    public StudentBookEntity getByID(@PathVariable("id") Integer id) {
        return studentBookService.getByID(id);
    }

    //return studentBook list 3
    @GetMapping("/list")
    public List<StudentBookEntity> list() {
        return studentBookService.list();
    }

    // return all studentBook where book id = {id}   4
    @GetMapping("/book/{id}")
    public List<StudentBookEntity> getListByBookId(@PathVariable("id") Integer id) {
        return studentBookService.getListByBookId(id);
    }

    //return all student who get book   5
    @GetMapping("/student/list")
    public HashSet<StudentEntity> getStudentList() {
        return studentBookService.getStudentList();
    }

    //return all book that taken    6
    @GetMapping("/book/list")
    public HashSet<BookEntity> getBookList() {
        return studentBookService.getBookList();
    }

}
