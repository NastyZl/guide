package com.example.guide.service;

import com.example.guide.exception.BookNotFoundException;
import com.example.guide.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id) throws BookNotFoundException;
    List<Book> getAllBooks();
    void addBook(Book book);
    List<Book> findByAuthor(String author);
}
