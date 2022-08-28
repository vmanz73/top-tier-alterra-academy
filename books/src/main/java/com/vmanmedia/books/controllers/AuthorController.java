package com.vmanmedia.books.controllers;

import com.vmanmedia.books.dtos.CreateAuthorRequest;
import com.vmanmedia.books.dtos.CreateBookRequestDTO;
import com.vmanmedia.books.dtos.CreateBookResponseDTO;
import com.vmanmedia.books.dtos.CreateResponseAuthorDTO;
import com.vmanmedia.books.repositories.AuthorRepository;
import com.vmanmedia.books.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class AuthorController {

    @Autowired
    IAuthorService authorService;

    @PostMapping("/authors")
    public ResponseEntity<CreateResponseAuthorDTO> createAuthor(@RequestBody CreateAuthorRequest request) {
        CreateResponseAuthorDTO response = authorService.CreateNewAuthor(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/authors")
    public ResponseEntity<List<CreateResponseAuthorDTO>> getAllAuthors() {
        List<CreateResponseAuthorDTO> response = authorService.getAllAuthors();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/author/{author_id}")
    public ResponseEntity<CreateResponseAuthorDTO> getAuthorById(@PathVariable("author_id")  Long author_id) {
        CreateResponseAuthorDTO response = authorService.getAuthorById(author_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/author/{author_id}")
    public ResponseEntity<CreateResponseAuthorDTO> updateAuthor(@PathVariable("author_id") Long author_id,
                                                                @RequestBody CreateAuthorRequest request){
        CreateResponseAuthorDTO response = authorService.updateAuthor(author_id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/author/{author_id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void DeleteMessage(@PathVariable Long author_id) {
        authorService.DeletebyId(author_id);
    }
    
    @PostMapping("/author/{author_id}/book")
    public ResponseEntity<CreateBookResponseDTO> createBook(@PathVariable ("author_id") Long author_id,
                                                            @RequestBody CreateBookRequestDTO request){
        CreateBookResponseDTO response = authorService.createBook(author_id, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
