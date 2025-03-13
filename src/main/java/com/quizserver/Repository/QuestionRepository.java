package com.quizserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizserver.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
