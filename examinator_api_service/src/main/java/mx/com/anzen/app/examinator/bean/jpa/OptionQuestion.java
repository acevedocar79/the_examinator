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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@Table(name = "OPTION_QUESTION")
@Entity
public class OptionQuestion implements Serializable {

	/* serialVersionUID */
	private static final long serialVersionUID = -851142375271286242L;
	
	@EmbeddedId
	private OptionQuestionPk id;
	@Column(name = "ANSWER")
	private String answer;
	@Column(name = "IS_A_RESPONSE")
	private Boolean isResponse;
	
	/**
	 * @return the id
	 */
	public OptionQuestionPk getId() {
		return id;
	}
	
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	
	/**
	 * @return the isResponse
	 */
	public Boolean getIsResponse() {
		return isResponse;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(OptionQuestionPk id) {
		this.id = id;
	}
	
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	/**
	 * @param isResponse the isResponse to set
	 */
	public void setIsResponse(Boolean isResponse) {
		this.isResponse = isResponse;
	}
}
