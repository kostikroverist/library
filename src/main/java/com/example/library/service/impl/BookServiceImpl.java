package com.example.library.service.impl;

import com.example.library.domain.Book;
import com.example.library.dto.BookDto;
import com.example.library.exception.NotFoundException;
import com.example.library.dao.BookRepository;
import com.example.library.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public void saveBook(Book book) {
        book.setFree(book.getPrice() == 0);

        bookRepository.save(book);
    }

    @Override
    public void update(long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow((() -> new NotFoundException("Book not found with this  id :" + id)));
        book.setName(bookDto.getName());
        book.setNameAuthor(bookDto.getNameAuthor());
        book.setGenre(bookDto.getGenre());
        book.setYearOfPublication(bookDto.getYearOfPublication());
        book.setPage(bookDto.getPage());
        book.setPrice(bookDto.getPrice());

        saveBook(book);
    }

    @Override
    public void deleteById(long id) {
        Book foundIdForDelete = bookRepository.findById(id).orElseThrow((() -> new NotFoundException("Book not found with this  id :" + id)));
        Long idForDelete = foundIdForDelete.getId();
        bookRepository.deleteById(idForDelete);
    }

    @Override
    public List<BookDto> getAllBook() {
        Iterable<Book> userIterable = bookRepository.findAll();

        return StreamSupport.stream(userIterable.spliterator(), false).map(book -> {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book, bookDto);
            return bookDto;
        }).collect(Collectors.toList());
    }
}
