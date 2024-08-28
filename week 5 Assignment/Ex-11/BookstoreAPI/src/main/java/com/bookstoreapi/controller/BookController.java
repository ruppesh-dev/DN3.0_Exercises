package com.bookstoreapi.controller;

import com.bookstoreapi.dto.BookDTO;
import com.bookstoreapi.service.BookService;
import com.onlinebookstore.config.CustomMetrics; // Ensure this import is correct
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomMetrics customMetrics; // Inject custom metrics

    @PostMapping(produces = { "application/json", "application/xml" })
    public ResponseEntity<EntityModel<BookDTO>> createBook(@RequestBody @Valid BookDTO bookDTO) {
        BookDTO createdBook = bookService.addBook(bookDTO);

        // Increment custom metric
        customMetrics.incrementBookCreationCounter();

        EntityModel<BookDTO> entityModel = EntityModel.of(createdBook,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(createdBook.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books"));

        return ResponseEntity.status(HttpStatus.CREATED).body(entityModel);
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable Long id) {
        BookDTO bookDTO = bookService.getBookById(id);

        EntityModel<BookDTO> entityModel = EntityModel.of(bookDTO,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books"));

        return ResponseEntity.ok(entityModel);
    }

    @PutMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<EntityModel<BookDTO>> updateBook(@PathVariable Long id, @RequestBody @Valid BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);

        EntityModel<BookDTO> entityModel = EntityModel.of(updatedBook,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(updatedBook.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books"));

        return ResponseEntity.ok(entityModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = { "application/json", "application/xml" })
    public ResponseEntity<CollectionModel<EntityModel<BookDTO>>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();

        List<EntityModel<BookDTO>> bookModels = books.stream()
                .map(book -> EntityModel.of(book,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(book.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(bookModels,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withSelfRel()));
    }
}


