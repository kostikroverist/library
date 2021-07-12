package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.dto.BookDto;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public void save(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
        bookService.update(id, bookDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        bookService.deleteById(id);
    }

    @GetMapping("/getall")
    public List<BookDto> getAll() {
        return bookService.getAllBook();
    }
}
