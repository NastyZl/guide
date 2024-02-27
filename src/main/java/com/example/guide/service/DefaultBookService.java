package com.example.guide.service;

import com.example.guide.entity.BookEntity;
import com.example.guide.exception.BookNotFoundException;
import com.example.guide.mapper.BookToEntityMapper;
import com.example.guide.model.Book;
import com.example.guide.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService{

    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;

    @Override
    public Book getBookById(Long id) throws BookNotFoundException {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(()-> new BookNotFoundException("Book not found: id= " + id));
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable =bookRepository.findAll();
        ArrayList<Book> books= new ArrayList<>();
        for(BookEntity bookEntity: iterable) {
            books.add(mapper.bookEntityToBook(bookEntity));
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(mapper.bookToBookEntity(book));
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findAllByAuthorContaining(author).stream().map(mapper::bookEntityToBook).collect(Collectors.toList());
    }
}
