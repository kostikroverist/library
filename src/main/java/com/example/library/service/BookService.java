package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.dto.BookDto;

import java.util.List;

public interface BookService {

    void saveBook(Book book);

    void update(long id, BookDto bookDto);

    void deleteById(long id);

    List<BookDto> getAllBook();


}
