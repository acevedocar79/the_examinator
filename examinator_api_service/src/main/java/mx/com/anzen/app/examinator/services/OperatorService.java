/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.services;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
public interface OperatorService {

	/**
	 * <p>this create a X-AUTH-TOKEN</p>
	 * 
	 * @param userLogin
	 * @param password
	 * @return
	 * @throws Exception
	 */
	Integer login(String userLogin, String password) throws Exception;
	
	/**
	 * <p></p>
	 * 
	 * @param xAuthToken
	 * @return
	 * @throws Exception
	 */
	Boolean logout(String xAuthToken) throws Exception;
}
