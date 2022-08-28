package com.vmanmedia.books.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequestDTO {
    @NotBlank
    private String phone;

    @NotBlank
    private String password;
}
