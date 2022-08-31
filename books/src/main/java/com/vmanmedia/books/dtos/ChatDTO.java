package com.vmanmedia.books.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatDTO {
    public enum MessageType{
        CHAT, JOIN, LEAVE
    }

    private MessageType type;
    private String content;
    private String sender;
}
