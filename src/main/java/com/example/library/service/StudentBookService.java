package com.example.library.service;

import com.example.library.entity.BookEntity;
import com.example.library.entity.StudentBookEntity;
import com.example.library.entity.StudentEntity;
import com.example.library.exp.NotValidException;
import com.example.library.repository.StudentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class StudentBookService {
    @Autowired
    private StudentBookRepository studentBookRepository;

    public void save(StudentBookEntity entity) {
        if (entity.getBook().getId() == null) {
            throw new NotValidException("Book not found");
        } else if (entity.getStudent().getId() == null) {
            throw new NotValidException("Student not found");
        }
        studentBookRepository.save(entity);
    }

    public StudentBookEntity getByID(Integer id) {
        StudentBookEntity studentBookEntity = studentBookRepository.getByID(id);
        if (studentBookEntity==null){
            throw new NotValidException("Id not found");
        }
        return studentBookEntity;
    }

    public List<StudentBookEntity> list() {
        return studentBookRepository.list();
    }

    public List<StudentBookEntity> getListByBookId(Integer id) {
        return studentBookRepository.getListByBookId(id);
    }

    public HashSet<StudentEntity> getStudentList() {
        return studentBookRepository.getStudentList();
    }

    public HashSet<BookEntity> getBookList() {
        return studentBookRepository.getBookList();
    }
}
