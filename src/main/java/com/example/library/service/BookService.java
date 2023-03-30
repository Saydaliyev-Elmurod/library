package com.example.library.service;

import com.example.library.dto.BookEntity;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/create")
    public BookEntity createBook(@RequestBody BookEntity book) {
        bookRepository.save(book);
//        System.out.println(book);
        return book;
    }

    @GetMapping("/list")
    public List<BookEntity> getBookList() {
        return bookRepository.list();
    }

    @GetMapping("/get/{id}")
    public BookEntity getBookById(@PathVariable("id") Integer id) {
        return bookRepository.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookRepository.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody BookEntity book) {
        book.setId(id);
        bookRepository.update(book);
    }

}
