package com.bookstoreapi.service;

import com.bookstoreapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private final Map<Long, Book> bookRepository;
    private Long nextId;

    // Constructor to initialize bookRepository and nextId
    public BookService() {
        this.bookRepository = new HashMap<>();
        this.nextId = 1L;

        // Initialize with a simulated book
        this.bookRepository.put(nextId++, new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", 10.99, "1234567890123"));
    }

    // Method to add a book
    public Book addBook(Book book) {
        // Assign a new ID to the book and add it to the repository
        book.setId(nextId++);
        bookRepository.put(book.getId(), book);
        return book;
    }

    // Method to get a book by ID
    public Book getBook(Long id) {
        return bookRepository.get(id);
    }

    // Method to get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepository.values());
    }

    // Method to delete a book by ID
    public boolean deleteBook(Long id) {
        if (bookRepository.containsKey(id)) {
            bookRepository.remove(id);
            return true;
        }
        return false;
    }

    // Method to delete all books
    public void deleteAllBooks() {
        bookRepository.clear(); // Clear all books from the repository
    }
}
