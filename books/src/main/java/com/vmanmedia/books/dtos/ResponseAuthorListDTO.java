package com.vmanmedia.books.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseAuthorListDTO implements Serializable {
    private String name;
}
