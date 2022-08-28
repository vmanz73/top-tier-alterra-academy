package com.vmanmedia.books.services;

import com.vmanmedia.books.dtos.CreateAuthorRequest;
import com.vmanmedia.books.dtos.CreateBookRequestDTO;
import com.vmanmedia.books.dtos.CreateBookResponseDTO;
import com.vmanmedia.books.dtos.CreateResponseAuthorDTO;
import com.vmanmedia.books.entities.Authors;
import com.vmanmedia.books.entities.Books;
import com.vmanmedia.books.exceptions.ValidationErrorException;
import com.vmanmedia.books.repositories.AuthorRepository;
import com.vmanmedia.books.repositories.BookRepository;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ModelMapper modelMapper;

    @SneakyThrows
    @Override
    @Transactional
    public CreateResponseAuthorDTO CreateNewAuthor(CreateAuthorRequest requestDTO){
        validate(requestDTO);
        Authors author = convertToEntity(requestDTO);
        Authors createdAuthor = authorRepository.save(author);
        return convertToDto(createdAuthor);
    }

    @Override
    public List<CreateResponseAuthorDTO> getAllAuthors() {
        List<Authors> authors = authorRepository.findAll();
        if (!authors.isEmpty()) {
            return authors.stream()
                    .map(author -> modelMapper.map(author, CreateResponseAuthorDTO.class))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public CreateResponseAuthorDTO getAuthorById(Long author_id) {
        Optional<Authors> author_optional = authorRepository.findById(author_id);
        if(author_optional.isPresent()){
            return modelMapper.map(author_optional, CreateResponseAuthorDTO.class);
        }
        return null;
    }

    @Override
    public CreateResponseAuthorDTO updateAuthor(Long author_id, CreateAuthorRequest request) {
        Optional<Authors> author_optional = authorRepository.findById(author_id);
        if(author_optional.isPresent()){

            author_optional.map(authors -> {
                authors.setName(request.getName());
                authors.setDOB(request.getDob());
                authors.setAddress(request.getAddress());
                return authorRepository.save(authors);

            });
            return modelMapper.map(author_optional, CreateResponseAuthorDTO.class);
        }
        return null;
    }

    @Override
    public void DeletebyId(Long author_id) {
        authorRepository.deleteById(author_id);
    }

    @Override
    public CreateBookResponseDTO createBook(Long author_id, CreateBookRequestDTO request) {
        Optional<Authors> author_optional = authorRepository.findById(author_id);
        if(author_optional.isPresent()){
            Books book = modelMapper.map(request, Books.class);
            book.setAuthor(author_optional.get());
            Books createdBook = bookRepository.save(book);
            return modelMapper.map(createdBook, CreateBookResponseDTO.class);
        }
        return null;
    }


    private void isValidDob(Date date) {
        LocalDate dob = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();

        if (dob.getYear() > now.getYear()) {
            throw new ValidationErrorException("Invalid year in dob.");
        }
    }

    private void validate(CreateAuthorRequest resquestDTO) {
        if (resquestDTO == null) {
            throw new ValidationErrorException("Body request cannot be empty");
        }

        if (StringUtils.isEmpty(resquestDTO.getName())) {
            throw new ValidationErrorException("name cannot be empty");
        }

        if (StringUtils.isEmpty(resquestDTO.getAddress())) {
            throw new ValidationErrorException("address cannot be empty");
        }

        isValidDob(resquestDTO.getDob());
    }

    private Authors convertToEntity(CreateAuthorRequest resquestDTO) {
        return modelMapper.map(resquestDTO, Authors.class);
    }

    private CreateResponseAuthorDTO convertToDto(Authors author) {
        return modelMapper.map(author, CreateResponseAuthorDTO.class);
    }
}
