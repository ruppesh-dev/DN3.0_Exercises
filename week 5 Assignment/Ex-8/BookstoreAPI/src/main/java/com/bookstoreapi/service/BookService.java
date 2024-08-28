package com.bookstoreapi.service;

import com.bookstoreapi.dto.BookDTO;
import com.bookstoreapi.mapper.BookMapper;
import com.bookstoreapi.model.Book;
import com.bookstoreapi.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toBook(bookDTO);
        book = bookRepository.save(book);
        return BookMapper.INSTANCE.toBookDTO(book);
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        return BookMapper.INSTANCE.toBookDTO(book);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setIsbn(bookDTO.getIsbn());
        book = bookRepository.save(book);
        return BookMapper.INSTANCE.toBookDTO(book);
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
		return false;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookMapper.INSTANCE::toBookDTO)
                .collect(Collectors.toList());
    }
}

