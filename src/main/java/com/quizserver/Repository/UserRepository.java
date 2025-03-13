package com.quizserver.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizserver.entities.User;
import com.quizserver.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByRole(UserRole role);

    User findFirstByEmail(String email);

    Optional<User> findByEmail(String email);

}
