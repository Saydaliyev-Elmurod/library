package com.example.library.entity;

import com.example.library.enums.BookStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@Entity
@Table(name = "student_book")
public class StudentBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalDateTime createdDate=LocalDateTime.now();
    @Column
    private LocalDateTime returnedDate;
    @Column
    private Integer duration;
    @Column
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private StudentEntity student;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private BookEntity book;


}
