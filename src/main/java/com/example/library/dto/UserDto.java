package com.example.library.dto;

import com.example.library.domain.Book;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class UserDto {

    private String firstName;

    private String lastName;

    private List<Book> books;

    public UserDto() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
