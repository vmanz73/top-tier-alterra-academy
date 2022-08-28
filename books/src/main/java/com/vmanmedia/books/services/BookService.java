package com.vmanmedia.books.services;

import com.vmanmedia.books.dtos.BookListResponseDTO;
import com.vmanmedia.books.dtos.CreateBookRequestDTO;
import com.vmanmedia.books.dtos.CreateBookResponseDTO;
import com.vmanmedia.books.dtos.CreateResponseAuthorDTO;
import com.vmanmedia.books.entities.Books;
import com.vmanmedia.books.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService{
    @Autowired
    BookRepository bookRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<BookListResponseDTO> getAllBooks() {
        List<Books> books = bookRepository.findAll();
        if (!books.isEmpty()) {
            return books.stream()
                    .map(book -> modelMapper.map(book, BookListResponseDTO.class))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public CreateBookResponseDTO getBookById(Long book_id) {
        Optional<Books> book_optional = bookRepository.findById(book_id);
        if(book_optional.isPresent()){
            return modelMapper.map(book_optional, CreateBookResponseDTO.class);
        }
        return null;
    }
}
