package com.tourism.backend.repository;

import com.tourism.backend.entity.Chat;
import com.tourism.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByUser(User user);
}
