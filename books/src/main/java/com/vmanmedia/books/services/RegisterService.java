package com.vmanmedia.books.services;

import com.vmanmedia.books.dtos.CreateAuthorRequest;
import com.vmanmedia.books.exceptions.ValidationErrorException;
import com.vmanmedia.books.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RegisterService implements IRegisterService {

    @Autowired
    UserRepository userRepository;

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

    }
}
