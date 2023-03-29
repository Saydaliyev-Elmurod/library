package com.example.library.repository;

import com.example.library.dto.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public List<Book> list() {
        Session session = sessionFactory.openSession();
        Query<Book> query = session.createQuery("FROM Book ", Book.class);
        List<Book> bookingEntityList = query.getResultList();
        session.close();
        return bookingEntityList;
    }

    public Book getById(Integer id) {
        Session session = sessionFactory.openSession();
        Book c = session.find(Book.class, id);
        session.close();
        return c;
    }

    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Book where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
    public void update(Book entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }
}
