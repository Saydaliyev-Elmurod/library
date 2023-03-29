package com.example.library.service;

import com.example.library.dto.Book;
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
    public Book createBook(@RequestBody Book book) {
        bookRepository.save(book);
//        System.out.println(book);
        return book;
    }

    @GetMapping("/list")
    public List<Book> getBookList() {
        return bookRepository.list();
    }

    @GetMapping("/list/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookRepository.list().stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookRepository.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Book book) {
        book.setId(id);
        bookRepository.update(book);
    }

}
