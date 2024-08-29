package com.quiz.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quiz.model.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer>{

	List<Questions> findByCategory(String category);

}
