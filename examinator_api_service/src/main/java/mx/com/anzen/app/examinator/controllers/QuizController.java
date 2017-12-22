/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.anzen.app.examinator.dto.ProfileExam;
import mx.com.anzen.app.examinator.dto.Question;
import mx.com.anzen.app.examinator.dto.ResolveQuiz;
import mx.com.anzen.app.examinator.services.QuizService;
import mx.com.anzen.app.examinator.utils.Constants;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@RestController
@RequestMapping("/quiz")
@Api(value = "quizcontroller")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	/**
	 * <p></p>
	 * 
	 * @param profileId
	 * @return
	 */
	@ApiOperation(value = "getAllQuestions")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "error in service")
	})
	@RequestMapping(value = "/getQuestions/{profileId}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Question>> getQuestionsByProfile(@RequestHeader(Constants.X_AUTH_TOKEN) 
			String xAuthToken, @PathVariable ProfileExam profileId) throws Exception {
		
		System.out.println(profileId);
		List<Question> response = quizService.getAllQuestionsByProfile(profileId.name());
		System.out.println("fin");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * <p></p>
	 * 
	 * @param answers
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "getAllQuestions")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "error in service")
	})
	@RequestMapping(value = "/processAnswers", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> processQuiz(@RequestBody List<ResolveQuiz> answers) throws Exception {
		
		System.out.println(answers);
		return new ResponseEntity<>("OK", HttpStatus.ACCEPTED);
	}
}
