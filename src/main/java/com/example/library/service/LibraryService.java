package com.example.library.service;

import com.example.library.dto.LibraryDto;

public interface LibraryService {

    void takeBook(LibraryDto libraryDto);

    void returnBook(LibraryDto libraryDto);

}
