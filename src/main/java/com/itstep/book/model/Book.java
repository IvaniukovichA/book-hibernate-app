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
    private boolean isAtUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRelYear() {
        return relYear;
    }

    public void setRelYear(int relYear) {
        this.relYear = relYear;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public boolean isAtUser() {
        return isAtUser;
    }

    public void setAtUser(boolean atUser) {
        isAtUser = atUser;
    }
}
