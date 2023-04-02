package com.example.library.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private Integer publishYear;

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
