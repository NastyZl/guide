package com.example.guide.mapper;

import com.example.guide.dto.BookRequest;
import com.example.guide.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
    Book addBookRequestToBook(BookRequest bookRequest);
}
