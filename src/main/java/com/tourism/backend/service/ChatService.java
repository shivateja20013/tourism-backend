package com.tourism.backend.service;

import com.tourism.backend.dto.ChatDTO;
import com.tourism.backend.entity.Chat;
import com.tourism.backend.entity.User;
import com.tourism.backend.repository.ChatRepository;
import com.tourism.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    public String createChat(ChatDTO chatDTO) {
        Chat userChat = new Chat();
        userChat.setUser(this.userRepository.findUserByUsername(chatDTO.getUsername()));
        userChat.setMessage(chatDTO.getUserMessage());
        userChat.setIsSystemMessage(false);
        chatRepository.save(userChat);
        Chat systemChat = new Chat();
        systemChat.setUser(this.userRepository.findUserByUsername(chatDTO.getUsername()));
        systemChat.setMessage(chatDTO.getSystemMessage());
        systemChat.setIsSystemMessage(true);
        chatRepository.save(systemChat);
        return "Saved";
    }

    public List<Chat> getChatsByUser(String username) {
        User user = this.userRepository.findUserByUsername(username);
        return chatRepository.findByUser(user);
    }
}
