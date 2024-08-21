package com.bookstoreapi.service;

import com.bookstoreapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    // Constructor to initialize some books
    public BookService() {
        books.add(new Book(1, "The Poniyan Selvan", "Kalki", 10.99, "1234567890"));
        books.add(new Book(2, "The Alchemist", "Paulo Coelho", 8.99, "0987654321"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    public Optional<Book> updateBook(int id, Book book) {
        Optional<Book> existingBook = getBookById(id);
        existingBook.ifPresent(b -> {
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            b.setPrice(book.getPrice());
            b.setIsbn(book.getIsbn());
        });
        return existingBook;
    }

    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }

    public List<Book> searchBooks(String title, String author) {
        return books.stream()
                .filter(book -> (title == null || book.getTitle().contains(title)) &&
                                (author == null || book.getAuthor().contains(author)))
                .collect(Collectors.toList());
    }
}
