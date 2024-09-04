package com.tourism.backend.controller;

import com.tourism.backend.dto.ChatDTO;
import com.tourism.backend.entity.Chat;
import com.tourism.backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ResponseEntity<String> createChat(@RequestBody ChatDTO chatDTO) {
        String createdChat = chatService.createChat(chatDTO);
        return new ResponseEntity<>(createdChat, HttpStatus.CREATED);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Chat>> getChatsByUser(@PathVariable String username) {
        List<Chat> chats = chatService.getChatsByUser(username);
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

}
