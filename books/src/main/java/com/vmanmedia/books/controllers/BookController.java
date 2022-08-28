package com.vmanmedia.books.controllers;

import com.vmanmedia.books.dtos.BookListResponseDTO;
import com.vmanmedia.books.dtos.CreateBookResponseDTO;
import com.vmanmedia.books.repositories.BookRepository;
import com.vmanmedia.books.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookListResponseDTO>> getAllBooks() {
        List<BookListResponseDTO> response = bookService.getAllBooks();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/book/{book_id}")
    public ResponseEntity<CreateBookResponseDTO> getBookById(@PathVariable("book_id") Long book_id) {
        CreateBookResponseDTO response = bookService.getBookById(book_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
