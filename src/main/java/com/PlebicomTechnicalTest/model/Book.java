package com.PlebicomTechnicalTest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
//import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idbooks", nullable = false)
    private int id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="author", nullable = false)
    private String author;
    @Column(name="releasedate")
    private String releaseDate;
}
