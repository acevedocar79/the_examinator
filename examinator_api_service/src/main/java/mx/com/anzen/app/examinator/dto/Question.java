/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V. Mexico D.F. All rights reserved. 
 * 
 * THIS SOFTWARE IS CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE
 * COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p></p> 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>} 
 * @version examinator-api-service 
 * @since examinator-api-service 
 * @category
 */
public class Question {

	@JsonProperty(value = "category", required = true)
	private ProfileExam category;
	@JsonProperty(value = "question", required = true)
	private String question;
	@JsonProperty(value = "id_question", required = true)
	private Integer idQuestion;
	@JsonProperty(value = "is_multi_answer", required = true)
	private Boolean isMultiAnswer;
	@JsonProperty(value = "answers", required = true)
	private List<OptionQuestion> options;

	/**
	 * @return the subSession
	 */
	public ProfileExam getCategory() {
		return category;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @return the idQuestion
	 */
	public Integer getIdQuestion() {
		return idQuestion;
	}

	/**
	 * @return the isMultiAnswer
	 */
	public Boolean getIsMultiAnswer() {
		return isMultiAnswer;
	}

	/**
	 * @return the options
	 */
	public List<OptionQuestion> getOptions() {
		return options;
	}

	/**
	 * @param subSession the subSession to set
	 */
	public void setCategory(ProfileExam category) {
		this.category = category;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @param idQuestion the idQuestion to set
	 */
	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}

	/**
	 * @param isMultiAnswer the isMultiAnswer to set
	 */
	public void setIsMultiAnswer(Boolean isMultiAnswer) {
		this.isMultiAnswer = isMultiAnswer;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(List<OptionQuestion> options) {
		this.options = options;
	}
}
