package com.vmanmedia.books.services;

import com.vmanmedia.books.dtos.CreateAuthorRequest;
import com.vmanmedia.books.dtos.CreateBookRequestDTO;
import com.vmanmedia.books.dtos.CreateBookResponseDTO;
import com.vmanmedia.books.dtos.CreateResponseAuthorDTO;

import java.util.List;

public interface IAuthorService {
    CreateResponseAuthorDTO CreateNewAuthor(CreateAuthorRequest resquestDTO);
    List<CreateResponseAuthorDTO> getAllAuthors();

    CreateResponseAuthorDTO getAuthorById(Long author_id);

    CreateResponseAuthorDTO updateAuthor(Long author_id, CreateAuthorRequest request);

    void DeletebyId(Long author_id);

    CreateBookResponseDTO createBook(Long author_id, CreateBookRequestDTO request);
}
