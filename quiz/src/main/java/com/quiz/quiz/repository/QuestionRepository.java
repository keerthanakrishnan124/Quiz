package com.quiz.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.quiz.model.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer>{

	List<Questions> findByCategory(String category);
	
	@Query(value = "SELECT * FROM questions q WHERE q.category = ?1 ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(String category);
	
}
