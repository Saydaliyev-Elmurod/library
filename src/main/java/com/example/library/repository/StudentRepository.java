package com.example.library.repository;

import com.example.library.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public void save(StudentEntity student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public List<StudentEntity> list() {
        Session session = sessionFactory.openSession();
        Query<StudentEntity> query = session.createQuery("FROM StudentEntity ", StudentEntity.class);
        List<StudentEntity> studentEntityList = query.getResultList();
        session.close();
        return studentEntityList;
    }

    public StudentEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StudentEntity entity = session.find(StudentEntity.class, id);
        transaction.commit();
        session.close();
        return entity;
    }

    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE from StudentEntity where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void update(StudentEntity student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }
}
