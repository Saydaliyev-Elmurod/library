package com.example.library.repository;

import com.example.library.entity.BookEntity;
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

    public void save(BookEntity book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public List<BookEntity> list() {
        Session session = sessionFactory.openSession();
        Query<BookEntity> query = session.createQuery("FROM BookEntity ", BookEntity.class);
        List<BookEntity> bookingEntityList = query.getResultList();
        session.close();
        return bookingEntityList;
    }

    public BookEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        BookEntity c = session.find(BookEntity.class, id);
        session.close();
        return c;
    }

    public int delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE from BookEntity where id =:id");
        query.setParameter("id", id);
        int r = query.executeUpdate();
        transaction.commit();
        session.close();
        return r;
    }

    public void update(BookEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }
}
