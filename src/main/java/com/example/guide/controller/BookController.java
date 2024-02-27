package com.example.guide.controller;

import com.example.guide.dto.BookRequest;
import com.example.guide.exception.BookNotFoundException;
import com.example.guide.mapper.BookToDtoMapper;
import com.example.guide.model.Book;
import com.example.guide.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookToDtoMapper mapper;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.getBookById(id);

    }

    @GetMapping()
    public List<Book> getAllBook(@RequestParam(required = false) String author) {
        if (author!=null){
            return bookService.findByAuthor(author);
        }
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest bookRequest) {
        bookService.addBook(mapper.addBookRequestToBook(bookRequest));
    }

}
