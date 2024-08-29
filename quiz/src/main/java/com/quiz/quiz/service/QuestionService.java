package com.quiz.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.quiz.model.Questions;
import com.quiz.quiz.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepo;

	public void addQuestion(Questions question) {
		
		questionRepo.save(question);
		
	}

}
