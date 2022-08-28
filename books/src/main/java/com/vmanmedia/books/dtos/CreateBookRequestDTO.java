package com.vmanmedia.books.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vmanmedia.books.entities.Authors;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateBookRequestDTO {
    private String title;

    private Integer total_pages;

    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date published_at;

}
