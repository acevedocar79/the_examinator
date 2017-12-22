/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
public class ResolveQuiz {

	@JsonProperty(value = "id_question", required = true)
	private Integer idQuestion;
	@JsonProperty(value = "id_answers", required = true)
	private List<Integer> idsAnswers;
	
	/**
	 * @return the idQuestion
	 */
	public Integer getIdQuestion() {
		return idQuestion;
	}
	
	/**
	 * @return the idsAnswers
	 */
	public List<Integer> getIdsAnswers() {
		return idsAnswers;
	}
	
	/**
	 * @param idQuestion the idQuestion to set
	 */
	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	/**
	 * @param idsAnswers the idsAnswers to set
	 */
	public void setIdsAnswers(List<Integer> idsAnswers) {
		this.idsAnswers = idsAnswers;
	}
}
