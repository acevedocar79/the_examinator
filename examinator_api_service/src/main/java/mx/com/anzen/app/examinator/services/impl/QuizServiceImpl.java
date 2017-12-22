/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.anzen.app.examinator.bean.repositories.OptionQuestionRepository;
import mx.com.anzen.app.examinator.bean.repositories.QuestionRepository;
import mx.com.anzen.app.examinator.dto.OptionQuestion;
import mx.com.anzen.app.examinator.dto.ProfileExam;
import mx.com.anzen.app.examinator.dto.Question;
import mx.com.anzen.app.examinator.dto.ResolveQuiz;
import mx.com.anzen.app.examinator.services.QuizService;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private OptionQuestionRepository optionQuestionRepository;
	
	@Override
	public List<Question> getAllQuestionsByProfile(String profileId) throws Exception {
		
		List<mx.com.anzen.app.examinator.bean.jpa.Question> questionsDB = questionRepository
				.findByCategoryQuestion(profileId);
		
		List<Question> questions = new ArrayList<>();
		questionsDB.forEach(qDB -> {
			List<mx.com.anzen.app.examinator.bean.jpa.OptionQuestion> optionQuestionDB = optionQuestionRepository
					.findByIdIdQuestion(qDB.getIdQuestion());
			
			Question question = new Question();
			question.setCategory(ProfileExam.valueOf(qDB.getCategoryQuestion()));
			question.setIdQuestion(qDB.getIdQuestion());
			question.setIsMultiAnswer(qDB.getMultiAnswer());
			question.setQuestion(qDB.getQuestion());
			
			List<OptionQuestion> options = new ArrayList<>();
			optionQuestionDB.forEach(oqDB -> {
				OptionQuestion optionQuestion = new OptionQuestion();
				optionQuestion.setAnswer(oqDB.getAnswer());
				optionQuestion.setIdOption(oqDB.getId().getIdOption());
				
				options.add(optionQuestion);
			});
			
			question.setOptions(options);
			questions.add(question);
		});
		
		return questions;
	}

	@Override
	public Boolean processQuiz(List<ResolveQuiz> response) throws Exception {
		Map<String, Integer> results = new HashMap<>();
		response.forEach(r -> {
			Integer resultByCategory = 0;
			mx.com.anzen.app.examinator.bean.jpa.Question question = questionRepository.findOne(r.getIdQuestion());
			
			for(Integer x : r.getIdsAnswers()) {
				mx.com.anzen.app.examinator.bean.jpa.OptionQuestionPk id = new mx.com.anzen.app.examinator.bean.jpa.OptionQuestionPk();
				id.setIdOption(x);
				id.setIdQuestion(r.getIdQuestion());
				
				mx.com.anzen.app.examinator.bean.jpa.OptionQuestion option = optionQuestionRepository.findOne(id);
				if(option.getIsResponse()) {
					resultByCategory ++;
				}
			}
			
			results.put(question.getCategoryQuestion(), resultByCategory);
		});
		
		return true;
	}

}
