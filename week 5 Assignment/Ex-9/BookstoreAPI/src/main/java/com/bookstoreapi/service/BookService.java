package com.bookstoreapi.service;

import com.bookstoreapi.dto.BookDTO;
import java.util.List;

public interface BookService {
    BookDTO addBook(BookDTO bookDTO);
    BookDTO getBookById(Long id);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
    List<BookDTO> getAllBooks();
}
