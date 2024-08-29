package com.quiz.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quiz.model.Questions;
import com.quiz.quiz.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepo;

	public ResponseEntity<String> addQuestion(Questions question) {
		
		questionRepo.save(question);
		return new ResponseEntity<>("Success",HttpStatus.OK);
		
	}

	public ResponseEntity<List<Questions>> getAllQuestions() {
		try {
		return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
		
		try {
			return new ResponseEntity<>(questionRepo.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}

}
