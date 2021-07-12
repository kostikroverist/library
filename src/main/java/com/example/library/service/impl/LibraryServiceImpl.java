package com.example.library.service.impl;

import com.example.library.domain.Book;
import com.example.library.domain.User;
import com.example.library.dto.LibraryDto;
import com.example.library.dao.BookRepository;
import com.example.library.service.LibraryService;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryServiceImpl implements LibraryService {


    @Autowired
    private UserService userService;

    @Autowired
    private BookRepository bookRepository;


    @Override
    @Transactional
    public void takeBook(LibraryDto libraryDto) {

        User byNameOrCreate = userService.getByNameOrCreate(libraryDto.getFirstName(), libraryDto.getLastName());

        Book book = bookRepository.findByNameAndNameAuthor(libraryDto.getName(), libraryDto.getNameAuthor());


        byNameOrCreate.takeBook(book);

        userService.save(byNameOrCreate, false);

    }

    @Override
    public void returnBook(LibraryDto libraryDto) {
        User byNameOrCreate = userService.getByNameOrCreate(libraryDto.getFirstName(), libraryDto.getLastName());

        Book book = bookRepository.findByNameAndNameAuthor(libraryDto.getName(), libraryDto.getNameAuthor());

        byNameOrCreate.returnBook(book);

        bookRepository.save(book);

        userService.save(byNameOrCreate, false);

    }


}
