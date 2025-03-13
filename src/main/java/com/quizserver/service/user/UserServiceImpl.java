package com.quizserver.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizserver.Repository.UserRepository;
import com.quizserver.entities.User;
import com.quizserver.enums.UserRole;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void createAdminUser() {
        User optionalUser = userRepository.findByRole(UserRole.ADMIN);
        if (optionalUser == null) {
            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@gmail.com");
            user.setRole(UserRole.ADMIN);
            user.setPassword("admin");
            userRepository.save(user);
        }
    }

    public Boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }

    public User createUser(User user) {
        user.setRole(UserRole.USER); // Default new users to USER role
        return userRepository.save(user);
    }

    public User login(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent() && user.getPassword().equals(optionalUser.get().getPassword())) {
            return optionalUser.get(); // No need to modify role, it's already stored correctly
        }
        return null;
    }
}
