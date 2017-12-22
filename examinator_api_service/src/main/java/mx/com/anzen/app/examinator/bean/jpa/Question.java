/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.bean.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@Table(name = "QUESTION")
@Entity
public class Question implements Serializable {

	/* serialVersionUID */
	private static final long serialVersionUID = -4216084128481412407L;

	@Id
	@Column(name = "ID_QUESTION")
	private Integer idQuestion;
	@Column(name = "CATEGORY_QUESTION")
	private String categoryQuestion;
	@Column(name = "IS_MULTI_ANSWER")
	private Boolean multiAnswer;
	@Column(name = "QUESTION")
	private String question;
	
	/**
	 * @return the idQuestion
	 */
	public Integer getIdQuestion() {
		return idQuestion;
	}
	
	/**
	 * @return the categoryQuestion
	 */
	public String getCategoryQuestion() {
		return categoryQuestion;
	}
	
	/**
	 * @return the multiAnswer
	 */
	public Boolean getMultiAnswer() {
		return multiAnswer;
	}
	
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * @param idQuestion the idQuestion to set
	 */
	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	/**
	 * @param categoryQuestion the categoryQuestion to set
	 */
	public void setCategoryQuestion(String categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}
	
	/**
	 * @param multiAnswer the multiAnswer to set
	 */
	public void setMultiAnswer(Boolean multiAnswer) {
		this.multiAnswer = multiAnswer;
	}
	
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
}
