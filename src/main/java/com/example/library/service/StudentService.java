package com.example.library.service;

import com.example.library.entity.StudentEntity;
import com.example.library.exp.NotValidException;
import com.example.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public StudentEntity update(StudentEntity student) throws NotValidException {
        StudentEntity student1 = get(student.getId());
        studentRepository.update(student);
        return student1;
    }

    public StudentEntity delete(Integer id) throws NotValidException {
        StudentEntity student = get(id);
        studentRepository.delete(id);
        return student;
    }

    public StudentEntity getById(Integer id) throws NotValidException {
        return get(id);
    }

    private StudentEntity get(Integer id) {
        StudentEntity student = get(id);
        return student;
    }

    public List<StudentEntity> list() throws NotValidException {
        List<StudentEntity> list = studentRepository.list();
        if (list.isEmpty()) {
            throw new NotValidException("List is empty");
        }
        return list;
    }

    public void save(StudentEntity student) throws NotValidException {
        if (student.getSurname() == null) {
            throw new NotValidException("Surname is null");
        } else if (student.getName() == null) {
            throw new NotValidException("Name is null");
        } else if (student.getPhone() == null) {
            throw new NotValidException("Phone is null");
        }
        studentRepository.save(student);
    }
}
