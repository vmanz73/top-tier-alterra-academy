package com.altera.task8.controler;

import com.altera.task8.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.altera.task8.entity.Message;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageRepository repo;

    @GetMapping("/")
    public String index(){
        return "Hello world";
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/v1/message")
    public Message save(@RequestBody CreateMessageRequest request){
        Message message = new Message();
        message.setMessage(request.getMessage());
        Message message_instance = repo.save(message);
        return message_instance;
    }

    @GetMapping("/v1/message")
    public List<Message> getAll(){
        List<Message> message = repo.findAll();
        return message;
    }

    @DeleteMapping("/v1/message/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void DeleteMessage(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
