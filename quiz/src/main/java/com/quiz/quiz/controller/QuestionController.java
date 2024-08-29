package com.quiz.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quiz.model.Questions;
import com.quiz.quiz.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/add")
	public void addQuestion(@PathVariable Questions question) {
		
		questionService.addQuestion(question);
	}

}
