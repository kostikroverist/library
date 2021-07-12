package com.example.library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private int page;
    @Column
    private String nameAuthor;
    @Column
    private int yearOfPublication;
    @Column
    private double price;
    @Column
    private boolean free;

    @Column
    private String genre;

    @JsonIgnore
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Book() {
    }


    public Book(String name, int page, String nameAuthor, int yearOfPublication, double price, boolean free, String genre, User user) {
        this.name = name;
        this.page = page;
        this.nameAuthor = nameAuthor;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
        this.free = free;
        this.genre = genre;
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return page == book.page &&
                yearOfPublication == book.yearOfPublication &&
                Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                Objects.equals(nameAuthor, book.nameAuthor) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(user, book.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, page, nameAuthor, yearOfPublication, genre, user);
    }


}
