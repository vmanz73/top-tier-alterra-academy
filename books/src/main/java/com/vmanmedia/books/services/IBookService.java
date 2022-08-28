package com.vmanmedia.books.services;

import com.vmanmedia.books.dtos.BookListResponseDTO;
import com.vmanmedia.books.dtos.CreateBookResponseDTO;

import java.util.List;

public interface IBookService {
    List<BookListResponseDTO> getAllBooks();

    CreateBookResponseDTO getBookById(Long book_id);
}
