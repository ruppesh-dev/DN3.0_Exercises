package com.bookstoreapi.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.bookstoreapi.controller.BookController;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO extends RepresentationModel<BookDTO> {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private String isbn;

    public void addLinks() {
        if (id != null) {
            add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel());
            add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).updateBook(id, this)).withRel("update"));
            add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).deleteBook(id)).withRel("delete"));
        }
    }
}


