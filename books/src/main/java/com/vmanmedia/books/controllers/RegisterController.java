package com.vmanmedia.books.controllers;

import com.vmanmedia.books.consumer.VmanQueueConsumer;
import com.vmanmedia.books.dtos.RegisterRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    VmanQueueConsumer consumer;

    @PostMapping("/register")
    public ResponseEntity<String> handleRegister(@RequestBody RegisterRequestDTO request) {

    }
}
