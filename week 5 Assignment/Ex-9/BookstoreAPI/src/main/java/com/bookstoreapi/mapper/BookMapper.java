package com.bookstoreapi.mapper;

import com.bookstoreapi.dto.BookDTO;
import com.bookstoreapi.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toBookDTO(Book book);
    Book toBook(BookDTO bookDTO);
}
