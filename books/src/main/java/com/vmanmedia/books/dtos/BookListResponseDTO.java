package com.vmanmedia.books.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BookListResponseDTO implements Serializable {
    private Long book_id;

    private String title;

    private String isbn;

    private ResponseAuthorListDTO author;

    @JsonIgnore
    private Date created_at;

    @JsonIgnore
    private Date updated_at;
}
