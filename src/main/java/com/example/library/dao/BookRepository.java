package com.example.library.dao;

import com.example.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {


    Book findByNameAndNameAuthor(String name, String nameAuthor);
}
