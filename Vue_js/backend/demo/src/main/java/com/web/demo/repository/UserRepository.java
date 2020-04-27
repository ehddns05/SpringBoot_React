package com.web.demo.repository;

import java.util.Optional;

import com.web.demo.model.User;

public interface UserRepository {

    Optional<User> login(String userId);
}