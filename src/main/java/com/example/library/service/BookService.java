package com.example.library.service;

import com.example.library.entity.BookEntity;
import com.example.library.exp.NotValidException;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public void save(BookEntity book) throws NotValidException {
        checkSave(book);
        bookRepository.save(book);
    }

    private void checkSave(BookEntity book) {
        if (book.getTitle() == null) {
            throw new NotValidException("Title is null");
        } else if (book.getAuthor() == null) {
            throw new NotValidException("Author is null");
        } else if (book.getPublishYear() == null) {
            throw new NotValidException("Publish year is null");
        }
    }

    public List<BookEntity> list() throws NotValidException {
        List<BookEntity> list = bookRepository.list();
        if (list.isEmpty()) {
            throw new NotValidException("List is empty");
        }
        return list;

    }

    public BookEntity getById(Integer id) throws NotValidException {
        return get(id);
    }

    public BookEntity delete(Integer id) throws NotValidException {
        if (bookRepository.delete(id) < 1) {
            throw new NotValidException("Id not found");
        }
        return getById(id);

    }

    public void update(BookEntity book) throws NotValidException {
        checkSave(book);
        bookRepository.update(book);
    }

    public BookEntity get(Integer id) {
        BookEntity book = bookRepository.getById(id);
        if (book == null) {
            throw new NotValidException("Book not found");
        }
        return book;
    }
}
