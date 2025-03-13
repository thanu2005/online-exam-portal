package com.quizserver.service.user;

import org.springframework.stereotype.Service;

import com.quizserver.entities.User;

@Service
public interface UserService {
    User createUser(User user);

    Boolean hasUserWithEmail(String email);

    User login(User user);
}
