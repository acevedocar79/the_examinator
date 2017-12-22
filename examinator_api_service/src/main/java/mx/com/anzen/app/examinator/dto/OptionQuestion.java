/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
public class OptionQuestion {
	
	@JsonProperty(value = "id_option", required = true)
	private Integer idOption;
	@JsonProperty(value = "answer", required = true)
	private String answer;
	
	/**
	 * @return the subSubSection
	 */
	public Integer getIdOption() {
		return idOption;
	}
	
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	
	/**
	 * @param subSubSection the subSubSection to set
	 */
	public void setIdOption(Integer idOption) {
		this.idOption = idOption;
	}
	
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
