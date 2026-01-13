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

    @Column(name = "agebook", nullable = false)
    private Integer agebook;

    @Column(name = "status", nullable = false)
    private String status;

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

    public Integer getAgebook() {
        return agebook;
    }

    public void setAgebook(Integer agebook) {
        this.agebook = agebook;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
