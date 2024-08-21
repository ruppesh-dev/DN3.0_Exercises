package com.bookstoreapi.controller;

import com.bookstoreapi.model.Book;
import com.bookstoreapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;  // Import the @Valid annotation

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // Constructor injection of the BookService
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // POST endpoint to add a book
    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {  // Use @Valid here
        // Use the service to add the book
        Book createdBook = bookService.addBook(book);

        // Return response with status and custom header
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Custom-Header", "Book Created")
                .body(createdBook);
    }

    // GET endpoint to retrieve a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        // Use the service to get the book
        Book book = bookService.getBook(id);

        if (book == null) {
            // Return a 404 status if the book is not found
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .header("Custom-Header", "Book Not Found")
                    .body(null);
        }

        // Return response with status and custom header
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Custom-Header", "Book Retrieved")
                .body(book);
    }

    // GET endpoint to retrieve all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        // Use the service to get all books
        List<Book> books = bookService.getAllBooks();

        // Return response with status and custom header
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Custom-Header", "Books Retrieved")
                .body(books);
    }

    // DELETE endpoint to delete all books
    @DeleteMapping
    public ResponseEntity<Void> deleteAllBooks() {
        // Use the service to delete all books
        bookService.deleteAllBooks();
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .header("Custom-Header", "All Books Deleted")
                .build();
    }

    // Endpoint to test exception handling
    @GetMapping("/testException")
    public String testException() {
        throw new IllegalArgumentException("This is a test exception");
    }
}
