/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.services.impl;

import org.springframework.stereotype.Service;

import mx.com.anzen.app.examinator.services.OperatorService;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@Service("operatorServiceImpl")
public class OperatorServiceImpl implements OperatorService {

	@Override
	public Integer login(String userLogin, String password) throws Exception {
		return null;
	}

	@Override
	public Boolean logout(String xAuthToken) throws Exception {
		return null;
	}

}
