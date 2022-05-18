package com.itstep.book.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Books")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    private String name;
    private String author;
    private int relYear;
    private Style style;

}
