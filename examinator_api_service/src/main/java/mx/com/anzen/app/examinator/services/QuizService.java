/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.services;

import java.util.List;

import mx.com.anzen.app.examinator.dto.Question;
import mx.com.anzen.app.examinator.dto.ResolveQuiz;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
public interface QuizService {

	/**
	 * <p></p>
	 * 
	 * @param profileId
	 * @return
	 * @throws Exception
	 */
	List<Question> getAllQuestionsByProfile(String profileId) throws Exception;
	
	/**
	 * <p></p>
	 * 
	 * @return
	 * @throws Exception
	 */
	Boolean processQuiz(List<ResolveQuiz> response) throws Exception;
}
