package com.example.library.controller;

import com.example.library.entity.BookEntity;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody BookEntity book) {
        bookService.save(book);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getBookList() {
        return ResponseEntity.ok(bookService.list());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(bookService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody BookEntity book) {
        book.setId(id);
        bookService.update(book);
        return ResponseEntity.ok().build();
    }


}
