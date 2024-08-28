package com.bookstoreapi.mapper;

import com.bookstoreapi.dto.BookDTO;
import com.bookstoreapi.model.Book;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T14:02:58+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240215-1558, environment: Java 22.0.1 (Eclipse Adoptium)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO.BookDTOBuilder bookDTO = BookDTO.builder();

        bookDTO.author( book.getAuthor() );
        bookDTO.isbn( book.getIsbn() );
        bookDTO.price( book.getPrice() );
        bookDTO.title( book.getTitle() );

        return bookDTO.build();
    }

    @Override
    public Book toBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setAuthor( bookDTO.getAuthor() );
        book.setIsbn( bookDTO.getIsbn() );
        if ( bookDTO.getPrice() != null ) {
            book.setPrice( bookDTO.getPrice() );
        }
        book.setTitle( bookDTO.getTitle() );

        return book;
    }
}
