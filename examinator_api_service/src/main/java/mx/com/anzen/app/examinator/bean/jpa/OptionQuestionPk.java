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
import javax.persistence.Embeddable;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@Embeddable
public class OptionQuestionPk implements Serializable {

	/* serialVersionUID */
	private static final long serialVersionUID = 3458033377316530219L;

	@Column(name = "ID_OPTION")
	private Integer idOption;
	@Column(name = "ID_QUESTION")
	private Integer idQuestion;
	
	/**
	 * @return the idOption
	 */
	public Integer getIdOption() {
		return idOption;
	}
	
	/**
	 * @return the idQuestion
	 */
	public Integer getIdQuestion() {
		return idQuestion;
	}
	
	/**
	 * @param idOption the idOption to set
	 */
	public void setIdOption(Integer idOption) {
		this.idOption = idOption;
	}
	
	/**
	 * @param idQuestion the idQuestion to set
	 */
	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}
}
