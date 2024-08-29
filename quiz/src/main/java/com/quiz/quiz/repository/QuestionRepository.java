package com.quiz.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quiz.model.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer>{

}
