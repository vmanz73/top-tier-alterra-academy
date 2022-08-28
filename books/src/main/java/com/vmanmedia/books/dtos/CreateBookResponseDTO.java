package com.vmanmedia.books.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vmanmedia.books.entities.Authors;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class CreateBookResponseDTO {
    private Long book_id;

    private String title;

    private Integer total_pages;

    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date published_at;

    private CreateResponseAuthorDTO author;

    @JsonIgnore
    private Date created_at;

    @JsonIgnore
    private Date updated_at;
}
