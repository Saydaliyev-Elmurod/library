package com.example.library.repository;

import com.example.library.dto.BookEntity;
import com.example.library.dto.StudentBookEntity;
import com.example.library.dto.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentBookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(StudentBookEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public List<StudentBookEntity> list() {
        Session session = sessionFactory.openSession();
        Query<StudentBookEntity> query = session.createQuery("from StudentBookEntity ", StudentBookEntity.class);
        List<StudentBookEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public List<StudentBookEntity> getListByBookId(Integer id) {
        Session session = sessionFactory.openSession();
        Query<StudentBookEntity> query = session.createQuery("from StudentBookEntity where book.id=:id");
        List<StudentBookEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public StudentBookEntity getByID(Integer id) {
        Session session = sessionFactory.openSession();
        StudentBookEntity studentBookEntity = session.find(StudentBookEntity.class, id);
        session.close();
        return studentBookEntity;
    }

    public HashSet<StudentEntity> getStudentList() {
        Session session = sessionFactory.openSession();
        Query<StudentBookEntity> query = session.createQuery("from StudentBookEntity ");
        List<StudentBookEntity> list = query.getResultList();
        HashSet<StudentEntity> studentEntityList = new HashSet<>();
        for (StudentBookEntity entity : list) {
            studentEntityList.add(entity.getStudent());
        }
        session.close();
        return studentEntityList;
    }

    public HashSet<BookEntity> getBookList() {
        Session session = sessionFactory.openSession();
        Query<StudentBookEntity> query = session.createQuery("from StudentBookEntity ");
        List<StudentBookEntity> list = query.getResultList();
        HashSet<BookEntity> bookEntities = new HashSet<>();
        for (StudentBookEntity entity : list) {
            bookEntities.add(entity.getBook());
        }
        session.close();
        return bookEntities;
    }
}
