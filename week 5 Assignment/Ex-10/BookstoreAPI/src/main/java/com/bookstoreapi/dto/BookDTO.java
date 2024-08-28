package com.bookstoreapi.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.bookstoreapi.controller.BookController;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO extends RepresentationModel<BookDTO> {
    
    @JacksonXmlProperty(localName = "id")
    @JsonProperty("id")
    private Long id;
    
    @JacksonXmlProperty(localName = "title")
    @JsonProperty("title")
    private String title;
    
    @JacksonXmlProperty(localName = "author")
    @JsonProperty("author")
    private String author;
    
    @JacksonXmlProperty(localName = "price")
    @JsonProperty("price")
    private Double price;
    
    @JacksonXmlProperty(localName = "isbn")
    @JsonProperty("isbn")
    private String isbn;

    // Method to add HATEOAS links
    public void addLinks() {
        if (id != null) {
            add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel());
            add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).updateBook(id, this)).withRel("update"));
            add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).deleteBook(id)).withRel("delete"));
        }
    }
}
