package com.quizserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizserver.entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
