package com.example.library.controller;

import com.example.library.dto.LibraryDto;
import com.example.library.service.impl.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryServiceImpl libraryService;

    @PostMapping("/takebook")
    public void takeBook(@RequestBody LibraryDto libraryDto) {
        libraryService.takeBook(libraryDto);
    }

    @PostMapping("/returnbook")
    public void returnBook(@RequestBody LibraryDto libraryDto) {
        libraryService.returnBook(libraryDto);
    }
}
