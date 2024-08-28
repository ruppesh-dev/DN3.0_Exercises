package com.bookstoreapi.service;

import com.bookstoreapi.dto.BookDTO;
import com.bookstoreapi.model.Book;
import com.bookstoreapi.repository.BookRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = Book.builder()
                .title(bookDTO.getTitle())
                .author(bookDTO.getAuthor())
                .price(bookDTO.getPrice())
                .isbn(bookDTO.getIsbn())
                .build();
        book = bookRepository.save(book);
        bookDTO.setId(book.getId());
        bookDTO.addLinks();
        
        // Increment custom metric for books created
        meterRegistry.counter("books_created_total").increment();

        return bookDTO;
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        BookDTO bookDTO = BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .isbn(book.getIsbn())
                .build();
        bookDTO.addLinks();
        return bookDTO;
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setIsbn(bookDTO.getIsbn());
        book = bookRepository.save(book);
        bookDTO.setId(book.getId());
        bookDTO.addLinks();
        return bookDTO;
    }

    @Override
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> {
            BookDTO bookDTO = BookDTO.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .price(book.getPrice())
                    .isbn(book.getIsbn())
                    .build();
            bookDTO.addLinks();
            return bookDTO;
        }).collect(Collectors.toList());
    }
}
