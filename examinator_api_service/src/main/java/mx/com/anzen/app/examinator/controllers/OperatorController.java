/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.anzen.app.examinator.dto.LoginRequest;
import mx.com.anzen.app.examinator.dto.LoginResponse;
import mx.com.anzen.app.examinator.services.OperatorService;
import mx.com.anzen.app.examinator.utils.Constants;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@RestController
@RequestMapping("/operator")
public class OperatorController {

	private OperatorService operatorService;
	
	/**
	 * <p></p>
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<LoginResponse> login(LoginRequest request) throws Exception {
		Integer xAuthToken = operatorService.login(request.getUserLogin(), request.getPassword());
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.X_AUTH_TOKEN, xAuthToken.toString());
		LoginResponse response = new LoginResponse();
		response.setId(xAuthToken);
		return new ResponseEntity<>(response, headers, HttpStatus.ACCEPTED);
	}
	
	/**
	 * <p></p>
	 * 
	 * @param xAuthToken
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> logout(@RequestHeader(Constants.X_AUTH_TOKEN) String xAuthToken) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>("ok", headers, HttpStatus.OK);
	}
}
