/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.dto;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
public enum ProfileExam {

	JAVA_JR("JAVA_JR"),
	JAVA_ST("JAVA_ST"),
	JAVA_SR("JAVA_SR"),
	JAVA_AR("JAVA_AR");
	
	private String name;
	
	/**
	 * @param name
	 */
	private ProfileExam(String name) {
		this.name = name;
	}
	
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
}
