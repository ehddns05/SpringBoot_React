package com.web.demo.mapper;

import java.util.Optional;

import com.web.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, Long>{

    // public void enrollUser(User user);
    Optional<User> findById(String id);
}