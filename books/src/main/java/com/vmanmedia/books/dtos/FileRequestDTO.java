package com.vmanmedia.books.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
public class FileRequestDTO implements Serializable {

    private MultipartFile file;
}
