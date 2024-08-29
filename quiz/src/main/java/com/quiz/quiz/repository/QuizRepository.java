package com.quiz.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quiz.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{

}
