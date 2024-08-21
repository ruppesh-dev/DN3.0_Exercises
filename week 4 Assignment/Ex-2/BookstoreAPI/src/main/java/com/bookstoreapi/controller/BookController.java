// BookController.java (Controller Class)
package com.bookstoreapi.controller;

import com.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // GET: Retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "The poniyan selvan", "kalki", 10.99, "1234567890"));
        books.add(new Book(2L, "The alchemist", " Paulo Coelho", 8.99, "0987654321"));
        return books;
    }

    // POST: Create a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId(3L); // Simulate auto-generated ID
        return book;
    }

    // PUT: Update an existing book by ID
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return book;
    }

    // DELETE: Delete a book by ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return "Book with ID " + id + " has been deleted.";
    }
}

