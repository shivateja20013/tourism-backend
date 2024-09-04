package com.tourism.backend.repository;

import com.tourism.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User findUserByUsernameAndPasswordAndIsActive(String username, String password, Boolean isActive);
    public List<User> findByIsActive(Boolean isActive);
}
