package com.quiz.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quiz.model.QuestionView;
import com.quiz.quiz.model.Questions;
import com.quiz.quiz.model.Quiz;
import com.quiz.quiz.model.Response;
import com.quiz.quiz.repository.QuestionRepository;
import com.quiz.quiz.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepo;
	
	@Autowired
	private QuestionRepository questionRepo;

	public ResponseEntity<String> createQuiz(String category) {
		
		try {
		
		List<Questions> questions=questionRepo.findRandomQuestionsByCategory(category);
		
		Quiz quiz=new Quiz();
		quiz.setQuestions(questions);
		
		quizRepo.save(quiz);
		
		int id=quiz.getId();
		String st=Integer.toString(id);
		return new ResponseEntity<>("Success. \nQuiz id="+id, HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Not Success", HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<QuestionView>> getQuizQuestions(int id) {
		
		try {
			Optional<Quiz> quiz=quizRepo.findById(id);
			List<Questions> questions=quiz.get().getQuestions();
			List<QuestionView> questionView=new ArrayList<>();
			
			for(Questions q:questions) {
				QuestionView quest=new QuestionView(
						q.getId(),
						q.getQuestion(),
						q.getOption1(),
						q.getOption2(),
						q.getOption3(),
						q.getOption4());
				questionView.add(quest);
			}
			
			return new ResponseEntity<>(questionView,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
		
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
		try {
		Optional<Quiz> quiz=quizRepo.findById(id);
		List<Questions> questions=quiz.get().getQuestions();
		
		int rightAnswer=0;
		int i=0;
		
		for(Response r:responses) {
			if(r.getResponse().equals(questions.get(i).getRightAnswer())) {
				rightAnswer++;
			}
			i++;
		}
		return new ResponseEntity<>(rightAnswer,HttpStatus.OK);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
	}

	
}
