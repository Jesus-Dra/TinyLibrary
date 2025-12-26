package com.tinylibrary.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "editorial", length = 100, nullable = false)
    private String editorial;

    @Column(name = "ageBook", nullable = false)
    private Integer ageBook;

    public Book(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getAgeBook() {
        return ageBook;
    }

    public void setAgeBook(Integer ageBook) {
        this.ageBook = ageBook;
    }
}
