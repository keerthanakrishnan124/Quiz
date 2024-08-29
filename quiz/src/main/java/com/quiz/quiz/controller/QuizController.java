package com.quiz.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quiz.model.QuestionView;
import com.quiz.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@GetMapping("/create/{category}")
	public ResponseEntity<String> createQuiz(@PathVariable String category){
		return quizService.createQuiz(category);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionView>> getQuizQuestions(@PathVariable int id){
		return quizService.getQuizQuestions(id);
	}
	
}
