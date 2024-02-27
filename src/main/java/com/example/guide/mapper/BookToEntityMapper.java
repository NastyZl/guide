package com.example.guide.mapper;

import com.example.guide.entity.BookEntity;
import com.example.guide.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity bookToBookEntity (Book book);
    Book bookEntityToBook (BookEntity bookEntity);
}
